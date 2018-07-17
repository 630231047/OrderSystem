package controller.customer;

import com.zengjisheng.www.po.Food;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 在店铺中展示分页的商品信息
 * @author 63023
 *
 */
@WebServlet("/StorePageServlet")
public class StorePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 定义pageSize为每页显示的件数
		int pageSize = 3;
		// 用来获得商品的数量
		@SuppressWarnings("unchecked")
		List<Food> foods = (List<Food>) request.getSession().getAttribute("foods");
		// 将数据存到session中以便于在前端获取
		request.getSession().setAttribute("pageSize", pageSize);
		// 获取当前页的页数并转为int类型,最终将数据存到session中
		int pageNos;
		if (request.getParameter("pageNos") == null || Integer.parseInt(request.getParameter("pageNos")) < 1) {
			pageNos = 1;
		} else {
			pageNos = Integer.parseInt(request.getParameter("pageNos"));
		}
		request.getSession().setAttribute("pageNos", pageNos);
		if (foods != null) {
			int typeall = foods.size();
			int countPage = (typeall % pageSize == 0) ? (typeall / pageSize) : typeall / pageSize + 1;
			// 根据sql语句得到查询到的总条数，然后用总条数除每页的条数得到总页数,countPage为总页数
			request.getSession().setAttribute("countPage", countPage);
			request.getRequestDispatcher("storePage.jsp").forward(request, response);
		} else {
			request.setAttribute("msg6", "该店无商品");
			request.getRequestDispatcher("customerPage.jsp").forward(request, response);
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
