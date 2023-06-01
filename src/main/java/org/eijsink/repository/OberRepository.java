package org.eijsink.repository;

import org.eijsink.model.Ober;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OberRepository extends CrudRepository<Ober, Long> {

}

