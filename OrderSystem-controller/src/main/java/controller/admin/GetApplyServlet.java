package controller.admin;

import com.zengjisheng.www.po.Storer;
import com.zengjisheng.www.service.StorerService;
import com.zengjisheng.www.service.impl.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 获得需要审核的用户信息
 * 
 * @author 63023
 *
 */
@WebServlet("/GetApplyServlet")
public class GetApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StorerService stoServ = ServiceFactory.StorerServ.INSTANCE.getStoreServ();
		List<Storer> applyStores = stoServ.lookAllApply();
		request.getSession().setAttribute("applyStores", applyStores);
//		response.sendRedirect("/FoodSystem/admin.jsp");
		request.getRequestDispatcher("/admin.jsp").forward(request, response);
		return;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
