package com.jamesdv.springbootrestfulpractice.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    //field1, filed2
    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean(){
        SomeBean someBean = new SomeBean("value1", "value2", "value3");

        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");

        FilterProvider filterProvider= new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);

        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(someBean);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }

    //field, field3
    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveSomeBeans(){
        List<SomeBean> someBeans = Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value11", "value22", "value33"));

        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");

        FilterProvider filterProvider= new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);

        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(someBeans);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }

}
