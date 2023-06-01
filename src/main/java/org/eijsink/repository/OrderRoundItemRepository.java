package org.eijsink.repository;

import org.eijsink.model.OrderRoundItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRoundItemRepository extends CrudRepository<OrderRoundItem, Long> {

}

