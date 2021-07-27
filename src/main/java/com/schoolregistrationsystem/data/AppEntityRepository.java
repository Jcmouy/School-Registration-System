package com.schoolregistrationsystem.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AppEntityRepository<T> extends JpaRepository<T, Long> {

}
