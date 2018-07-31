package com.jisheng.controller;

import com.jisheng.po.Customer;
import com.jisheng.po.Food;
import com.jisheng.po.Storer;
import com.jisheng.po.User;
import com.jisheng.service.*;
import com.jisheng.service.impl.ServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping("/aaa")
@SessionAttributes(names = {"role", "user", "username", "storers", "customer", "foods", "storer"})
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private StorerService stoService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private CustomerService cusService;

    public LoginController() {}

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, @RequestParam("roles") String role, Map<String, Object> map) {
        boolean isTrue = false;
        // 2 判断用户信息是否正确
        if (userService.usernameIsExist(user)) {
            // 如果用户名存在
            if (userService.checkLoginInfo(user)) {
                // 密码正确 --- 登陆成功
                // 获得user完整信息
                user = userService.getUserInfo(user);
                // 一个user可能有多个角色
                List<String> roles = adminService.lookRole(user);
                for (String rol : roles) {
                    if (rol.equals(role)) {
                        isTrue = true;
                    }
                }
                map.put("role", role);
                if (isTrue) {
                    // 将用户信息 保存session
                    map.put("user", user);
                    map.put("username", user.getUsername());
                    map.put("storers", stoService.lookAll());
                    switch (role) {
                        // 如果为顾客，则将顾客信息存入session
                        case "customer": {
                            Customer customer = new Customer();
                            customer.setUser_id(user.getUser_id());
                            List<Customer> cus = cusService.lookSomeOne(customer);
                            if (cus == null) {
                                // 防止cus为null
                                cus = new ArrayList<Customer>();
                            }
                            if (cus.size() != 0) {
                                map.put("customer", cus.get(0));
                            } else {
                                //需要完善顾客信息才能真正拥有顾客角色
                                map.put("customer", null);
                            }
                        }
                        return "redirect:/CustomerPageServlet";
                        // request.getRequestDispatcher("CustomerPageServlet").forward(request,
                        // response);
                        case "storer": {
                            Storer storer = new Storer();
                            Food food = new Food();
                            storer.setUser_id(user.getUser_id());
                            Storer sto = stoService.lookSomeOne1(storer);
                            FoodService foodServ = ServiceFactory.FoodServ.INSTANCE.getFoodService();
                            if (sto != null) {
                                food.setStore_id(sto.getStore_id());
                                // 获得店铺中食物信息
                                List<Food> foods = foodServ.lookSomeOne(food);
                                map.put("foods", foods);
                                map.put("storer", sto);
                            }
                        }
                        return "redirect:/StorerPageServlet";
                        case "admin": {
                            return "redirect:/GetApplyServlet";
                        }
                        default:
                    }
                    // 跳转登陆成功系统主页
                } else {
                    // 该用户无此角色
                    map.put("msg", "该用户无此角色");
                }
            } else {
                // 密码错误
                map.put("msg", "密码输入错误");
            }

        } else {
            // 用户名不存在
            map.put("msg", "用户名不存在");
        }
        return "login";
    }
}
