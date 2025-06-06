package com.in28minutes.rest.webservices.restful_web_services.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// @JsonIgnoreProperties(value = { "field1", "field2" }) // This annotation can be used to ignore specific fields globally

// Adding SomeBeanFilter annotation to the class
@JsonFilter("SomeBeanFilter")
public class SomeBean {
    private String field1;
    private String field2;
    // @JsonIgnore // This annotation can be used to ignore a specific field
    private String field3;

    public SomeBean(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }
}
