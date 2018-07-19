package com.jisheng.controller.store;


import com.jisheng.controller.BaseUpload;
import com.jisheng.po.Food;
import com.jisheng.po.Storer;
import com.jisheng.service.FoodService;
import com.jisheng.service.impl.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 把BaseUpload作为工具类,得到一个List,再进行数据封装
 * @author 63023
 *
 */
@WebServlet("/UploadStorer")
public class UploadStorerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BaseUpload upStoServl = new BaseUpload();
		FoodService foodServ = ServiceFactory.FoodServ.INSTANCE.getFoodService();
		Food food = new Food();
		Storer storer = (Storer) request.getSession().getAttribute("storer");
		food.setStore_id(storer.getStore_id());
		upStoServl.setPath("E:/Program Files/javaee/FoodSystem/WebContent/upload");
		upStoServl.doGet(request, response);
		List<String> fileList = upStoServl.getFileList();
		if(fileList!=null) {
		food.setName( fileList.get(0));
		food.setPrice(Float.parseFloat(fileList.get(1)));
		food.setUuidname( fileList.get(2));
		food.setSavepath( fileList.get(3));
		if (foodServ.addFood(food)) {
			request.setAttribute("msg4", "添加商品成功");
		} else
			request.setAttribute("msg4", "添加商品失败");
		// 上传后，跳回主页
		List<Food> foods = foodServ.lookSomeOne(food);

		if (foods.size() != 0)
			request.getSession().setAttribute("foods", foods);
		response.sendRedirect("/FoodSystem/storerRefresh.jsp");
		}
		else {
			request.setAttribute("msgPerError", "请确认图片格式是否正确");
			request.getRequestDispatcher("/storerPage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
