package com.jacada.interview.server.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacada.interview.server.model.Location;
import com.jacada.interview.server.service.LocationService;

@RestController
@RequestMapping(value="locations")
public class LocationRS {

    private static Logger log = LoggerFactory.getLogger(LocationRS.class);

    @Autowired
    LocationService locationService;
    
    @GetMapping("/search/{search-query}")
    public List<Location> search(@PathVariable("search-query") String query) {
    	log.info("search query fired with query : {}", query);
    	List<Location> list = null;
    	try {
    		list = locationService.search(query);
		} catch (Exception e) {
			log.error("Failed to fetch location data. {}", e);
			list =  new ArrayList<Location>();
		}
    	return list;
    }

}
