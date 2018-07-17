package controller.store;

import com.zengjisheng.www.po.Food;
import com.zengjisheng.www.po.Order;
import com.zengjisheng.www.po.Storer;
import com.zengjisheng.www.service.FoodService;
import com.zengjisheng.www.service.OrderService;
import com.zengjisheng.www.service.impl.ServiceFactory;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 对商品进行删除和修改
 * @author 63023
 */
@WebServlet("/FoodServlet")
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 得到店家界面中的操作和操作对象,在此页面中进行删除或修改
		String operation = request.getParameter("operation");
		String foodIndex = request.getParameter("foodIndex");
		FoodService foodServ = ServiceFactory.FoodServ.INSTANCE.getFoodService();
		@SuppressWarnings("unchecked")
		List<Food> foods = (List<Food>) request.getSession().getAttribute("foods");
		 Food food = foods.get(Integer.parseInt(foodIndex) - 1);
		if (operation.equals("2")) {// 进行删除操作
			OrderService orderServ = ServiceFactory.OrderServ.INSTANCE.getOrderService();
			Order order = new Order();
			order.setFood_id(food.getId());
			// 如果存在已支付而且未送达的订单，则删除失败
			if (orderServ.lookFoodState(order).size() != 0)
				request.getSession().setAttribute("msg5", "删除失败，请先处理已付款的订单");
			else {
				if (foodServ.removeFood(food))
					request.getSession().setAttribute("msg5", "删除商品成功");
				else
					request.getSession().setAttribute("msg5", "删除商品失败");
			}
			//更新商品信息
			foods = foodServ.lookSomeOne(food);
			request.getSession().setAttribute("foods", foods);
			response.sendRedirect("/FoodSystem/StorerPageServlet");
			return;
		} else if (operation.equals("3")) {// 进行修改操作
			try {
				BeanUtils.populate(food, request.getParameterMap());
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Storer storer = (Storer) request.getSession().getAttribute("storer");
			food.setStore_id(storer.getStore_id());
			if (foodServ.updateFood(food))
				request.setAttribute("msg4", "修改商品成功");
			else
				request.setAttribute("msg4", "修改商品失败");
			//更新商品信息
			List<Food> foodList = foodServ.lookSomeOne(food);
			request.getSession().setAttribute("foods", foodList);
			request.getRequestDispatcher("/updateFood.jsp").forward(request, response);
		}
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
