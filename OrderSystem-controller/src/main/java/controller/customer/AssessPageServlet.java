package controller.customer;

import com.zengjisheng.www.po.Assess;
import com.zengjisheng.www.po.Storer;
import com.zengjisheng.www.service.AssessService;
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
 * 某个商家的评价展示
 */
@WebServlet("/AssessPageServlet")
public class AssessPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 通过分页展示某个商家的评价
		 */
		AssessService assServ = ServiceFactory.AssessServ.INSTANCE.getAssessServ();
		// 获得商家的id
		Storer storer = (Storer) request.getSession().getAttribute("store");
		Assess assess = new Assess();
		assess.setStore_id(storer.getStore_id());
		List<Assess> assList = assServ.lookSomeOne(assess);
		request.getSession().setAttribute("assessList", assList);
		// 定义pageSize为每页显示的件数
		int pageSize = 3;
		// 将数据存到session中以便于在前台获取
		request.getSession().setAttribute("pageSize", pageSize);
		// 获取当前页的页数并转为int类型,最终将数据存到session中
		int pageNos;
		if (request.getParameter("pageNos") == null || Integer.parseInt(request.getParameter("pageNos")) < 1) {
			pageNos = 1;
		} else {
			pageNos = Integer.parseInt(request.getParameter("pageNos"));
		}
		request.getSession().setAttribute("pageNos", pageNos);
		//防止后面的typeall赋值出错
		if (assList == null)
			assList = new ArrayList<Assess>();
		if (assList.size() == 0) {
			request.setAttribute("msg1", "该店无评价");
			request.getRequestDispatcher("storePage.jsp").forward(request, response);
			return;
		} else {
			int typeall = assList.size();
			int countPage = (typeall % pageSize == 0) ? (typeall / pageSize) : typeall / pageSize + 1;
			// 根据得到的查询到的总条数，然后用总条数除每页的条数得到总页数,countPage为总页数
			request.getSession().setAttribute("countPage", countPage);
			request.getRequestDispatcher("assessPage.jsp").forward(request, response);
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
