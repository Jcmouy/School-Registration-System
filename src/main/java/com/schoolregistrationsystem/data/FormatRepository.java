package com.schoolregistrationsystem.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.schoolregistrationsystem.domain.Format;

@Repository
public interface FormatRepository extends CrudRepository<Format, String> {

}
