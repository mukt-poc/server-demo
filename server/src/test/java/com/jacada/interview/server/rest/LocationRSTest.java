package com.jacada.interview.server.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.jacada.interview.server.model.Location;
import com.jacada.interview.server.service.LocationService;

@RunWith(SpringRunner.class)
@WebMvcTest(LocationRS.class)
public class LocationRSTest {
 
    @Autowired
    private MockMvc mvc;
 
    @MockBean
    private LocationService locationService;
 
 
    @Before
    public void setup() {
        // Initializes the JacksonTester
    }
 
    @Test
    public void searchLocation() throws Exception {
    	List<Location> list = new ArrayList<>();
    	Mockito.when(locationService.search("pune")).thenReturn(list);
    	RequestBuilder requestBuilder = MockMvcRequestBuilders.
        get("/locations/search/pune")
                .accept(MediaType.APPLICATION_JSON);
    	
        MockHttpServletResponse response = mvc.perform(requestBuilder)
                .andReturn().getResponse();
        
        assertEquals(response.getStatus(), HttpStatus.OK.value());
    }
 
 
}
