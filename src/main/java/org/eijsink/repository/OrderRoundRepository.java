package org.eijsink.repository;

import org.eijsink.model.OrderRound;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRoundRepository extends CrudRepository<OrderRound, Long> {

}

