package com.jacada.interview.server.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.jacada.interview.server.model.Location;

@Service
@CacheConfig(cacheNames = "locations")
public class LocationService {

	private static Logger log = LoggerFactory.getLogger(LocationService.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${metaweather-url}")
	String url;
	public LocationService() {
		super();
	}


	public LocationService(RestTemplate restTemplate2, String url2) {
		super();
		this.restTemplate = restTemplate2;
		this.url = url2;
	}


	@Cacheable
	public List<Location> search(String query) throws Exception {
		log.info("searching the weather of location {}", query);
		log.info("searching the weather of location in public url {}", url);
		if(StringUtils.isEmpty(query)) {
			throw new Exception("Please provide query");
		}
		
		String finalUrl = url + query;
		ResponseEntity<Location[]> response = restTemplate.getForEntity(finalUrl, Location[].class);
		List<Location> locationsArray = Arrays.asList(response.getBody());
		log.info("location details {}", locationsArray);
		return locationsArray;
	}

}
