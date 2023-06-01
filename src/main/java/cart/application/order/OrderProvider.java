package cart.application.order;

import cart.domain.Member;
import cart.domain.Order;
import cart.dto.OrderItemResponse;
import cart.dto.OrderResponse;
import cart.dto.ProductResponse;
import cart.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional(readOnly = true)
public class OrderProvider {

    private final OrderRepository orderRepository;

    public OrderProvider(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = true)
    public List<OrderResponse> findOrderByMember(final Member member) {
        final List<Order> orders = orderRepository.findOrderByMemberId(member.getId());
        return orders.stream()
                .map(order -> new OrderResponse(
                        order.getId(),
                        order.getOrderItems().stream()
                                .map(orderItem -> new OrderItemResponse(
                                        orderItem.getId(),
                                        orderItem.getQuantity(),
                                        ProductResponse.from(orderItem)))
                                .collect(toList()),
                        Date.from(order.getDate().atZone(ZoneId.systemDefault()).toInstant()),
                        order.getPrice())
                ).collect(toList());
    }
}
