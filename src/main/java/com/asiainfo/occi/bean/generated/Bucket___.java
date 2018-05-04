
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
    "key_as_string",
    "key",
    "doc_count",
    "avg_vCores",
    "avg_memory"
})
public class Bucket___ {

    @JsonProperty("key_as_string")
    private String keyAsString;
    @JsonProperty("key")
    private Double key;
    @JsonProperty("doc_count")
    private Double docCount;
    @JsonProperty("avg_vCores")
    private AvgVCores avgVCores;
    @JsonProperty("avg_memory")
    private AvgMemory avgMemory;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("key_as_string")
    public String getKeyAsString() {
        return keyAsString;
    }

    @JsonProperty("key_as_string")
    public void setKeyAsString(String keyAsString) {
        this.keyAsString = keyAsString;
    }

    @JsonProperty("key")
    public Double getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(Double key) {
        this.key = key;
    }

    @JsonProperty("doc_count")
    public Double getDocCount() {
        return docCount;
    }

    @JsonProperty("doc_count")
    public void setDocCount(Double docCount) {
        this.docCount = docCount;
    }

    @JsonProperty("avg_vCores")
    public AvgVCores getAvgVCores() {
        return avgVCores;
    }

    @JsonProperty("avg_vCores")
    public void setAvgVCores(AvgVCores avgVCores) {
        this.avgVCores = avgVCores;
    }
    
    @JsonProperty("avg_memory")
    public AvgMemory getAvgMemory() {
        return avgMemory;
    }

    @JsonProperty("avg_memory")
    public void setAvgMemory(AvgMemory avgMemory) {
        this.avgMemory = avgMemory;
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
        return new ToStringBuilder(this).append("keyAsString", keyAsString).append("key", key).append("docCount", docCount).append("avgMemory", avgMemory).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(docCount).append(additionalProperties).append(keyAsString).append(key).append(avgMemory).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Bucket___) == false) {
            return false;
        }
        Bucket___ rhs = ((Bucket___) other);
        return new EqualsBuilder().append(docCount, rhs.docCount).append(additionalProperties, rhs.additionalProperties).append(keyAsString, rhs.keyAsString).append(key, rhs.key).append(avgMemory, rhs.avgMemory).isEquals();
    }

}
