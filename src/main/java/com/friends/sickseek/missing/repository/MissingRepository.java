package com.friends.sickseek.missing.repository;

import com.friends.sickseek.missing.domain.Missing;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MissingRepository extends CrudRepository<Missing, Long> {
}
