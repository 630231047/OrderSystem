package com.jisheng.controller.customer;

import com.jisheng.po.Storer;
import com.jisheng.service.StorerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes(names = {"storerList","countPage","pageSize","pageNos"})
public class CustomerPageController {
    @Autowired
    StorerService storerService;

    @RequestMapping(value = "CustomerPageServlet", method = RequestMethod.GET)
    public String getCustomerPage(Map<String, Object> map,
                                  @RequestParam(value = "operation",required = false) String param,
                                  @RequestParam(value = "search", required = false) String storeName,
                                  @RequestParam(value = "pageNos",required = false)String pageNos) {
        // 定义pageSize为每页显示的件数
        List<Storer> storerList = null;
        int pageSize = 3;
        // 将数据存到session中以便于在前端获取
        map.put("pageSize", pageSize);
        // 如果有参数,则获取模糊查询按照评分排序查找的结果
        if (param != null) {
            Storer storer = new Storer();
            storer.setStore_name(storeName);
            storerList = storerService.lookSomeOne2(storer);
        } else {
            // 如果无参数，则获取按照评分排序的所有商家
            storerList = storerService.lookAll();
        }
        map.put("storerList", storerList);
        // 获取当前页的页数并转为int类型,最终将数据存到session中
        int pageNumber;
        if (pageNos == null || Integer.parseInt(pageNos) < 1) {
            pageNumber = 1;
        } else {
            pageNumber = Integer.parseInt(pageNos);
        }
        map.put("pageNos", pageNumber);
        int typeall = storerList.size();
        int countPage = (typeall % pageSize == 0) ? (typeall / pageSize) : typeall / pageSize + 1;
        // 通过得到的查询到的总条数，然后用总条数除每页的条数得到总页数,countPage为总页数
        map.put("countPage", countPage);
        return "customerPage";


    }
}
