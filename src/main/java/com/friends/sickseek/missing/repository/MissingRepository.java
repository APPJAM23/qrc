package com.friends.sickseek.missing.repository;

import com.friends.sickseek.missing.domain.Missing;
import com.friends.sickseek.missing.domain.type.MissingType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MissingRepository extends CrudRepository<Missing, Long> {

    @Query("select m from Missing m where " +
            "(:type is null or m.type = :type)")
    List<Missing> findByType(@Param("type") MissingType type);
}
