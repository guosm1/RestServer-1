
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
    "range_logdate"
})
public class Aggregations_ {

    @JsonProperty("range_logdate")
    private RangeLogdate rangeLogdate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("range_logdate")
    public RangeLogdate getRangeLogdate() {
        return rangeLogdate;
    }

    @JsonProperty("range_logdate")
    public void setRangeLogdate(RangeLogdate rangeLogdate) {
        this.rangeLogdate = rangeLogdate;
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
        return new ToStringBuilder(this).append("rangeLogdate", rangeLogdate).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(rangeLogdate).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Aggregations_) == false) {
            return false;
        }
        Aggregations_ rhs = ((Aggregations_) other);
        return new EqualsBuilder().append(rangeLogdate, rhs.rangeLogdate).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
