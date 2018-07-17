package controller.customer;

import com.zengjisheng.www.po.Customer;
import com.zengjisheng.www.po.Storer;
import com.zengjisheng.www.service.StorerService;
import com.zengjisheng.www.service.impl.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用于顾客申请商家
 * @author 63023
 *
 */
@WebServlet("/ApplyStoreServlet")
public class ApplyStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StorerService stoServ = ServiceFactory.StorerServ.INSTANCE.getStoreServ();
		Customer cus = (Customer) request.getSession().getAttribute("customer");
		if(cus==null) {
			request.setAttribute("msgStatus", "请先完善顾客信息");
			request.getRequestDispatcher("/applyStore.jsp").forward(request, response);
			return;
		}
		Storer storer = new Storer();
		storer.setUser_id(cus.getUser_id());
		storer = stoServ.lookSomeOne1(storer);
		// 如果该顾客无申请过店铺
		if (storer == null) {
			// 允许申请
			request.setAttribute("msgStatus", null);
		} else if (storer.getStatus().equals("审核中")) {
			// 不允许申请
			request.setAttribute("msgStatus", "正在审核中,请耐心等待");
		} else if (storer.getStatus().equals("正常")) {
			// 不允许申请
			request.setAttribute("msgStatus", "您已拥有商铺,请前往登陆界面以商家角色登陆");
		} else {
			// 不允许申请
			request.setAttribute("msgStatus", "您无权申请店铺");
		}
		request.getRequestDispatcher("/applyStore.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
