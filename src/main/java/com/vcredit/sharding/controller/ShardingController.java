package com.vcredit.sharding.controller;

import com.vcredit.sharding.model.Order;
import com.vcredit.sharding.model.OrderItem;
import com.vcredit.sharding.dao.OrderItemRepository;
import com.vcredit.sharding.dao.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author zhouliliang
 * @Description:
 * @Date: Created in 2018/8/13 17:49
 */
@RestController
public class ShardingController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @GetMapping(path = "queryOrderById")
    public Order queryOrder(@RequestParam("id") Long id){
        return orderRepository.findById(id);
    }

    @GetMapping(path = "queryOrderByUserId")
    public List<Order> queryOrder(@RequestParam("userId") Integer userId){
        return orderRepository.findByUserId(userId);
    }

    @GetMapping(path = "queryOrderByOrderIdAndUserId")
    public Order queryOrder(@RequestParam("orderId") Long orderId, @RequestParam("userId") Integer userId){
        return orderRepository.findByIdAndUserId(orderId, userId);
    }

    @GetMapping(path = "queryOrderIdBetween")
    public List<Order> queryOrderByIdBetween(@RequestParam("startOrderId") Long startOrderId, @RequestParam("endOrderId") Long endOrderId){
        return orderRepository.findByIdBetween(startOrderId, endOrderId);
    }

    @GetMapping(path = "queryOrderByUserIdAndIdBetween")
    public List<Order> queryOrderByUserIdIdBetween(@RequestParam("userId") Integer userId, @RequestParam("startOrderId") Long startOrderId, @RequestParam("endOrderId") Long endOrderId){
        return orderRepository.findByUserIdAndIdBetween(userId, startOrderId, endOrderId);
    }

    @PostMapping(path = "insertOrder")
    public Long insertOrder(@RequestBody Order order){
        orderRepository.insert(order);
        return order.getOrderId();
    }

    @PostMapping(path = "insertOrderItem")
    public Long insertOrder(@RequestBody OrderItem orderItem){
        return orderItemRepository.insert(orderItem);
    }
}
