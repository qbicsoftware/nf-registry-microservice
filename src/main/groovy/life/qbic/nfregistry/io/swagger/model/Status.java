package life.qbic.nfregistry.io.swagger.model;

import javax.validation.constraints.*;
import javax.validation.Valid;


import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Status   {
  
  private @Valid String date = null;

public enum StatusEnum {

    ALIVE(String.valueOf("alive")), DEAD(String.valueOf("dead"));


    private String value;

    StatusEnum (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static StatusEnum fromValue(String v) {
        for (StatusEnum b : StatusEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}

  private @Valid StatusEnum status = null;

  /**
   * The current date-time in ISO 8601 format specification
   **/
  public Status date(String date) {
    this.date = date;
    return this;
  }

  
  @ApiModelProperty(example = "2018-07-30T14:22:21+0000", value = "The current date-time in ISO 8601 format specification")
  @JsonProperty("date")
  public String getDate() {
    return date;
  }
  public void setDate(String date) {
    this.date = date;
  }

  /**
   * The status of the database connection
   **/
  public Status status(StatusEnum status) {
    this.status = status;
    return this;
  }

  
  @ApiModelProperty(example = "alive", value = "The status of the database connection")
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }
  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Status status = (Status) o;
    return Objects.equals(date, status.date) &&
        Objects.equals(status, status.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Status {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

