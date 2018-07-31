package com.jisheng.controller.customer;

import com.jisheng.po.Food;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes(names = {"pageSize","countPage","pageNos"})
public class StorePageController {
    @RequestMapping("StorePageServlet")
    public String getStorePage(Map<String ,Object>map, @SessionAttribute("foods")List<Food> foods,
                               @SessionAttribute("pageNos")String pageNos){
        // 定义pageSize为每页显示的件数
        int pageSize = 3;
        // 用来获得商品的数量
        // 将数据存到session中以便于在前端获取
        map.put("pageSize", pageSize);
        // 获取当前页的页数并转为int类型,最终将数据存到session中
        int pageNumber;
        if (pageNos == null || Integer.parseInt(pageNos) < 1) {
            pageNumber = 1;
        } else {
            pageNumber = Integer.parseInt(pageNos);
        }
        map.put("pageNos", pageNumber);
        if (foods != null) {
            int typeall = foods.size();
            int countPage = (typeall % pageSize == 0) ? (typeall / pageSize) : typeall / pageSize + 1;
            // 根据sql语句得到查询到的总条数，然后用总条数除每页的条数得到总页数,countPage为总页数
            map.put("countPage", countPage);
            return "storePage";
        } else {
            map.put("msg6", "该店无商品");
            return "customerPage";
        }

    }
}
