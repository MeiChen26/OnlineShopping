package edu.cn.neusoft.project.controller;

import edu.cn.neusoft.project.model.service.AddressService;
import edu.cn.neusoft.project.model.vo.Address;
import edu.cn.neusoft.project.model.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderAction {

    @Autowired
    private AddressService addressService;

    @RequestMapping("/buyGoods.action")
   public String buyGoods(String goodsId, String goodsPrice, String goodsName,
                          String goodsDiscount, String goodsPostalfee, String num,
                          String[] pic, String []color, String[]size,
                          Map<String, Object>map){
        System.out.println("id"+goodsId);
        System.out.println("price"+goodsPrice);
        System.out.println("name"+goodsName);
        System.out.println("discount"+goodsDiscount);
        System.out.println("postalfee"+goodsPostalfee);
        System.out.println("num"+num);
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        User user = (User)attrs.getRequest().getSession().getAttribute("_LOGIN_USER_");
        List<Address> addrs=addressService.getAddressByUserId(user.getUser_id());

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

        System.out.println("size"+size);
        System.out.println("pic"+pic);
        System.out.println("color"+color);
       return "/order/buyGoods";
    }

    @RequestMapping("/addOrder")
    public String addOrder(@RequestParam String address, @RequestParam String orderPostalfee, HttpSession session,
                           Map<String,String> m){
		/*System.out.println(address);
		for(int i=0;i<((String[])session.getAttribute("goodsId")).length;i++){
			System.out.print(((String[])session.getAttribute("goodsId"))[i]+"  ");
			System.out.print(((String[])session.getAttribute("goodsName"))[i]+"  ");
			System.out.print(((String[])session.getAttribute("goodsDiscount"))[i]+"  ");
			System.out.print(((String[])session.getAttribute("size"))[i]+"  ");
			System.out.print(((String[])session.getAttribute("color"))[i]+"  ");
			System.out.print(((String[])session.getAttribute("num"))[i]+"  ");
			System.out.println(orderPostalfee);

		}*/
		/*	Map<String,String[]> m=new HashMap<String,String[]>();
		m.put("goodsId", (String[])session.getAttribute("goodsId"));
		m.put("orderName", (String[])session.getAttribute("goodsName"));
		m.put("orderPrice", (String[])session.getAttribute("goodsDiscount"));
		m.put("orderSize", (String[])session.getAttribute("size"));
		m.put("orderColor", (String[])session.getAttribute("color"));
		m.put("orderNum", (String[])session.getAttribute("num"));
		m.put("orderPic", (String[])session.getAttribute("pic"));*/
        Order order=new Order();
        order.setUserId(this.getLoginUserId());
        order.setOrderAddress(address);
        order.setOrderPostalfee(Float.parseFloat(orderPostalfee));

        List<OrderDetail> orderDetails=new ArrayList<OrderDetail>();
        for(int j=0;j<((String[])session.getAttribute("goodsId")).length;j++){
            OrderDetail od=new OrderDetail();
            od.setGoodsId(Integer.parseInt(((String[])session.getAttribute("goodsId"))[j]));
            od.setOdetailName(((String[])session.getAttribute("goodsName"))[j]);
            od.setOdetailPrice(Float.parseFloat(((String[])session.getAttribute("goodsDiscount"))[j]));
            od.setOdetailSize(((String[])session.getAttribute("size"))[j]);
            od.setOdetailColor(((String[])session.getAttribute("color"))[j]);
            od.setOdetailNum(Integer.parseInt(((String[])session.getAttribute("num"))[j]));
            od.setOdetailPic(((String[])session.getAttribute("pic"))[j]);
            orderDetails.add(od);
        }
        //System.out.println(orderDetails);
        try{

            this.getServMgr().getOrderService().addOrder(order,orderDetails);
            m.put("orderId",order.getOrderId()+"");
            return "/order/addOrder";
        }
        catch(Exception e){
            e.printStackTrace();
            this.addMessage("提交订单失败");
            this.addRedirURL("返回", "@back");
            return EXECUTE_RESULT;
        }
    }
}
