package controller.customer;

import com.zengjisheng.www.po.Customer;
import com.zengjisheng.www.po.Food;
import com.zengjisheng.www.po.Order;
import com.zengjisheng.www.po.Storer;
import com.zengjisheng.www.service.FoodService;
import com.zengjisheng.www.service.OrderService;
import com.zengjisheng.www.service.StorerService;
import com.zengjisheng.www.service.impl.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 获得该顾客和所有店铺信息
 * @author 63023
 *
 */
@WebServlet("/StoreServlet")
public class StoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		if (customer == null) {
			request.setAttribute("msg6", "请先完善个人信息");
			request.getRequestDispatcher("customerPage.jsp").forward(request, response);
			return;
		}
		// 获得商铺名
		Storer storer = new Storer();
		String storeName = request.getParameter("storeName");
		storer.setStore_name(storeName);
		StorerService storeServ = ServiceFactory.StorerServ.INSTANCE.getStoreServ();
		// 获得商铺信息
		List<Storer> stores = storeServ.lookSomeOne(storer);
		// 防止在输入网址时查找不存在的店铺信息
		if (stores == null)
			stores = new ArrayList<>();
		if (stores.size() == 0) {
			request.setAttribute("msg6", "请在此页面选择正确店家");
			request.getRequestDispatcher("customerPage.jsp").forward(request, response);
			return;
		}
		Storer store = stores.get(0);
		FoodService foodServ = ServiceFactory.FoodServ.INSTANCE.getFoodService();
		Food food = new Food();
		food.setStore_id(store.getStore_id());
		request.getSession().setAttribute("store", store);
		// 根据排序选择获得对应信息
		String foodOrd = request.getParameter("orders");// 这里的foodOrd是顺序
		// 获得店铺中食物信息
		List<Food> foods = null;
		if (foodOrd != null) {
			String search = request.getParameter("search");
			if (search != null)
				food.setName(search);
			if (foodOrd.equals("asc"))
				foods = foodServ.lookPriceInOrder(food, true);
			else
				foods = foodServ.lookPriceInOrder(food, false);
		} else
			foods = foodServ.lookSomeOne(food);
		request.getSession().setAttribute("foods", foods);
		// 查看该顾客的购物车订单信息
		Order order = new Order();
		OrderService orderServ = ServiceFactory.OrderServ.INSTANCE.getOrderService();
		order.setCustomer_id(customer.getId());
		order.setStore_id(store.getStore_id());
		List<Object[]> orders = orderServ.lookCusOrder1(order);
		request.getSession().setAttribute("orders", orders);
		response.sendRedirect("/StorePageServlet");
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
