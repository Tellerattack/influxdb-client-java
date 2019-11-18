/*
 * Influx API Service
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * OpenAPI spec version: 0.1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.influxdb.client.domain;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.influxdb.client.domain.Label;
import com.influxdb.client.domain.PkgChart;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * PkgSummarySummaryDashboards
 */

public class PkgSummarySummaryDashboards {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_ORG_I_D = "orgID";
  @SerializedName(SERIALIZED_NAME_ORG_I_D)
  private String orgID;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_LABEL_ASSOCIATIONS = "labelAssociations";
  @SerializedName(SERIALIZED_NAME_LABEL_ASSOCIATIONS)
  private List<Label> labelAssociations = new ArrayList<>();

  public static final String SERIALIZED_NAME_CHARTS = "charts";
  @SerializedName(SERIALIZED_NAME_CHARTS)
  private List<PkgChart> charts = new ArrayList<>();

  public PkgSummarySummaryDashboards id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PkgSummarySummaryDashboards orgID(String orgID) {
    this.orgID = orgID;
    return this;
  }

   /**
   * Get orgID
   * @return orgID
  **/
  @ApiModelProperty(value = "")
  public String getOrgID() {
    return orgID;
  }

  public void setOrgID(String orgID) {
    this.orgID = orgID;
  }

  public PkgSummarySummaryDashboards name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PkgSummarySummaryDashboards description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PkgSummarySummaryDashboards labelAssociations(List<Label> labelAssociations) {
    this.labelAssociations = labelAssociations;
    return this;
  }

  public PkgSummarySummaryDashboards addLabelAssociationsItem(Label labelAssociationsItem) {
    if (this.labelAssociations == null) {
      this.labelAssociations = new ArrayList<>();
    }
    this.labelAssociations.add(labelAssociationsItem);
    return this;
  }

   /**
   * Get labelAssociations
   * @return labelAssociations
  **/
  @ApiModelProperty(value = "")
  public List<Label> getLabelAssociations() {
    return labelAssociations;
  }

  public void setLabelAssociations(List<Label> labelAssociations) {
    this.labelAssociations = labelAssociations;
  }

  public PkgSummarySummaryDashboards charts(List<PkgChart> charts) {
    this.charts = charts;
    return this;
  }

  public PkgSummarySummaryDashboards addChartsItem(PkgChart chartsItem) {
    if (this.charts == null) {
      this.charts = new ArrayList<>();
    }
    this.charts.add(chartsItem);
    return this;
  }

   /**
   * Get charts
   * @return charts
  **/
  @ApiModelProperty(value = "")
  public List<PkgChart> getCharts() {
    return charts;
  }

  public void setCharts(List<PkgChart> charts) {
    this.charts = charts;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PkgSummarySummaryDashboards pkgSummarySummaryDashboards = (PkgSummarySummaryDashboards) o;
    return Objects.equals(this.id, pkgSummarySummaryDashboards.id) &&
        Objects.equals(this.orgID, pkgSummarySummaryDashboards.orgID) &&
        Objects.equals(this.name, pkgSummarySummaryDashboards.name) &&
        Objects.equals(this.description, pkgSummarySummaryDashboards.description) &&
        Objects.equals(this.labelAssociations, pkgSummarySummaryDashboards.labelAssociations) &&
        Objects.equals(this.charts, pkgSummarySummaryDashboards.charts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, orgID, name, description, labelAssociations, charts);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PkgSummarySummaryDashboards {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    orgID: ").append(toIndentedString(orgID)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    labelAssociations: ").append(toIndentedString(labelAssociations)).append("\n");
    sb.append("    charts: ").append(toIndentedString(charts)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

