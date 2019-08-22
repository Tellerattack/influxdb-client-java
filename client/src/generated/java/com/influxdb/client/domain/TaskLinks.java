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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * TaskLinks
 */

public class TaskLinks {
  public static final String SERIALIZED_NAME_SELF = "self";
  @SerializedName(SERIALIZED_NAME_SELF)
  private String self;

  public static final String SERIALIZED_NAME_OWNERS = "owners";
  @SerializedName(SERIALIZED_NAME_OWNERS)
  private String owners;

  public static final String SERIALIZED_NAME_MEMBERS = "members";
  @SerializedName(SERIALIZED_NAME_MEMBERS)
  private String members;

  public static final String SERIALIZED_NAME_RUNS = "runs";
  @SerializedName(SERIALIZED_NAME_RUNS)
  private String runs;

  public static final String SERIALIZED_NAME_LOGS = "logs";
  @SerializedName(SERIALIZED_NAME_LOGS)
  private String logs;

  public static final String SERIALIZED_NAME_LABELS = "labels";
  @SerializedName(SERIALIZED_NAME_LABELS)
  private String labels;

   /**
   * URI of resource.
   * @return self
  **/
  @ApiModelProperty(value = "URI of resource.")
  public String getSelf() {
    return self;
  }

   /**
   * URI of resource.
   * @return owners
  **/
  @ApiModelProperty(value = "URI of resource.")
  public String getOwners() {
    return owners;
  }

   /**
   * URI of resource.
   * @return members
  **/
  @ApiModelProperty(value = "URI of resource.")
  public String getMembers() {
    return members;
  }

   /**
   * URI of resource.
   * @return runs
  **/
  @ApiModelProperty(value = "URI of resource.")
  public String getRuns() {
    return runs;
  }

   /**
   * URI of resource.
   * @return logs
  **/
  @ApiModelProperty(value = "URI of resource.")
  public String getLogs() {
    return logs;
  }

   /**
   * URI of resource.
   * @return labels
  **/
  @ApiModelProperty(value = "URI of resource.")
  public String getLabels() {
    return labels;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskLinks taskLinks = (TaskLinks) o;
    return Objects.equals(this.self, taskLinks.self) &&
        Objects.equals(this.owners, taskLinks.owners) &&
        Objects.equals(this.members, taskLinks.members) &&
        Objects.equals(this.runs, taskLinks.runs) &&
        Objects.equals(this.logs, taskLinks.logs) &&
        Objects.equals(this.labels, taskLinks.labels);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, owners, members, runs, logs, labels);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskLinks {\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    owners: ").append(toIndentedString(owners)).append("\n");
    sb.append("    members: ").append(toIndentedString(members)).append("\n");
    sb.append("    runs: ").append(toIndentedString(runs)).append("\n");
    sb.append("    logs: ").append(toIndentedString(logs)).append("\n");
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
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
