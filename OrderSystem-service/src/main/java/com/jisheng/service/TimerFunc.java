package com.jisheng.service;

import com.jisheng.po.Assess;
import com.jisheng.po.Order;
import com.jisheng.service.AssessService;
import com.jisheng.service.OrderService;
import com.jisheng.service.impl.ServiceFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TimerFunc {
	/**
	 * 设置指定24小时后执行
	 */
	public static void orderClose() {
		final Timer timer = new Timer();// 定义计时器
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");// 定义时间格式
		String time = "2018-06-02";// 定义一个启动此线程的初始时间
		Date d = null;
		try {
			d = format.parse(time);// 将String转为Date类型
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				// 这里写修改方法，根据订单号修改状态就可以了
				// 先把符合应定时删除的订单信息用List保存进来，传入。
				OrderService orderServ = ServiceFactory.OrderServ.INSTANCE.getOrderService();
				AssessService assServ = ServiceFactory.AssessServ.INSTANCE.getAssessServ();
				List<Order> orders = orderServ.lookCanDelOrder();
				List<Assess> assessList = assServ.lookAll();
				Date now = new Date();
				String nowDateS = format.format(now);
				long nowDate, oldDateOrder, oldDateAssess;
				Date dateOrder, dateAssess;
				// 对超过一天的,状态为无和已评价订单订单进行删除
				if (orders != null) {
					if (orders.size() != 0) {
						for (Order order : orders) {
							try {
								now = format.parse(nowDateS);
								dateOrder = format.parse(order.getDate());
								nowDate = now.getTime();
								oldDateOrder = dateOrder.getTime();
								if ((nowDate - oldDateOrder) / (1000 * 60 * 60 * 24) >= 7) {
									orderServ.removeOrder(order);
								}
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
				if (assessList != null) {
					if (assessList.size() != 0) {
						// 对超过一个月的评价进行删除
						for (Assess assess : assessList) {
							try {
								now = format.parse(nowDateS);
								dateAssess = format.parse(assess.getDate());
								nowDate = now.getTime();
								oldDateAssess = dateAssess.getTime();
								if ((nowDate - oldDateAssess) / (1000 * 60 * 60 * 24) >= 30) {
									assServ.remove(assess);
								}
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
				// timer.cancel();
			}
			// 1秒等于1000毫秒 这里是一天
		}, d, 24 * 60 * 60 * 1000);// d为该功能启动的起始时间
	}
	public static void main(String[] args) {
		Thread thread=new Thread() {
			@Override
			public void run() {
				System.out.println("Hello World");
				super.run();
			}
		};
		thread.run(); 
	}
}