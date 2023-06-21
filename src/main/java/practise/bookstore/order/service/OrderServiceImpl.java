package practise.bookstore.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practise.bookstore.order.dao.OrderRepository;
import practise.models.order.Order;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List <Order> findOrdersByBooksAuthorName(String keyword) {
        return orderRepository.findOrdersByBookAuthorsName(keyword);
    }

    @Override
    public Iterable <Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Integer id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public Order save(Order order) {
        order.setUpdatedBy("Kirill");
        order.setUpdatedDate(LocalDateTime.now());
        order.setCreatedBy("Kirill");
        order.setCreatedDate(LocalDateTime.now());
        return orderRepository.save(order);
    }

    @Override
    public Order update(Integer id, Order order) {
        Order order_from_db = orderRepository.findById(id).get();
        order.setId(id);
        order.setUpdatedBy("Kirill");
        order.setUpdatedDate(LocalDateTime.now());
        order.setCreatedBy(order_from_db.getCreatedBy());
        order.setCreatedDate(order_from_db.getCreatedDate());
        return orderRepository.save(order);
    }

    @Override
    public void deleteById(Integer id) {
        orderRepository.deleteById(id);
    }
}
