package com.github.alexandrenavarro.javafxsample;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by anavarro on 06/02/17.
 */
@FeignClient(url = "https://restcountries.eu", name = "restcountries")
public interface CountryResource {


    @RequestMapping(method = RequestMethod.GET, value = "/rest/v1/all")
    List<Country> findCountries();

}
