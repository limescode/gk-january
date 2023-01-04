package pl.limescode.gkjanuary.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.limescode.gkjanuary.model.Cart;
import pl.limescode.gkjanuary.dto.OrderDto;
import pl.limescode.gkjanuary.entity.Order;
import pl.limescode.gkjanuary.validator.OrderValidator;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final Cart cart;
    private final OrderValidator orderValidator;

    public Order findOrderByProductId(Long productId) {
        return cart.findOrderByProductId(productId);
    }

    public List<Order> findAll() {
        return cart.findAll();
    }

    public Order addOrder(OrderDto dto) {
        orderValidator.validate(dto);
        Order order = Order.builder()
                .productId(dto.getProductId())
                .name(dto.getName())
                .price(dto.getPrice())
                .total(dto.getPrice())
                .amount(1)
                .added(Instant.now())
                .build();
        return cart.save(order);
    }

    public void addItem(Long productId) {
        cart.addItem(productId);
    }

    public void removeItem(Long productId) {
        cart.removeItem(productId);
    }

    public void emptyCart(){
        cart.empty();
    }

    public void deleteOrderByProductId(Long productId) {
        cart.deleteByProductId(productId);
    }
}
