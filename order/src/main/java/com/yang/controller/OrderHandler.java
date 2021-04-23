package com.yang.controller;

import com.yang.entity.Order;
import com.yang.entity.OrderVO;
import com.yang.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    private OrderRepository orderRepository;

    //添加订单
    @PostMapping("/save")
    public void save(@RequestBody Order order) {
        order.setDate(new Date());
        orderRepository.save(order);
    }

    //根据用户id找出订购的菜单
    @GetMapping("/findAllByUid/{index}/{limit}/{uid}")
    public OrderVO findAllByUid(@PathVariable("index") int index, @PathVariable("limit") int limit, @PathVariable("uid") long uid) {
        return new OrderVO(0, "", orderRepository.countByUid(uid), orderRepository.findAllByUid(index, limit, uid));
    }

    //计算用户订单数目
    @GetMapping("/countByUid/{uid}")
    public int countByUid(@PathVariable("uid") int uid){
        return orderRepository.countByUid(uid);
    }

    //找到所有未派送的订单
    @GetMapping("/findAll/{index}/{limit}")
    public OrderVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
        return new OrderVO(0, "", orderRepository.count(), orderRepository.findAll(index, limit));
    }

    //根据订单id修改菜单状态
    @GetMapping("/updateState/{id}")
    public void updateState(@PathVariable("id") long id){
        orderRepository.updateState(id);
    }

}
