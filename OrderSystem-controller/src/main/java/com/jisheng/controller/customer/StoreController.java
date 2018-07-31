package com.jisheng.controller.customer;

import com.jisheng.bo.LookCusOrder1;
import com.jisheng.po.Customer;
import com.jisheng.po.Food;
import com.jisheng.po.Order;
import com.jisheng.po.Storer;
import com.jisheng.service.FoodService;
import com.jisheng.service.OrderService;
import com.jisheng.service.StorerService;
import com.jisheng.service.impl.ServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes(names = {"store", "foods", "orders"})
public class StoreController {
    @Autowired
    StorerService storerService;
    @Autowired
    FoodService foodService;
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "StoreServlet", method = RequestMethod.POST)
    public String getStoreController(Map<String, Object> map, @SessionAttribute(name = "customer",required = false) Customer customer,
                                     @RequestParam(name = "storeName",required = false) String storeName,
                                     @RequestParam(value = "orders",required = false) String foodOrd,
                                     @RequestParam(value = "search",required = false) String search) {
        if (customer == null) {
            map.put("msg6", "请先完善个人信息");
            return "customerPage";
        }
        // 获得商铺名
        Storer storer = new Storer();
        storer.setStore_name(storeName);
        // 获得商铺信息
        List<Storer> stores = storerService.lookSomeOne(storer);
        // 防止在输入网址时查找不存在的店铺信息
        if (stores == null) {
            stores = new ArrayList<>();
        }
        if (stores.size() == 0) {
            map.put("msg6", "请在此页面选择正确店家");
            return "customerPage";
        }
        Storer store = stores.get(0);
        Food food = new Food();
        food.setStore_id(store.getStore_id());
        map.put("store", store);
        // 根据排序选择获得对应信息
        // 获得店铺中食物信息
        List<Food> foods = null;
        if (foodOrd != null) {

            if (search != null) {
                food.setName(search);
            }

            if (foodOrd.equals("asc")) {
                foods = foodService.lookPriceInOrder(food, true);
            } else {
                foods = foodService.lookPriceInOrder(food, false);
            }
        } else {
            foods = foodService.lookSomeOne(food);
        }
        map.put("foods", foods);
        // 查看该顾客的购物车订单信息
        Order order = new Order();
        order.setCustomer_id(customer.getId());
        order.setStore_id(store.getStore_id());
        List<LookCusOrder1> orders = orderService.lookCusOrder1(order);
        map.put("orders", orders);
        return "redirect:/StorePageServlet";
    }
}
