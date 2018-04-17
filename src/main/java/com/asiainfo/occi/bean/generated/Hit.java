
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
    "_index",
    "_type",
    "_id",
    "_score",
    "_ttl",
    "_source",
    "sort"
})
public class Hit {

    @JsonProperty("_index")
    private String index;
    @JsonProperty("_type")
    private String type;
    @JsonProperty("_id")
    private String id;
    @JsonProperty("_score")
    private String score;
    @JsonProperty("_ttl")
    private Double ttl;
    @JsonProperty("_source")
    private Source source;
    @JsonProperty("sort")
    private List<Double> sort = new ArrayList<Double>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("_index")
    public String getIndex() {
        return index;
    }

    @JsonProperty("_index")
    public void setIndex(String index) {
        this.index = index;
    }

    @JsonProperty("_type")
    public String getType() {
        return type;
    }

    @JsonProperty("_type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("_id")
    public String getId() {
        return id;
    }

    @JsonProperty("_id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("_score")
    public String getScore() {
        return score;
    }

    @JsonProperty("_score")
    public void setScore(String score) {
        this.score = score;
    }

    @JsonProperty("_ttl")
    public Double getTtl() {
        return ttl;
    }

    @JsonProperty("_ttl")
    public void setTtl(Double ttl) {
        this.ttl = ttl;
    }

    @JsonProperty("_source")
    public Source getSource() {
        return source;
    }

    @JsonProperty("_source")
    public void setSource(Source source) {
        this.source = source;
    }

    @JsonProperty("sort")
    public List<Double> getSort() {
        return sort;
    }

    @JsonProperty("sort")
    public void setSort(List<Double> sort) {
        this.sort = sort;
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
        return new ToStringBuilder(this).append("index", index).append("type", type).append("id", id).append("score", score).append("ttl", ttl).append("source", source).append("sort", sort).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(score).append(index).append(id).append(source).append(sort).append(additionalProperties).append(type).append(ttl).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Hit) == false) {
            return false;
        }
        Hit rhs = ((Hit) other);
        return new EqualsBuilder().append(score, rhs.score).append(index, rhs.index).append(id, rhs.id).append(source, rhs.source).append(sort, rhs.sort).append(additionalProperties, rhs.additionalProperties).append(type, rhs.type).append(ttl, rhs.ttl).isEquals();
    }

}
