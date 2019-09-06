package edu.cn.neusoft.project.model.dao;

import edu.cn.neusoft.project.model.vo.Order;
import edu.cn.neusoft.project.model.vo.OrderDetail;

import java.util.List;

public interface OrderMapper {
    void saveOrder(Order order);
    void saveOrderDetail(OrderDetail od);
    List<Order> findMyOrders(int loginUserId);
}
