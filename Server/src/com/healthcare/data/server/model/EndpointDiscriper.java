package com.healthcare.data.server.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="endpoint")
public class EndpointDiscriper {

	
	private String name;
	
	
	private String clssName;
	
	@XmlElement(name="location")
	public String getClssName() {
		return clssName;
	}
	
	public void setClssName(String clssName) {
		this.clssName = clssName;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlAttribute(name="name")
	public String getName() {
		return name;
	}
	
}
