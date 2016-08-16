package com.hpe.devops.api.organization;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrganizationRepository extends MongoRepository<Organization, Long> {

	Organization findById(Long id);
}
