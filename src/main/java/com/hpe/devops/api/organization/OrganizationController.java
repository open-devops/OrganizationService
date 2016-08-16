package com.hpe.devops.api.organization;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/organizations", produces = { "application/json" })
public class OrganizationController {

	
	@Autowired
	private OrganizationRepository organizationRepo;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Organization> allOrganizations() throws Exception {
		
		return organizationRepo.findAll();
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Organization> addOrganization(@RequestBody Organization organization) throws Exception {
		if (organization.getId() == -1) {
			organization.setId(new Date().getTime());
		}
		Organization org = organizationRepo.save(organization);
		
		return new ResponseEntity<Organization>(org, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Organization> updateOrganization(@RequestBody Organization organization) throws Exception {
		Organization org = organizationRepo.save(organization);
		
		return new ResponseEntity<Organization>(org, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteOrganization(@PathVariable Long id) throws Exception {
//		Organization org = organizationRepo.findById(id);
		organizationRepo.delete(id);
		
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}
}
