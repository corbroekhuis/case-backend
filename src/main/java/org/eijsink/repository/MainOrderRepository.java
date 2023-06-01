package org.eijsink.repository;

import org.eijsink.model.MainOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainOrderRepository extends CrudRepository<MainOrder, Long> {

}

