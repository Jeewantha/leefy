package com.jeesoft.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@XmlRootElement(name="product")
@JsonPropertyOrder({"id","name","type"})
public class Product {
	
	private String id;
	
	private String name;
	
	private String type;
	
	@JsonProperty("productId")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@JsonProperty("productName")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@JsonProperty("productType")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
