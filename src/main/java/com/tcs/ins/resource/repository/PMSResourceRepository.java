package com.tcs.ins.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.tcs.ins.resource.repository.entity.ResourceDetail;

@Repository
public interface PMSResourceRepository extends JpaRepository<ResourceDetail, Long>, JpaSpecificationExecutor<ResourceDetail> {

}
