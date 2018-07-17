package controller.store;

import com.zengjisheng.www.po.Order;
import com.zengjisheng.www.service.OrderService;
import com.zengjisheng.www.service.impl.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 由商家确认订单,将订单状态改为已送达
 * @author 63023
 *
 */
@WebServlet("/SendServlet")
public class SendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderService orderServ = ServiceFactory.OrderServ.INSTANCE.getOrderService();
		// 付款
		String[] foodNamePrice = request.getParameterValues("isCorrect");
		if (foodNamePrice == null) {
			request.setAttribute("msg6", "请确认是否已选择订单");
			request.getRequestDispatcher("/lookOrder.jsp").forward(request, response);
			return;
		}
		Order order = new Order();
		for (String s : foodNamePrice) {
			order.setId(Integer.parseInt(s));
			order = orderServ.lookCusOrder2(order);
			if (order != null) {
				order.setStatus("已送达");
				orderServ.updateOrder(order);
			}
		}
		List<Object[]> orderPaidList = orderServ.lookCusPaidOrder(order);
		request.getSession().setAttribute("orderPaidList", orderPaidList);
		// 获得购物车中信息
		request.getRequestDispatcher("/lookOrder.jsp").forward(request, response);
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
