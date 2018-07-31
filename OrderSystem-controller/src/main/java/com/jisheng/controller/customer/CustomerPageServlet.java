package com.jisheng.controller.customer;


import com.jisheng.po.Storer;
import com.jisheng.service.StorerService;
import com.jisheng.service.impl.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 根据选择得到不同的店铺数据,并进行分页
 */
@WebServlet("/CustomerPageServlet111")

public class CustomerPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StorerService storerServ = ServiceFactory.StorerServ.INSTANCE.getStoreServ();
		List<Storer> storerList = null; // 定义pageSize为每页显示的件数
		int pageSize = 3;
		// 将数据存到session中以便于在前端获取
		request.getSession().setAttribute("pageSize", pageSize);
		String param = request.getParameter("operation");
		// 如果有参数,则获取模糊查询按照评分排序查找的结果
		if (param != null) {
			String storeName = request.getParameter("search");
			Storer storer = new Storer();
			storer.setStore_name(storeName);
			storerList = storerServ.lookSomeOne2(storer);
		} else// 如果无参数，则获取按照评分排序的所有商家
			storerList = storerServ.lookAll();
		request.getSession().setAttribute("storerList", storerList);
		// 获取当前页的页数并转为int类型,最终将数据存到session中
		int pageNos;
		if (request.getParameter("pageNos") == null || Integer.parseInt(request.getParameter("pageNos")) < 1) {
			pageNos = 1;
		} else {
			pageNos = Integer.parseInt(request.getParameter("pageNos"));
		}
		request.getSession().setAttribute("pageNos", pageNos);
		int typeall = storerList.size();
		int countPage = (typeall % pageSize == 0) ? (typeall / pageSize) : typeall / pageSize + 1;
		// 通过得到的查询到的总条数，然后用总条数除每页的条数得到总页数,countPage为总页数
		request.getSession().setAttribute("countPage", countPage);
		request.getRequestDispatcher("customerPage.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}