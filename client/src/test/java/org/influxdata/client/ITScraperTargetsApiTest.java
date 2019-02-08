/*
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.influxdata.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.influxdata.client.domain.Bucket;
import org.influxdata.client.domain.Label;
import org.influxdata.client.domain.Organization;
import org.influxdata.client.domain.ResourceMember;
import org.influxdata.client.domain.ScraperTarget;
import org.influxdata.client.domain.ScraperTargetResponse;
import org.influxdata.client.domain.User;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 * @author Jakub Bednar (bednar@github) (22/01/2019 08:23)
 */
@RunWith(JUnitPlatform.class)
class ITScraperTargetsApiTest extends AbstractITClientTest {

    private ScraperTargetsApi scraperTargetsApi;
    private UsersApi usersApi;
    private Bucket bucket;

    @BeforeEach
    void setUp() {

        scraperTargetsApi = influxDBClient.getScraperTargetsApi();
        usersApi = influxDBClient.getUsersApi();
        bucket = influxDBClient.getBucketsApi().findBucketByName("my-bucket");
    }

    @Test
    void createScraperTarget() {

        Organization organization = findMyOrg();
        ScraperTargetResponse scraper = scraperTargetsApi.createScraperTarget(generateName("InfluxDB scraper"),
                "http://localhost:9999", bucket.getId(), organization.getId());

        Assertions.assertThat(scraper).isNotNull();
        Assertions.assertThat(scraper.getBucketName()).isEqualTo("my-bucket");
        Assertions.assertThat(scraper.getOrganizationName()).isEqualTo("my-org");
        Assertions.assertThat(scraper.getLinks())
                .hasSize(3)
                .hasEntrySatisfying("bucket", value -> Assertions.assertThat(value).isEqualTo("/api/v2/buckets/" + bucket.getId()))
                .hasEntrySatisfying("organization", value -> Assertions.assertThat(value).isEqualTo("/api/v2/orgs/" + organization.getId()))
                .hasEntrySatisfying("self", value -> Assertions.assertThat(value).isEqualTo("/api/v2/scrapers/" + scraper.getId()));
    }

    @Test
    void updateScraper() {

        ScraperTarget scraper = scraperTargetsApi.createScraperTarget(generateName("InfluxDB scraper"),
                "http://localhost:9999", bucket.getId(), findMyOrg().getId());

        scraper.setName("Name updated");

        ScraperTargetResponse updated = scraperTargetsApi.updateScraperTarget(scraper);

        Assertions.assertThat(updated.getName()).isEqualTo("Name updated");
    }

    @Test
    void findScrapers() {

        int size = scraperTargetsApi.findScraperTargets().size();

        scraperTargetsApi.createScraperTarget(generateName("InfluxDB scraper"),
                "http://localhost:9999", bucket.getId(), findMyOrg().getId());

        List<ScraperTargetResponse> scraperTargets = scraperTargetsApi.findScraperTargets();
        Assertions.assertThat(scraperTargets).hasSize(size + 1);
    }

    @Test
    void findScraperByID() {

        ScraperTargetResponse scraper = scraperTargetsApi.createScraperTarget(generateName("InfluxDB scraper"),
                "http://localhost:9999", bucket.getId(), findMyOrg().getId());

        ScraperTargetResponse scraperByID =  scraperTargetsApi.findScraperTargetByID(scraper.getId());

        Assertions.assertThat(scraperByID).isNotNull();
        Assertions.assertThat(scraperByID.getId()).isEqualTo(scraper.getId());
        Assertions.assertThat(scraperByID.getName()).isEqualTo(scraper.getName());
    }

    @Test
    void findScraperByIDNull() {

        ScraperTargetResponse scraper = scraperTargetsApi.findScraperTargetByID("020f755c3c082000");

        Assertions.assertThat(scraper).isNull();
    }

    @Test
    void deleteScraper() {

        ScraperTargetResponse createdScraper = scraperTargetsApi.createScraperTarget(generateName("InfluxDB scraper"),
                "http://localhost:9999", bucket.getId(), findMyOrg().getId());
        Assertions.assertThat(createdScraper).isNotNull();

        ScraperTargetResponse foundScraper = scraperTargetsApi.findScraperTargetByID(createdScraper.getId());
        Assertions.assertThat(foundScraper).isNotNull();

        // delete scraper
        scraperTargetsApi.deleteScraperTarget(createdScraper);

        foundScraper = scraperTargetsApi.findScraperTargetByID(createdScraper.getId());
        Assertions.assertThat(foundScraper).isNull();
    }

    @Test
    @Disabled
    //TODO https://github.com/influxdata/influxdb/issues/11767
    void member() {

        ScraperTarget scraper =  scraperTargetsApi.createScraperTarget(generateName("InfluxDB scraper"),
                "http://localhost:9999", bucket.getId(), findMyOrg().getId());

        List<ResourceMember> members = scraperTargetsApi.getMembers(scraper);
        Assertions.assertThat(members).hasSize(0);

        User user = usersApi.createUser(generateName("Luke Health"));

        ResourceMember resourceMember = scraperTargetsApi.addMember(user, scraper);
        Assertions.assertThat(resourceMember).isNotNull();
        Assertions.assertThat(resourceMember.getUserID()).isEqualTo(user.getId());
        Assertions.assertThat(resourceMember.getUserName()).isEqualTo(user.getName());
        Assertions.assertThat(resourceMember.getRole()).isEqualTo(ResourceMember.UserType.MEMBER);

        members = scraperTargetsApi.getMembers(scraper);
        Assertions.assertThat(members).hasSize(1);
        Assertions.assertThat(members.get(0).getRole()).isEqualTo(ResourceMember.UserType.MEMBER);
        Assertions.assertThat(members.get(0).getUserID()).isEqualTo(user.getId());
        Assertions.assertThat(members.get(0).getUserName()).isEqualTo(user.getName());

        scraperTargetsApi.deleteMember(user, scraper);

        members = scraperTargetsApi.getMembers(scraper);
        Assertions.assertThat(members).hasSize(0);
    }

    @Test
    @Disabled
    //TODO https://github.com/influxdata/influxdb/issues/11767
    void owner() {

        ScraperTarget scraper =  scraperTargetsApi.createScraperTarget(generateName("InfluxDB scraper"),
                "http://localhost:9999", bucket.getId(), findMyOrg().getId());

        List<ResourceMember> owners = scraperTargetsApi.getOwners(scraper);
        Assertions.assertThat(owners).hasSize(1);

        User user = usersApi.createUser(generateName("Luke Health"));

        ResourceMember resourceMember = scraperTargetsApi.addOwner(user, scraper);
        Assertions.assertThat(resourceMember).isNotNull();
        Assertions.assertThat(resourceMember.getUserID()).isEqualTo(user.getId());
        Assertions.assertThat(resourceMember.getUserName()).isEqualTo(user.getName());
        Assertions.assertThat(resourceMember.getRole()).isEqualTo(ResourceMember.UserType.OWNER);

        owners = scraperTargetsApi.getOwners(scraper);
        Assertions.assertThat(owners).hasSize(2);
        Assertions.assertThat(owners.get(1).getRole()).isEqualTo(ResourceMember.UserType.OWNER);
        Assertions.assertThat(owners.get(1).getUserID()).isEqualTo(user.getId());
        Assertions.assertThat(owners.get(1).getUserName()).isEqualTo(user.getName());

        scraperTargetsApi.deleteOwner(user, scraper);

        owners = scraperTargetsApi.getOwners(scraper);
        Assertions.assertThat(owners).hasSize(1);
    }

    @Test
    @Disabled
    //TODO https://github.com/influxdata/influxdb/issues/11767
    void labels() {

        LabelsApi labelsApi = influxDBClient.getLabelsApi();

        ScraperTarget scraper =  scraperTargetsApi.createScraperTarget(generateName("InfluxDB scraper"),
                "http://localhost:9999", bucket.getId(), findMyOrg().getId());

        Map<String, String> properties = new HashMap<>();
        properties.put("color", "green");
        properties.put("location", "west");

        Label label = labelsApi.createLabel(generateName("Cool Resource"), properties);

        List<Label> labels = scraperTargetsApi.getLabels(scraper);
        Assertions.assertThat(labels).hasSize(0);

        Label addedLabel = scraperTargetsApi.addLabel(label, scraper);
        Assertions.assertThat(addedLabel).isNotNull();
        Assertions.assertThat(addedLabel.getId()).isEqualTo(label.getId());
        Assertions.assertThat(addedLabel.getName()).isEqualTo(label.getName());
        Assertions.assertThat(addedLabel.getProperties()).isEqualTo(label.getProperties());

        labels = scraperTargetsApi.getLabels(scraper);
        Assertions.assertThat(labels).hasSize(1);
        Assertions.assertThat(labels.get(0).getId()).isEqualTo(label.getId());
        Assertions.assertThat(labels.get(0).getName()).isEqualTo(label.getName());

        scraperTargetsApi.deleteLabel(label, scraper);

        labels = scraperTargetsApi.getLabels(scraper);
        Assertions.assertThat(labels).hasSize(0);
    }
}