package controller.customer;

import com.zengjisheng.www.controller.BaseUpload;
import com.zengjisheng.www.po.Assess;
import com.zengjisheng.www.po.Customer;
import com.zengjisheng.www.po.Order;
import com.zengjisheng.www.po.Storer;
import com.zengjisheng.www.service.AssessService;
import com.zengjisheng.www.service.OrderService;
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
 * 把BaseUpload作为工具类,得到一个List,再进行数据封装
 * 
 * @author 63023
 *
 */
@WebServlet("/UploadAssess")
public class UploadAssessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BaseUpload upAssServl = new BaseUpload();
		Assess assess = new Assess();
		Storer storer = new Storer();
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		assess.setCustomer_id(customer.getId());
		upAssServl.setPath("E:/Program Files/javaee/FoodSystem/WebContent/uploadAccess");
		upAssServl.doGet(request, response);
		List<String> fileList = upAssServl.getFileList();
		if(fileList==null) {
			request.setAttribute("msgPerError", "请确认图片格式是否正确");
			request.getRequestDispatcher("/customerPage.jsp").forward(request, response);
			return;
		}
		// 评分为0,评语为1,order_id为4,Store_id为5,uuidname为2,savepath为3
		storer.setStore_id(Integer.parseInt(fileList.get(5)));
		assess.setStore_id(Integer.parseInt(fileList.get(5)));
		assess.setMark(Integer.parseInt(fileList.get(0)));
		assess.setWords(fileList.get(1));
		assess.setUuidname(fileList.get(2));
		assess.setSavepath(fileList.get(3));

		/**
		 * storer.setStore_id(Integer.parseInt(fileItems.get(4).getString("UTF-8")));
		 * assess.setStore_id(Integer.parseInt(fileItems.get(4).getString("UTF-8")));
		 * assess.setMark(Integer.parseInt(fileItems.get(0).getString("UTF-8")));
		 * assess.setWords(fileItems.get(1).getString("UTF-8"));
		 */

		// 将内容插入数据库
		AssessService assessServ = ServiceFactory.AssessServ.INSTANCE.getAssessServ();
		if (assessServ.add(assess)) {
			OrderService orderServ = ServiceFactory.OrderServ.INSTANCE.getOrderService();
			Order order = new Order();
			order.setId(Integer.parseInt(fileList.get(4)));
			order = orderServ.lookCusOrder2(order);
			if (order != null) {
				order.setStatus("已评价");
				orderServ.updateOrder(order);
				// 得到该店铺的平均评分
				float avgMark = assessServ.getStoreMark(assess);
				storer.setAvg_mark(avgMark);
				StorerService stoServ = ServiceFactory.StorerServ.INSTANCE.getStoreServ();
				if (stoServ.updateMark(storer))
					request.setAttribute("msg4", "添加评价成功");
			}
		} else
			request.setAttribute("msg4", "添加评价失败");
		// 上传后，跳回主页
		List<Assess> assessList = assessServ.lookSomeOne(assess);
		if (assessList.size() != 0)
			request.getSession().setAttribute("assessList", assessList);
		response.sendRedirect("/assessRefresh.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
