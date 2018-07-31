package io.swagger.model;

import javax.validation.constraints.*;
import javax.validation.Valid;


import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Info   {
  
  private @Valid String name = null;
  private @Valid String author = null;
  private @Valid String email = null;
  private @Valid String version = null;
  private @Valid String apiv = null;

  /**
   * Application name
   **/
  public Info name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(example = "nfregistry", value = "Application name")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Author
   **/
  public Info author(String author) {
    this.author = author;
    return this;
  }

  
  @ApiModelProperty(example = "Sven Fillinger", value = "Author")
  @JsonProperty("author")
  public String getAuthor() {
    return author;
  }
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * Author&#39;s email address
   **/
  public Info email(String email) {
    this.email = email;
    return this;
  }

  
  @ApiModelProperty(example = "sven.fillinger@qbic.uni-tuebingen.de", value = "Author's email address")
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Microservice version
   **/
  public Info version(String version) {
    this.version = version;
    return this;
  }

  
  @ApiModelProperty(example = "1.0.1", value = "Microservice version")
  @JsonProperty("version")
  public String getVersion() {
    return version;
  }
  public void setVersion(String version) {
    this.version = version;
  }

  /**
   * API version
   **/
  public Info apiv(String apiv) {
    this.apiv = apiv;
    return this;
  }

  
  @ApiModelProperty(example = "v1", value = "API version")
  @JsonProperty("apiv")
  public String getApiv() {
    return apiv;
  }
  public void setApiv(String apiv) {
    this.apiv = apiv;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Info info = (Info) o;
    return Objects.equals(name, info.name) &&
        Objects.equals(author, info.author) &&
        Objects.equals(email, info.email) &&
        Objects.equals(version, info.version) &&
        Objects.equals(apiv, info.apiv);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, author, email, version, apiv);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Info {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    apiv: ").append(toIndentedString(apiv)).append("\n");
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

