package com.jisheng.controller.customer;

import com.jisheng.po.Customer;
import com.jisheng.po.Food;
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
 * 对购物车进行操作
 * @author 63023
 *
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderService orderServ = ServiceFactory.OrderServ.INSTANCE.getOrderService();
		String foodIndex = (String) request.getParameter("foodIndex");
		int index = 0;
		@SuppressWarnings("unchecked")
		List<Food> foods = (List<Food>) request.getSession().getAttribute("foods");
		Food food = null;
		if (foodIndex != null && foodIndex != "") {
			index = Integer.parseInt(foodIndex);
			if (foods.size() != 0 && foods != null)
				food = foods.get(index - 1);
			else
				System.out.println("Error in OrderServlet");
		} else {
			System.out.println("Error in OrderServlet index");
			return;
		}
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		Order order = new Order();
		order.setFood_id(food.getId());
		order.setCustomer_id(customer.getId());
		order.setStore_id(food.getStore_id());
		order.setStatus("购物车");
		List<Order> orderList = orderServ.lookSomeOne(order);// 查看某个订单的情况
		String operation = request.getParameter("operation");
		Order getOrder = null;
		switch (operation) {
		case "1": {// 将物品添加进购物车
			if (foods != null && orderList.size() != 0) {
				getOrder = orderList.get(0);
				getOrder.setNum(getOrder.getNum() + 1);
				if (orderServ.updateOrder(getOrder))
					// request.getSession().setAttribute("msg1", "添加成功");
					request.setAttribute("msg1", "添加成功");
				else
					// request.getSession().setAttribute("msg1", "添加失败");
					request.setAttribute("msg1", "添加失败");
			} else {
				order.setNum(1);
				if (orderServ.addOrder(order))
					// request.getSession().setAttribute("msg1", "添加成功");
					request.setAttribute("msg1", "添加成功");
				else
					// request.getSession().setAttribute("msg1", "添加失败");
					request.setAttribute("msg1", "添加失败");
			}
			break;
		}
		case "2": {// 将物品移出购物车
			if (orderList.size() != 0 && foods != null) {
				getOrder = orderList.get(0);
				int num = getOrder.getNum();
				if (num != 1) {
					getOrder.setNum(getOrder.getNum() - 1);
					if (orderServ.updateOrder(getOrder))
						// request.getSession().setAttribute("msg1", "移出成功");
						request.setAttribute("msg1", "移出成功");
					else
						// request.getSession().setAttribute("msg1", "移出失败");
						request.setAttribute("msg1", "移出失败");

				} else
					// request.getSession().setAttribute("msg1", "数量为1，不能减少");
					request.setAttribute("msg1", "数量为1，不能减少");
			} else {
				// request.getSession().setAttribute("msg1", "移出失败，没有找到订单");
				request.setAttribute("msg1", "移出失败，没有找到订单");
			}
			break;
		}
		case "3": {// 将物品移除
			if (orderList.size() != 0 && foods != null) {
				getOrder = orderList.get(0);
				if (orderServ.removeOrder(getOrder))
					// request.getSession().setAttribute("msg1", "移除成功");
					request.setAttribute("msg1", "移除成功");
				else
					// request.getSession().setAttribute("msg1", "移除失败");
					request.setAttribute("msg1", "移除失败");
			} else
				// request.getSession().setAttribute("msg1", "移除失败");
				request.setAttribute("msg1", "移除失败");
			break;

		}

		default:
			System.out.println("Error in OrderServlet.switch");
		}
		// 获得购物车中信息
		List<Object[]> orders = orderServ.lookCusOrder1(order);
		request.getSession().setAttribute("orders", orders);
		request.getRequestDispatcher("/storePage.jsp").forward(request, response);
		// response.sendRedirect("/FoodSystem/storePage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
