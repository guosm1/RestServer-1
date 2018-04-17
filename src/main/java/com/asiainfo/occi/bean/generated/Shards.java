
package com.asiainfo.occi.bean.generated;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "total",
    "successful",
    "failed"
})
public class Shards {

    @JsonProperty("total")
    private Double total;
    @JsonProperty("successful")
    private Double successful;
    @JsonProperty("failed")
    private String failed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("total")
    public Double getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Double total) {
        this.total = total;
    }

    @JsonProperty("successful")
    public Double getSuccessful() {
        return successful;
    }

    @JsonProperty("successful")
    public void setSuccessful(Double successful) {
        this.successful = successful;
    }

    @JsonProperty("failed")
    public String getFailed() {
        return failed;
    }

    @JsonProperty("failed")
    public void setFailed(String failed) {
        this.failed = failed;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("total", total).append("successful", successful).append("failed", failed).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(total).append(failed).append(additionalProperties).append(successful).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Shards) == false) {
            return false;
        }
        Shards rhs = ((Shards) other);
        return new EqualsBuilder().append(total, rhs.total).append(failed, rhs.failed).append(additionalProperties, rhs.additionalProperties).append(successful, rhs.successful).isEquals();
    }

}
