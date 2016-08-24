package com.hpe.devops.api.organization;

import org.springframework.data.annotation.Id;

public class Organization {

    @Id
    private String id;

    private String name;
    
    private String description;
    
    public Organization(){
    	
    }
    
	public Organization(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

    
    
}
