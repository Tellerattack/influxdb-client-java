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
import com.influxdb.client.domain.Check;
import com.influxdb.client.domain.Links;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Checks
 */

public class Checks {
  public static final String SERIALIZED_NAME_CHECKS = "checks";
  @SerializedName(SERIALIZED_NAME_CHECKS)
  private List<Check> checks = new ArrayList<>();

  public static final String SERIALIZED_NAME_LINKS = "links";
  @SerializedName(SERIALIZED_NAME_LINKS)
  private Links links = null;

  public Checks checks(List<Check> checks) {
    this.checks = checks;
    return this;
  }

  public Checks addChecksItem(Check checksItem) {
    if (this.checks == null) {
      this.checks = new ArrayList<>();
    }
    this.checks.add(checksItem);
    return this;
  }

   /**
   * Get checks
   * @return checks
  **/
  @ApiModelProperty(value = "")
  public List<Check> getChecks() {
    return checks;
  }

  public void setChecks(List<Check> checks) {
    this.checks = checks;
  }

  public Checks links(Links links) {
    this.links = links;
    return this;
  }

   /**
   * Get links
   * @return links
  **/
  @ApiModelProperty(value = "")
  public Links getLinks() {
    return links;
  }

  public void setLinks(Links links) {
    this.links = links;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Checks checks = (Checks) o;
    return Objects.equals(this.checks, checks.checks) &&
        Objects.equals(this.links, checks.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(checks, links);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Checks {\n");
    sb.append("    checks: ").append(toIndentedString(checks)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
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

