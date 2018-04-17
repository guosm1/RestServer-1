
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
    "count",
    "_shards"
})
public class Jobs {

    @JsonProperty("count")
    private Double count;
    @JsonProperty("_shards")
    private Shards_ shards;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("count")
    public Double getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Double count) {
        this.count = count;
    }

    @JsonProperty("_shards")
    public Shards_ getShards() {
        return shards;
    }

    @JsonProperty("_shards")
    public void setShards(Shards_ shards) {
        this.shards = shards;
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
        return new ToStringBuilder(this).append("count", count).append("shards", shards).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(count).append(shards).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Jobs) == false) {
            return false;
        }
        Jobs rhs = ((Jobs) other);
        return new EqualsBuilder().append(count, rhs.count).append(shards, rhs.shards).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
