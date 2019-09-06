package edu.cn.neusoft.project.model.service;

import edu.cn.neusoft.project.model.vo.Order;
import edu.cn.neusoft.project.model.vo.OrderDetail;

import java.util.List;

public interface OrderService {
    int addOrder(Order order, List<OrderDetail> orderDetails);
    List<Order> getMyOrders(int loginUserId);
}
