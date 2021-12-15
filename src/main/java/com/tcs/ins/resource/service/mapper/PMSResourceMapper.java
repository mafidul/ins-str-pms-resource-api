package com.tcs.ins.resource.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import com.tcs.ins.resource.repository.entity.ResourceDetail;
import com.tcs.ins.resource.service.model.ResourceDetailModel;

@Mapper(componentModel = "spring")
public interface PMSResourceMapper {

	ResourceDetail toEntity(ResourceDetailModel source);
	ResourceDetailModel toModel(ResourceDetail source);
	List<ResourceDetailModel> toModelResource(Page<ResourceDetail> source);
}
