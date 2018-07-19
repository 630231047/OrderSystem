package com.jisheng.controller.customer;

import com.jisheng.bo.LookCusOrder1;
import com.jisheng.po.Order;
import com.jisheng.service.OrderService;
import com.jisheng.service.impl.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 进行支付操作
 * 
 * @author 63023
 *
 */
@WebServlet("/PayServlet")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderService orderServ = ServiceFactory.OrderServ.INSTANCE.getOrderService();
		// 付款
		// 直接获得所勾选的id和某个商品的总价钱
		String[] orderArrays = (String[]) request.getParameterValues("isCorrect");
		int amount = 0;
		// 下面的代码中,ord为Order的变量,而order为一个类型为Object[]的数组
		Order ord = new Order();
		if (orderArrays != null) {
			for (String ordArray : orderArrays) {
				amount += Double.parseDouble(ordArray.split(",")[1]);

				ord.setId(Integer.parseInt(ordArray.split(",")[0]));
				ord = orderServ.lookCusOrder2(ord);
				if (ord != null) {
					ord.setStatus("已付款");
					orderServ.updateOrder(ord);
				} else
					request.setAttribute("msg1", "支付失败");
			}
			// 更新信息
			List<LookCusOrder1> orders = orderServ.lookCusOrder1(ord);
			request.getSession().setAttribute("orders", orders);
			request.getSession().setAttribute("foodsPrice", amount);
		} else
			request.setAttribute("msg1", "请选择至少一个商品");
		// 获得购物车中信息
		request.getRequestDispatcher("/storePage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
