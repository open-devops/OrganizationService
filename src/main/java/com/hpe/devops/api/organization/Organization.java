package com.hpe.devops.api.organization;

import org.springframework.data.annotation.Id;

public class Organization {

    @Id
    private Long id = -1l;

    private String name;
    private String description;

    public Organization() {}

    public Organization(String name, String description) {
        this.name = name;
        this.description = description;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
