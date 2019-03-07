package com.jacada.interview.server.model;

import java.io.Serializable;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	@JsonProperty("location_type")
	private String locationType;
	private BigInteger woeid;
	@JsonProperty("latt_long")
	private String lattLong;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocationType() {
		return locationType;
	}
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	public BigInteger getWoeid() {
		return woeid;
	}
	public void setWoeid(BigInteger woeid) {
		this.woeid = woeid;
	}
	public String getLattLong() {
		return lattLong;
	}
	public void setLattLong(String lattLong) {
		this.lattLong = lattLong;
	}
	
}
