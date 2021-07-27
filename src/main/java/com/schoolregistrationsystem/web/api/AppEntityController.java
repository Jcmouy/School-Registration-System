package com.schoolregistrationsystem.web.api;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.schoolregistrationsystem.common.dto.EntityDto;
import com.schoolregistrationsystem.dto.ResponseDto;
import com.schoolregistrationsystem.service.AppEntityService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public abstract class AppEntityController<D extends EntityDto> {

	protected abstract AppEntityService<? extends Serializable, D> getService();

	@ApiOperation(value = "Allows to obtain an entity by ID", response = Long.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Reply OK"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/{entityId}")
	public ResponseEntity<ResponseDto<D>> findEntidadById(@PathVariable("entityId") Long entityId) {
		return new ResponseEntity<>(getService().findOneById(entityId), HttpStatus.OK);
	}

	@ApiOperation(value = "Creates a record of the entity", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Reply OK") })
	@PostMapping("")
	public ResponseEntity<ResponseDto<D>> createEntity(@RequestBody D entity) {
		return new ResponseEntity<>(getService().createEntity(entity), HttpStatus.OK);
	}

	@ApiOperation(value = "Modification of an entity record", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Reply OK") })
	@PutMapping("")
	public ResponseEntity<ResponseDto<D>> updateEntity(@RequestBody D entity) {
		return new ResponseEntity<>(getService().update(entity), HttpStatus.OK);
	}

	@ApiOperation(value = "Deleting an entity record", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Reply OK") })
	@DeleteMapping("/{entityId}")
	public ResponseEntity<ResponseDto<Long>> deleteEntity(@PathVariable("entityId") Long entityId) {
		return new ResponseEntity<>(getService().deleteById(entityId), HttpStatus.OK);
	}
}
