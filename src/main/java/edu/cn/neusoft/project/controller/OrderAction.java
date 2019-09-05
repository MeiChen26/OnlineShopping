package edu.cn.neusoft.project.controller;

import edu.cn.neusoft.project.model.service.AddressService;
import edu.cn.neusoft.project.model.service.OrderService;
import edu.cn.neusoft.project.model.vo.Address;
import edu.cn.neusoft.project.model.vo.Order;
import edu.cn.neusoft.project.model.vo.OrderDetail;
import edu.cn.neusoft.project.model.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderAction {

    @Resource
    private AddressService addressService;
    @Resource
    private OrderService orderService;

    public User getUser(){
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        User user = (User)attrs.getRequest().getSession().getAttribute("_LOGIN_USER_");
        return user;
    }

    @RequestMapping("/buyGoods.action")
   public String buyGoods(String[] goodsId, String[] goodsPrice, String[] goodsName,
                          String[] goodsDiscount, String[] goodsPostalfee, String[] num,
                          String[] pic, String []color, String[]size,
                          Map<String, Object>map, HttpSession httpSession){

        System.out.println("name:"+goodsName[0]);

        List<Address> addrs=addressService.getAddressByUserId(getUser().getUser_id());
        for(Address a: addrs){
            System.out.println(a.getAddr_area());
        }
        map.put("address",addrs);
        map.put("goodsId", goodsId);
        map.put("goodsPrice", goodsPrice);
        map.put("goodsName", goodsName);
        map.put("goodsDiscount", goodsDiscount);
        map.put("goodsPostalfee", goodsPostalfee);
        map.put("num", num);
        map.put("size", size);
        map.put("pic",pic);
        map.put("color", color);

        httpSession.setAttribute("goodsId",goodsId);
        httpSession.setAttribute("goodsName",goodsId);
        httpSession.setAttribute("goodsPrice", goodsPrice);
        httpSession.setAttribute("goodsDiscount", goodsDiscount);
        httpSession.setAttribute("goodsPostalfee", goodsPostalfee);
        httpSession.setAttribute("size", size);
        httpSession.setAttribute("num",num);
        httpSession.setAttribute("pic",pic);
        httpSession.setAttribute("color",color);

       return "/order/buyGoods";
    }

    @RequestMapping("/addOrder.action")
    public String addOrder(@RequestParam String address, @RequestParam String orderPostalfee, HttpSession session,
                           Map<String,String> m) throws UnsupportedEncodingException {
        address = new String(address.getBytes("iso-8859-1"), "utf-8");
		System.out.println("address"+address);
		for(int i=0;i<((String[])session.getAttribute("goodsId")).length;i++){
			System.out.println("session"+((String[])session.getAttribute("goodsId"))[i]);
			System.out.println("session"+((String[])session.getAttribute("goodsName"))[i]+"  ");
			System.out.println("session"+((String[])session.getAttribute("goodsDiscount"))[i]+"  ");
			System.out.println("session"+((String[])session.getAttribute("size"))[i]+"  ");
			System.out.println("session"+((String[])session.getAttribute("color"))[i]+"  ");
			System.out.println("session"+((String[])session.getAttribute("num"))[i]+"  ");
			System.out.println(orderPostalfee);

		}
		/*	Map<String,String[]> m=new HashMap<String,String[]>();
		m.put("goodsId", (String[])session.getAttribute("goodsId"));
		m.put("orderName", (String[])session.getAttribute("goodsName"));
		m.put("orderPrice", (String[])session.getAttribute("goodsDiscount"));
		m.put("orderSize", (String[])session.getAttribute("size"));
		m.put("orderColor", (String[])session.getAttribute("color"));
		m.put("orderNum", (String[])session.getAttribute("num"));
		m.put("orderPic", (String[])session.getAttribute("pic"));*/
        Order order=new Order();
        order.setUser_id(getUser().getUser_id());
        order.setOrder_address(address);
        order.setOrder_postalfee(Float.parseFloat(orderPostalfee));

        List<OrderDetail> orderDetails=new ArrayList<OrderDetail>();

        for(int j=0;j<((String[])session.getAttribute("goodsId")).length;j++){
            OrderDetail od=new OrderDetail();
            od.setGoods_id(Integer.parseInt(((String[])session.getAttribute("goodsId"))[j]));
            od.setDetail_name(((String[])session.getAttribute("goodsName"))[j]);
            od.setDetail_price(Float.parseFloat(((String[])session.getAttribute("goodsDiscount"))[j]));
            od.setDetail_size(((String[])session.getAttribute("size"))[j]);
            od.setDetail_color(((String[])session.getAttribute("color"))[j]);
            od.setDetail_num(Integer.parseInt(((String[])session.getAttribute("num"))[j]));
            od.setDetail_pic(((String[])session.getAttribute("pic"))[j]);
            orderDetails.add(od);
        }

        //System.out.println(orderDetails);
        try{

            orderService.addOrder(order,orderDetails);
            m.put("orderId",order.getOrder_id()+"");
            return "/order/addOrder";
        }
        catch(Exception e){
            e.printStackTrace();
            return "/execute_result";
        }
    }

    @RequestMapping("/pay")
    public String pay(@RequestParam String orderId,Map<String,String> m){
        try{

            return "/order/pay";
        }
        catch(Exception e){
            e.printStackTrace();
            return "/execute_result";
        }
    }
//    @RequestMapping("/payForOrder")
//    public String payForOrder(@RequestParam String orderId,Map<String,String> m){
//        try{
//            orderService.changeOrderStatus(orderId, ORDER_PAID);
//            m.put("orderId",orderId);
//            return "forward:/order/getMyOrders";
//        }
//        catch(Exception e){
//            e.printStackTrace();
//            return "/common/execute_result";
//        }
//    }
//
//    @RequestMapping("/getMyOrders")
//    public String getMyOrders(@RequestParam(required=false) String status,Map<String,Page<Order>> m){
//        System.out.println("-----------"+status);
//        Page<Order> orders=this.getServMgr().getOrderService().getMyOrders(this.getLoginUserId(),status);
//        m.put("orders", orders);
//        return "/order/orderList";
//    }
}
