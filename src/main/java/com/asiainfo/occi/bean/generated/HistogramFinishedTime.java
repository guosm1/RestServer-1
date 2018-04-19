
package com.asiainfo.occi.bean.generated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "buckets"
})
public class HistogramFinishedTime {

    @JsonProperty("buckets")
    private List<Bucket_> buckets = new ArrayList<Bucket_>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("buckets")
    public List<Bucket_> getBuckets() {
        return buckets;
    }

    @JsonProperty("buckets")
    public void setBuckets(List<Bucket_> buckets) {
        this.buckets = buckets;
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
        return new ToStringBuilder(this).append("buckets", buckets).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(buckets).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof HistogramFinishedTime) == false) {
            return false;
        }
        HistogramFinishedTime rhs = ((HistogramFinishedTime) other);
        return new EqualsBuilder().append(buckets, rhs.buckets).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
