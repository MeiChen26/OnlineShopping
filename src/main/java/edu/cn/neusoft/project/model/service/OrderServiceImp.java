package edu.cn.neusoft.project.model.service;

import edu.cn.neusoft.project.model.dao.OrderMapper;
import edu.cn.neusoft.project.model.vo.Order;
import edu.cn.neusoft.project.model.vo.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Override
    public int addOrder(Order order,List<OrderDetail> orderDetails) {
        // TODO Auto-generated method stub
        Date d=new Date();
        SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String str=sf.format(d);
        Random r=new Random();
        int i=r.nextInt(100);
        String s="";
        if(i<10)
            s="00"+i;
        else if(i>=10&&i<=99)
            s="0"+i;
        String orderCode=str+s;

        System.out.println("oderaddress"+order.getOrder_address());
        System.out.println("postfee"+order.getOrder_postalfee());
        order.setOrder_code(orderCode);
        System.out.println(order.getOrder_code());
        System.out.println(order.getUser_id());
        System.out.println(order.getOrder_address());
        System.out.println(order.getOrder_postalfee());
        orderMapper.saveOrder(order);

        int orderId=order.getOrder_id();
        System.out.println("---------"+orderId);

        for(int j=0;j<orderDetails.size();j++){
            OrderDetail od=orderDetails.get(j);
            od.setOrder_id(orderId);
            orderMapper.saveOrderDetail(od);
        }

        return orderId;
    }
}
