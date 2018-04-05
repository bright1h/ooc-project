package com.mapringg.bab.repositories;

import com.mapringg.bab.models.CustomerOrder;
import com.mapringg.bab.models.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderListRepository extends JpaRepository<OrderList,Long> {
}
