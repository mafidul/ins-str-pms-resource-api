package com.tcs.ins.resource.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tcs.ins.resource.exception.ApplicationException;
import com.tcs.ins.resource.repository.PMSResourceRepository;
import com.tcs.ins.resource.repository.entity.ResourceDetail;
import com.tcs.ins.resource.service.mapper.PMSResourceMapper;
import com.tcs.ins.resource.service.model.ResourceDetailModel;
import com.tcs.ins.resource.service.model.ResourceSearchRequest;

@Service
public class DefaultPMSService implements PMSService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultPMSService.class);

	private final PMSResourceRepository pMSResourceRepository;
	private final PMSResourceMapper pMSMapper;

	public DefaultPMSService(PMSResourceRepository pMSResourceRepository, PMSResourceMapper pMSMapper) {
		this.pMSResourceRepository = pMSResourceRepository;
		this.pMSMapper = pMSMapper;
	}

	// Resource Details
	@Override
	public ResourceDetailModel getResourceDetail(Long id) {
		ResourceDetail resourceDetail = getOrThrowResourceDetail(id);
		return pMSMapper.toModel(resourceDetail);
	}

	private ResourceDetail getOrThrowResourceDetail(Long id) {
		Optional<ResourceDetail> OptionalResourceDetail = pMSResourceRepository.findById(id);
		if (!(OptionalResourceDetail.isPresent())) {
			throw ApplicationException.noRecordFound("Resource Details Not Found");
		}
		return OptionalResourceDetail.get();
	}

	@Override
	public ResourceDetailModel createResource(ResourceDetailModel resourceDetailModel) {
		ResourceDetail resourceDetail = pMSMapper.toEntity(resourceDetailModel);
		ResourceDetail saveResourceDetail = pMSResourceRepository.save(resourceDetail);
		return pMSMapper.toModel(saveResourceDetail);
	}

	@Override
	public ResourceDetailModel updateResource(ResourceDetailModel resourceDetailModel) {
		ResourceDetail resourceDetail = getOrThrowResourceDetail(resourceDetailModel.getId());

		if (StringUtils.hasText(resourceDetailModel.getFirstName())) {
			resourceDetail.setFirstName(resourceDetailModel.getFirstName());
		}
		if (StringUtils.hasText(resourceDetailModel.getLastName())) {
			resourceDetail.setLastName(resourceDetailModel.getLastName());
		}
		if (StringUtils.hasText(resourceDetailModel.getExperience())) {
			resourceDetail.setExperience(resourceDetailModel.getExperience());
		}
		if (StringUtils.hasText(resourceDetailModel.getDesignation())) {
			resourceDetail.setDesignation(resourceDetailModel.getDesignation());
		}
		if (StringUtils.hasText(resourceDetailModel.getSkills())) {
			resourceDetail.setSkills(resourceDetailModel.getSkills());
		}
		if (StringUtils.hasText(resourceDetailModel.getEmail())) {
			resourceDetail.setEmail(resourceDetailModel.getEmail());
		}
		if (StringUtils.hasText(resourceDetailModel.getPerformanceRate())) {
			resourceDetail.setPerformanceRate(resourceDetailModel.getPerformanceRate());
		}

		ResourceDetail saveResourceDetail = pMSResourceRepository.save(resourceDetail);
		return pMSMapper.toModel(saveResourceDetail);
	}

	@Override
	public void deleteResource(Long id) {
		pMSResourceRepository.deleteById(id);
	}

	// Resource details pagination
	@Override
	public Page<ResourceDetailModel> searchResource(PageRequest pageRequest, ResourceSearchRequest searchRequest) {
		Page<ResourceDetail> page = pMSResourceRepository.findAll(pageRequest);
		List<ResourceDetailModel> content = pMSMapper.toModelResource(page);
		return new PageImpl<>(content, pageRequest, page.getTotalElements());
	}
}
