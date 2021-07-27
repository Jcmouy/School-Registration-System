package com.schoolregistrationsystem.service;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.schoolregistrationsystem.common.dto.EntityDto;
import com.schoolregistrationsystem.common.enums.CommonMessagesImpl;
import com.schoolregistrationsystem.common.enums.ResultResponse;
import com.schoolregistrationsystem.common.exceptions.CustomException;
import com.schoolregistrationsystem.common.exceptions.MessageDetail;
import com.schoolregistrationsystem.converter.AppEntityConverter;
import com.schoolregistrationsystem.data.AppEntityRepository;
import com.schoolregistrationsystem.dto.ResponseDto;

@Transactional
public abstract class AppEntityService<T extends Serializable, D extends EntityDto> {
	private static final Logger LOG = LoggerFactory.getLogger(AppEntityService.class);

	public abstract AppEntityRepository<T> getEntityRepository();

	public abstract AppEntityConverter<T, D> getEntityConverter();

	public ResponseDto<D> createEntity(D entidadDto) {
		List<MessageDetail> errors;
		try {
			ResponseDto<Boolean> responseValidateEntity = validateEntityOnCreate(entidadDto);
			if (Boolean.FALSE.equals(responseValidateEntity.getResponse())) {
				return new ResponseDto<>(ResultResponse.ERROR, responseValidateEntity.getMessages());
			}
			return new ResponseDto<>(getEntityConverter().mapEntityToDto(createEntityAfterValidation(entidadDto)),
					Arrays.asList(new MessageDetail(CommonMessagesImpl.SUCCESS_ENTITY_OPERATION)));
		} catch (CustomException e) {
			LOG.error("Exception: {}", ExceptionUtils.getStackTrace(e));
			errors = e.getErrorsDetail();
		} catch (Exception e) {
			LOG.error("Exception: {}", ExceptionUtils.getStackTrace(e));
			errors = Arrays.asList(new MessageDetail(CommonMessagesImpl.ERROR_ENTITY_SAVE));
		}
		return new ResponseDto<>(ResultResponse.ERROR, errors);
	}

	protected T createEntityAfterValidation(D entidadDto) {
		return getEntityRepository().save(getEntityConverter().mapDtoToEntity(entidadDto));
	}

	protected ResponseDto<Boolean> validateEntityOnCreate(D entidadDto) {
		ResponseDto<Boolean> responseDto = new ResponseDto<>(true);
		if (Boolean.TRUE.equals(checkIfEntityExistsByLogicKey(entidadDto))) {
			throw new CustomException(CommonMessagesImpl.ERROR_ENTITY_EXISTS);
		}
		return responseDto;
	}

	protected abstract Boolean checkIfEntityExistsByLogicKey(D entidadDto);

	public ResponseDto<D> update(D entidadDto) {
		List<MessageDetail> errors;
		try {
			ResponseDto<Boolean> responseValidateEntity = validateEntityOnUpdate(entidadDto);
			if (Boolean.FALSE.equals(responseValidateEntity.getResponse())) {
				return new ResponseDto<>(ResultResponse.ERROR, responseValidateEntity.getMessages());
			}
			return new ResponseDto<>(getEntityConverter().mapEntityToDto(createEntityAfterValidation(entidadDto)),
					Arrays.asList(new MessageDetail(CommonMessagesImpl.SUCCESS_ENTITY_OPERATION)));

		} catch (CustomException e) {
			LOG.error(ExceptionUtils.getStackTrace(e));
			errors = e.getErrorsDetail();
		} catch (Exception e) {
			LOG.error(ExceptionUtils.getStackTrace(e));
			errors = Arrays.asList(new MessageDetail(CommonMessagesImpl.ERROR_ENTITY_SAVE));
		}
		return new ResponseDto<>(ResultResponse.ERROR, errors);
	}

	protected ResponseDto<Boolean> validateEntityOnUpdate(D entidadDto) {
		Optional<T> previousEntity = getEntityRepository().findById(entidadDto.getId());
		if (!previousEntity.isPresent()) {
			throw new CustomException(CommonMessagesImpl.ENTITY_NOT_FOUND);
		}
		return new ResponseDto<>(true);
	}

	protected T updateEntityAfterValidation(D entidadDto) {
		if (!getEntityRepository().existsById(entidadDto.getId()))
			throw new CustomException(CommonMessagesImpl.ENTITY_NOT_FOUND);

		return getEntityRepository().save(getEntityConverter().mapDtoToEntity(entidadDto));
	}

	public ResponseDto<Long> deleteById(Long id) {
		try {
			getEntityRepository().deleteById(id);
			return new ResponseDto<>(id, Arrays.asList(new MessageDetail(CommonMessagesImpl.SUCCESS_ENTITY_OPERATION)));
		} catch (Exception e) {
			LOG.error(ExceptionUtils.getStackTrace(e));
			return new ResponseDto<>(id, ResultResponse.ERROR,
					Arrays.asList(new MessageDetail(CommonMessagesImpl.ENTITY_NOT_FOUND)));
		}
	}

	public ResponseDto<D> findOneById(Long id) {
		Optional<T> entidad = getEntityRepository().findById(id);
		if (entidad.isPresent())
			return new ResponseDto<>(getEntityConverter().mapEntityToDto(entidad.get()));
		else
			return new ResponseDto<>();
	}

	public ResponseDto<Boolean> existsById(Long id) {
		return new ResponseDto<>(getEntityRepository().existsById(id));
	}

	public ResponseDto<Long> count() {
		return new ResponseDto<>(getEntityRepository().count());
	}
}