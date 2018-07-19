package com.jisheng.controller;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 生成 验证码
 * 
 */
@WebServlet("/checkcode")
public class CheckcodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int width = 120;
		int height = 30;
		// 1、创建一张 内存中缓冲图片
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// 2、背景色
		Graphics graphics = bufferedImage.getGraphics(); // 通过 graphics对象 绘制图片
		// 设置颜色
		graphics.setColor(Color.YELLOW);
		graphics.fillRect(0, 0, width, height);

		// 3、边框
		graphics.setColor(Color.BLUE);
		graphics.drawRect(0, 0, width - 1, height - 1);

		// 4、写验证码内容
		Graphics2D graphics2d = (Graphics2D) bufferedImage.getGraphics();
		graphics2d.setColor(Color.RED);
		// 设置字体
		graphics2d.setFont(new Font("宋体", Font.BOLD, 18));
		String content = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		// 内容四个字符 --- 随机从content中抽取四个字符
		Random random = new Random();
		int x = 10;
		int y = 20;

		StringBuffer stringBuffer = new StringBuffer();

		for (int i = 0; i < 4; i++) { // 循环四次
			// 为字 生成旋转角度 -30 ---- 30
			double jiaodu = random.nextInt(60) - 30;
			// 将旋转角度 换算弧度
			double theta = jiaodu / 180 * Math.PI;
			int index = random.nextInt(content.length());
			char letter = content.charAt(index); // letter 验证码内容
			stringBuffer.append(letter);
			graphics2d.rotate(theta, x, y);
			graphics2d.drawString(letter + "", x, y);
			// 将角度还原
			graphics2d.rotate(-theta, x, y);
			x += 30;
		}

		// 将StringBuffer中四个字 转换 String
		String checkcode = stringBuffer.toString();
		// 将验证码存入session
		request.getSession().setAttribute("checkcodeSession", checkcode);

		// 5 绘制随机干扰线
		int x1;
		int x2;
		int y1;
		int y2;
		graphics.setColor(Color.LIGHT_GRAY);
		for (int i = 0; i < 3; i++) {
			x1 = random.nextInt(width);
			x2 = random.nextInt(width);
			y1 = random.nextInt(height);
			y2 = random.nextInt(height);
			// 根据两点 绘制直线
			graphics.drawLine(x1, y1, x2, y2);
		}

		// 内存中资源 释放
		graphics.dispose();

		// 将图片输出到 浏览器 ImageIO
		// 将内存的图片 通过 浏览器输出流 写成 jpg格式图片
		ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
