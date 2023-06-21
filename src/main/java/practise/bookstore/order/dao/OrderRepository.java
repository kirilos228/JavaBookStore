package practise.bookstore.order.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import practise.models.order.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository <Order, Integer> {
    @Query("SELECT o FROM Order o JOIN o.orderItems i WHERE i.book.author.firstName LIKE %:keyword%")
    List <Order> findOrdersByBookAuthorsName(String keyword);
}
