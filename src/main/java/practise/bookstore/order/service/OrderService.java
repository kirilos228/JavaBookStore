package practise.bookstore.order.service;

import practise.models.order.Order;

import java.util.List;

public interface OrderService {

    Iterable <Order> findAll();

    Order findById(Integer id);

    Order save(Order author);

    Order update(Integer id, Order author);

    void deleteById(Integer id);

    List <Order> findOrdersByBooksAuthorName(String keyword);

}
