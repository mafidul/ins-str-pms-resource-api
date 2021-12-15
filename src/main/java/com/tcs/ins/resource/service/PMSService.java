package com.tcs.ins.resource.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.tcs.ins.resource.service.model.ResourceDetailModel;
import com.tcs.ins.resource.service.model.ResourceSearchRequest;

public interface PMSService {

	ResourceDetailModel createResource(ResourceDetailModel resourceDetailModel);

	ResourceDetailModel updateResource(ResourceDetailModel resourceDetailModel);

	void deleteResource(Long id);

	Page<ResourceDetailModel> searchResource(PageRequest pageRequest, ResourceSearchRequest searchRequest);

	ResourceDetailModel getResourceDetail(Long id);

}
