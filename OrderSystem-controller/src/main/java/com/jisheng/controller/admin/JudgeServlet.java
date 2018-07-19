package com.jisheng.controller.admin;

import com.jisheng.po.Storer;
import com.jisheng.po.User;
import com.jisheng.service.AdminService;
import com.jisheng.service.StorerService;
import com.jisheng.service.impl.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 审批申请店铺信息
 * 
 * @author 63023
 *
 */
@WebServlet("/JudgeServlet")
public class JudgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StorerService stoServ = ServiceFactory.StorerServ.INSTANCE.getStoreServ();
		String[] userIds = request.getParameterValues("isCorrect");
		if (userIds == null) {
			request.getSession().setAttribute("msg6", "请确认是否已选择申请信息");
			response.sendRedirect("/FoodSystem/admin.jsp");
			return;
		}
		Storer storer = new Storer();
		String submit = (String) request.getParameter("submit");
		// 对审核中的信息进行操作
		for (String s : userIds) {
			storer.setUser_id(Integer.parseInt(s));
			storer = stoServ.lookSomeOne1(storer);
			if (submit.equals("allow")) {
				if (storer != null) {
					storer.setStatus("正常");
					if (stoServ.updateStatus(storer)) {
						AdminService adminServ = ServiceFactory.AdminServ.INSTANCE.getAdminServ();
						User user = new User();
						user.setUser_id(storer.getUser_id());
						if (adminServ.addStoRole(user))
							request.getSession().setAttribute("msg6", "批准成功");
						else
							request.getSession().setAttribute("msg6", "批准操作（增加角色）失败");
					}
				}
			} else if (submit.equals("reject")) {
				if (storer != null) {
					if (stoServ.removeStorer(storer)) {
						request.getSession().setAttribute("msg6", "拒绝成功");
					} else
						request.getSession().setAttribute("msg6", "批准操作（删除）失败");
				}
			}
		}
		response.sendRedirect("/FoodSystem/GetApplyServlet");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
