
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
    "took",
    "timed_out",
    "_shards",
    "hits",
    "aggregations"
})
public class JobTrend {

    @JsonProperty("took")
    private Double took;
    @JsonProperty("timed_out")
    private String timedOut;
    @JsonProperty("_shards")
    private Shards_ shards;
    @JsonProperty("hits")
    private Hits_ hits;
    @JsonProperty("aggregations")
    private Aggregations aggregations;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("took")
    public Double getTook() {
        return took;
    }

    @JsonProperty("took")
    public void setTook(Double took) {
        this.took = took;
    }

    @JsonProperty("timed_out")
    public String getTimedOut() {
        return timedOut;
    }

    @JsonProperty("timed_out")
    public void setTimedOut(String timedOut) {
        this.timedOut = timedOut;
    }

    @JsonProperty("_shards")
    public Shards_ getShards() {
        return shards;
    }

    @JsonProperty("_shards")
    public void setShards(Shards_ shards) {
        this.shards = shards;
    }

    @JsonProperty("hits")
    public Hits_ getHits() {
        return hits;
    }

    @JsonProperty("hits")
    public void setHits(Hits_ hits) {
        this.hits = hits;
    }

    @JsonProperty("aggregations")
    public Aggregations getAggregations() {
        return aggregations;
    }

    @JsonProperty("aggregations")
    public void setAggregations(Aggregations aggregations) {
        this.aggregations = aggregations;
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
        return new ToStringBuilder(this).append("took", took).append("timedOut", timedOut).append("shards", shards).append("hits", hits).append("aggregations", aggregations).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(hits).append(took).append(shards).append(timedOut).append(additionalProperties).append(aggregations).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof JobTrend) == false) {
            return false;
        }
        JobTrend rhs = ((JobTrend) other);
        return new EqualsBuilder().append(hits, rhs.hits).append(took, rhs.took).append(shards, rhs.shards).append(timedOut, rhs.timedOut).append(additionalProperties, rhs.additionalProperties).append(aggregations, rhs.aggregations).isEquals();
    }

}
