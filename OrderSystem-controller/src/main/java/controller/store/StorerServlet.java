package controller.store;

import com.zengjisheng.www.po.Storer;
import com.zengjisheng.www.po.User;
import com.zengjisheng.www.service.StorerService;
import com.zengjisheng.www.service.impl.ServiceFactory;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * 用来修改或增加商家信息
 */
@WebServlet("/StorerServlet")
public class StorerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StorerService storerServ = ServiceFactory.StorerServ.INSTANCE.getStoreServ();
		User user = (User) request.getSession().getAttribute("user");
		Storer storer = (Storer) request.getSession().getAttribute("storer");
		if (storer == null) {
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
			if (storerServ.addStorer(storer)) {
				request.setAttribute("msg2", "商家添加成功");
				request.getSession().setAttribute("storer", storer);
				request.getRequestDispatcher("/storerregister.jsp").forward(request, response);
			} else {
				request.setAttribute("msg2", "商家添加失败");
				request.getRequestDispatcher("/storerregister.jsp").forward(request, response);
			}
		} else {
			try {
				BeanUtils.populate(storer, request.getParameterMap());
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (storerServ.updateStorer(storer)) {
				request.setAttribute("msg3", "商家修改成功");
				request.getSession().setAttribute("storer", storer);
				request.getRequestDispatcher("/storerregister.jsp").forward(request, response);
			} else {
				request.setAttribute("msg3", "商家修改失败");
				request.getRequestDispatcher("/storerregister.jsp").forward(request, response);
			}

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
