package com.healthcare.data.server.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="service-endpoints")
public class ServiceEndpoint {
	
	
	private List<EndpointDiscriper> discriper;
	
	@XmlElement(name="endpoint")
	public List<EndpointDiscriper> getDiscriper() {
		return discriper;
	}
	
	public void setDiscriper(List<EndpointDiscriper> discriper) {
		this.discriper = discriper;
	}
	
}
