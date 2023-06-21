package practise.bookstore.order.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practise.bookstore.order.service.OrderService;
import practise.models.order.Order;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderRestController {

    private final OrderService orderService;

    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity <Iterable <Order>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{id}")
    public Order find(@PathVariable Integer id) {
        return orderService.findById(id);
    }

    @PostMapping
    public ResponseEntity <Order> save(@RequestBody Order author) {
        return ResponseEntity.ok(orderService.save(author));
    }

    @PutMapping("/{id}")
    public ResponseEntity <Order> update(@PathVariable Integer id, @RequestBody Order author) {
        return ResponseEntity.ok(orderService.update(id, author));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        orderService.deleteById(id);
    }

    @GetMapping(value = "/keyword/{keyword}")
    public ResponseEntity <List <Order>> findOrdersByAuthorsName(@PathVariable String keyword) {
        return ResponseEntity.ok(orderService.findOrdersByBooksAuthorName(keyword));
    }

}
