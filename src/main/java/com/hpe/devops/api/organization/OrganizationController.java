package com.hpe.devops.api.organization;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/organizations", produces = { "application/json" })
public class OrganizationController {

	
	@Autowired
	private OrganizationRepository organizationRepo;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Organization> getAllOrganizations() throws Exception {
		
		return organizationRepo.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Organization getOrganizationById(@PathVariable String id) throws Exception {
		
		return organizationRepo.findOne(id);
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Organization> addOrganization(@RequestBody Organization organization) throws Exception {
		
		organization.setId(UUID.randomUUID().toString());
		
		Organization org = organizationRepo.save(organization);
		
		return new ResponseEntity<Organization>(org, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Organization> updateOrganization(@RequestBody Organization organization) throws Exception {
		
		Organization org = organizationRepo.save(organization);
		
		return new ResponseEntity<Organization>(org, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Organization> deleteOrganization(@PathVariable String id) throws Exception {
		
		Organization org = organizationRepo.findOne(id);
		
		organizationRepo.delete(id);
		
		return new ResponseEntity<Organization>(org, HttpStatus.OK);
	}
}
