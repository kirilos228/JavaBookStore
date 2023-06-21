package practise.bookstore.report.dao;

import org.springframework.data.repository.CrudRepository;
import practise.models.order.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface ReportRepository extends CrudRepository<Order, Integer> {
    List<Order> findByCreatedDateBetween(LocalDateTime createdDate, LocalDateTime createdDate2);

}
