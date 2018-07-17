package controller;

import com.zengjisheng.www.util.TimerFunc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 为了让定时删除功能伴随Tomcat一起启动
 * @author 63023
 *
 */
@WebServlet(urlPatterns = "/TimerStart", loadOnStartup = 1)
public class TimerStart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("Timer start");
//		new TimerFunc();
		
		TimerFunc.orderClose();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
