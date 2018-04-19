
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
    "total",
    "max_score",
    "hits"
})
public class Hits_ {

    @JsonProperty("total")
    private Double total;
    @JsonProperty("max_score")
    private String maxScore;
    @JsonProperty("hits")
    private List<String> hits = new ArrayList<String>();
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

    @JsonProperty("max_score")
    public String getMaxScore() {
        return maxScore;
    }

    @JsonProperty("max_score")
    public void setMaxScore(String maxScore) {
        this.maxScore = maxScore;
    }

    @JsonProperty("hits")
    public List<String> getHits() {
        return hits;
    }

    @JsonProperty("hits")
    public void setHits(List<String> hits) {
        this.hits = hits;
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
        return new ToStringBuilder(this).append("total", total).append("maxScore", maxScore).append("hits", hits).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(hits).append(total).append(additionalProperties).append(maxScore).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Hits_) == false) {
            return false;
        }
        Hits_ rhs = ((Hits_) other);
        return new EqualsBuilder().append(hits, rhs.hits).append(total, rhs.total).append(additionalProperties, rhs.additionalProperties).append(maxScore, rhs.maxScore).isEquals();
    }

}
