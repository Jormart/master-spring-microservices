package com.in28minutes.rest.webservices.restful_web_services.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.server.MimeMappings.Mapping;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
    @GetMapping(path = "/filtering")
    public MappingJacksonValue filtering() {
        // This method is a placeholder for the actual filtering logic
        // It should return an instance of SomeBean with specific fields filtered

        // MappingJacksonValue - Dynamically filter fields in the response
        // Example: return a SomeBean with only field1 and field2 visible
        SomeBean someBean = new SomeBean("value1", "value2", "value3");

        // Create a MappingJacksonValue object to hold the SomeBean instance
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);

        // Create a filter to specify which fields to include in the response
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");

        // Create a FilterProvider to apply the filter
        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("SomeBeanFilter", filter);

        // Set the filters on the MappingJacksonValue object
        mappingJacksonValue.setFilters(filters);

        // Return the MappingJacksonValue object, which will apply the filter when
        // serialized
        return mappingJacksonValue;
    }

    @GetMapping(path = "/filtering-list")
    public MappingJacksonValue filteringList() {
        // This method is a placeholder for the actual filtering logic
        // It should return a list of SomeBean instances with specific fields filtered
        List<SomeBean> someBeans = Arrays.asList(
                new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"));

        // Create a MappingJacksonValue object to hold the list of SomeBean instances
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBeans);

        // Create a filter to specify which fields to include in the response
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");

        // Create a FilterProvider to apply the filter
        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("SomeBeanFilter", filter);

        // Set the filters on the MappingJacksonValue object
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }
}
