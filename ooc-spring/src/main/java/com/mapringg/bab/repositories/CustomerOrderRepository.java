package com.mapringg.bab.repositories;

import com.mapringg.bab.models.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
    List<CustomerOrder> findAllByStatus(String status);

    List<CustomerOrder> findAllByDate(Date date);
}
