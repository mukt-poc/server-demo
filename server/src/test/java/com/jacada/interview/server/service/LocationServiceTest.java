package com.jacada.interview.server.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

import com.jacada.interview.server.model.Location;
@TestPropertySource(locations="classpath:application-test.properties")
@ActiveProfiles("mock")
public class LocationServiceTest {

	LocationService locationService;
	@Autowired
	RestTemplate restTemplate;
	String url;
	@Before
	public void setup() {
		restTemplate = mock(RestTemplate.class);
		url = "http://localhost:8080/locations/search/";
		locationService = new LocationService(restTemplate, url);
	}

	@Test
	public void testSearchData() throws Exception {
		Location obj[] = new Location[1] ;
		ResponseEntity<Location[]> list = ResponseEntity.ok(obj);
		when(restTemplate.getForEntity(url+"pune", Location[].class)).thenReturn(list);
		assertNotNull(locationService.search("pune"));
	}
	
	@Test(expected=Exception.class)
	public void testSearchEmptyData() throws Exception {
		assertNotNull(locationService.search(""));
	}
}