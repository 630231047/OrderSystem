package com.jisheng.controller.customer;

import com.jisheng.po.Storer;
import com.jisheng.po.User;
import com.jisheng.service.StorerService;
import com.jisheng.service.impl.ServiceFactory;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * 申请店铺
 * @author 63023
 *
 */
@WebServlet("/SubmitApplyServlet")
public class SubmitApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		StorerService stoServ=ServiceFactory.StorerServ.INSTANCE.getStoreServ();
		Storer storer = null;
		try {
			storer = new Storer();
			BeanUtils.populate(storer, request.getParameterMap());
			storer.setUser_id(user.getUser_id());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (stoServ.addStorer(storer)) {
			request.getSession().setAttribute("msg2", "申请添加成功");
			response.sendRedirect("/FoodSystem/applyStore.jsp");
//			request.setAttribute("msg2", "申请添加成功");
////			request.getSession().setAttribute("isStorer", "isStorer");
//			request.getSession().setAttribute("storer", storer);/////////放来干啥
//			request.getRequestDispatcher("/applyStore.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("msg2", "申请添加失败");
			response.sendRedirect("/FoodSystem/applyStore.jsp");
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
