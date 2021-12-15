package com.tcs.ins.resource.api;

import static com.tcs.ins.support.Constant.REQUEST_PARAM_MAPPING_RESOURCE;
import static com.tcs.ins.support.Constant.REQUEST_PARAM_PAGE_NUMBER;
import static com.tcs.ins.support.Constant.REQUEST_PARAM_PAGE_SIZE;
import static com.tcs.ins.support.Constant.REQUEST_PARAM_SORT_BY;
import static com.tcs.ins.support.Constant.REQUEST_PARAM_SORT_DIRECTION;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.tcs.ins.resource.service.PMSService;
import com.tcs.ins.resource.service.model.ResourceDetailModel;
import com.tcs.ins.resource.service.model.ResourceSearchRequest;

@RestController
@RequestMapping(REQUEST_PARAM_MAPPING_RESOURCE)
class PMSResourceDetailsApi {

	private static final String SORT_DIRECTION_ASC = "asc";
	private final PMSService pMSService;

	public PMSResourceDetailsApi(PMSService pMSService) {
		this.pMSService = pMSService;
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<ResourceDetailModel> getResourceDetail(@PathVariable Long id) {
		return ResponseEntity.ok(pMSService.getResourceDetail(id));
	}
 
	@GetMapping(path = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Page<ResourceDetailModel>> searchResource(
			@RequestParam(name = REQUEST_PARAM_PAGE_NUMBER, required = true) Integer pageNumber,
			@RequestParam(name = REQUEST_PARAM_PAGE_SIZE, required = true) Integer pageSeize,
			@RequestParam(name = REQUEST_PARAM_SORT_BY, required = false) String sortBy,
			@RequestParam(name = REQUEST_PARAM_SORT_DIRECTION, required = false) String sortDirection,
			@RequestParam Map<String, String> requestParam) {
		ResourceSearchRequest searchRequest = new ResourceSearchRequest(requestParam);
		PageRequest pageRequest = pageRequest(pageNumber, pageSeize, sortBy, sortDirection);
		Page<ResourceDetailModel> page = pMSService.searchResource(pageRequest, searchRequest);
		return ResponseEntity.ok(page);
	}

	private PageRequest pageRequest(Integer pageNumber, Integer pageSize, String sortBy, String sortDirection) {
		if (StringUtils.hasText(sortBy)) {
			Direction direction = StringUtils.hasText(sortDirection)
					&& SORT_DIRECTION_ASC.equalsIgnoreCase(sortDirection) ? Direction.ASC : Direction.DESC;
			return PageRequest.of(pageNumber, pageSize, Sort.by(new Order(direction, sortBy)));
		}
		return PageRequest.of(pageNumber, pageSize);
	}

	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<ResourceDetailModel> createResource(@RequestBody ResourceDetailModel resourceDetailModel,
			UriComponentsBuilder ucb) {
		ResourceDetailModel create = pMSService.createResource(resourceDetailModel);
		return ResponseEntity
				.created(ucb.path(REQUEST_PARAM_MAPPING_RESOURCE + "/{id}").buildAndExpand(create.getId()).toUri())
				.body(create);
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<ResourceDetailModel> updateResource(@PathVariable Long id,
			@RequestBody ResourceDetailModel resourceDetailModel) {
		resourceDetailModel.setId(id);
		ResourceDetailModel update = pMSService.updateResource(resourceDetailModel);
		return ResponseEntity.ok(update);
	}

	@DeleteMapping(path = "/{id}")
	ResponseEntity<Void> deleteResource(@PathVariable Long id) {
		pMSService.deleteResource(id);
		return ResponseEntity.ok(null);
	}
}
