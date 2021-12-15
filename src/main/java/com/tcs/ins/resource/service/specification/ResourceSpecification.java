package com.tcs.ins.resource.service.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.tcs.ins.resource.repository.entity.ResourceDetail;
import com.tcs.ins.resource.service.model.ResourceSearchRequest;

public class ResourceSpecification implements Specification<ResourceDetail> {

	private static final long serialVersionUID = 1L;
	private final ResourceSearchRequest resourceSearchRequest;

	public ResourceSpecification(ResourceSearchRequest resourceSearchRequest) {
		this.resourceSearchRequest = resourceSearchRequest;
	}

	@Override
	public Predicate toPredicate(Root<ResourceDetail> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		List<Predicate> predicates = new ArrayList<>();
		if (resourceSearchRequest.idFilteringRequired()) {
			predicates.add(criteriaBuilder.equal(root.get("id"), resourceSearchRequest.getId()));
		}
		if (resourceSearchRequest.firstNameFilteringRequired()) {
			predicates.add(criteriaBuilder.like(root.get("firstName"), resourceSearchRequest.getFirstName() + "%"));
		}
		if (resourceSearchRequest.lastNameFilteringRequired()) {
			predicates.add(criteriaBuilder.like(root.get("lastName"), resourceSearchRequest.getLastName() + "%"));
		}
		if (resourceSearchRequest.experienceFilteringRequired()) {
			predicates.add(criteriaBuilder.like(root.get("experience"), resourceSearchRequest.getExperience() + "%"));
		}
		return andTogether(predicates, criteriaBuilder);
	}

	private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
		return cb.and(predicates.toArray(new Predicate[0]));
	}
}