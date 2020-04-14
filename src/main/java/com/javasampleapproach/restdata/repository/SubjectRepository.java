package com.javasampleapproach.restdata.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.javasampleapproach.restdata.model.Subject;

@RepositoryRestResource(collectionResourceRel = "subject", path = "subject")
public interface SubjectRepository extends PagingAndSortingRepository<Subject, Integer> {
}
