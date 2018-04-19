
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
    "key",
    "from",
    "from_as_string",
    "to",
    "to_as_string",
    "doc_count",
    "histogram_logdate"
})
public class Bucket__ {

    @JsonProperty("key")
    private String key;
    @JsonProperty("from")
    private Double from;
    @JsonProperty("from_as_string")
    private String fromAsString;
    @JsonProperty("to")
    private Double to;
    @JsonProperty("to_as_string")
    private String toAsString;
    @JsonProperty("doc_count")
    private Double docCount;
    @JsonProperty("histogram_logdate")
    private HistogramLogdate histogramLogdate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("from")
    public Double getFrom() {
        return from;
    }

    @JsonProperty("from")
    public void setFrom(Double from) {
        this.from = from;
    }

    @JsonProperty("from_as_string")
    public String getFromAsString() {
        return fromAsString;
    }

    @JsonProperty("from_as_string")
    public void setFromAsString(String fromAsString) {
        this.fromAsString = fromAsString;
    }

    @JsonProperty("to")
    public Double getTo() {
        return to;
    }

    @JsonProperty("to")
    public void setTo(Double to) {
        this.to = to;
    }

    @JsonProperty("to_as_string")
    public String getToAsString() {
        return toAsString;
    }

    @JsonProperty("to_as_string")
    public void setToAsString(String toAsString) {
        this.toAsString = toAsString;
    }

    @JsonProperty("doc_count")
    public Double getDocCount() {
        return docCount;
    }

    @JsonProperty("doc_count")
    public void setDocCount(Double docCount) {
        this.docCount = docCount;
    }

    @JsonProperty("histogram_logdate")
    public HistogramLogdate getHistogramLogdate() {
        return histogramLogdate;
    }

    @JsonProperty("histogram_logdate")
    public void setHistogramLogdate(HistogramLogdate histogramLogdate) {
        this.histogramLogdate = histogramLogdate;
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
        return new ToStringBuilder(this).append("key", key).append("from", from).append("fromAsString", fromAsString).append("to", to).append("toAsString", toAsString).append("docCount", docCount).append("histogramLogdate", histogramLogdate).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(histogramLogdate).append(fromAsString).append(toAsString).append(from).append(docCount).append(to).append(additionalProperties).append(key).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Bucket__) == false) {
            return false;
        }
        Bucket__ rhs = ((Bucket__) other);
        return new EqualsBuilder().append(histogramLogdate, rhs.histogramLogdate).append(fromAsString, rhs.fromAsString).append(toAsString, rhs.toAsString).append(from, rhs.from).append(docCount, rhs.docCount).append(to, rhs.to).append(additionalProperties, rhs.additionalProperties).append(key, rhs.key).isEquals();
    }

}
