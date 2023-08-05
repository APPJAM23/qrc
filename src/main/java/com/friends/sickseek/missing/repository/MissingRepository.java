package com.friends.sickseek.missing.repository;

import com.friends.sickseek.missing.domain.Missing;
import org.springframework.data.repository.CrudRepository;

public interface MissingRepository extends CrudRepository<Missing, Long> {
}
