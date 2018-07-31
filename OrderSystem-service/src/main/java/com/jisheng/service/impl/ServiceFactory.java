package com.jisheng.service.impl;

import com.jisheng.service.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用简单工厂加枚举单例来实现只有一个service对象
 * 
 * @author 63023
 *
 */
public class ServiceFactory {
	public enum AdminServ {
		INSTANCE;
		@Autowired
		private AdminService adminServ;

		public AdminService getAdminServ() {
			return adminServ;
		}
	}

	public enum AssessServ {
		INSTANCE;
		@Autowired
		private AssessService assessServ;

		public AssessService getAssessServ() {
			return assessServ;
		}
	}

	public enum CusServ {
		INSTANCE;
		@Autowired
		private CustomerService cusServ;

		public CustomerService getCusService() {
			return cusServ;
		}

	}

	public enum FoodServ {
		INSTANCE;
		@Autowired
		private FoodService foodServ;

		public FoodService getFoodService() {
			return foodServ;
		}
	}

	public enum OrderServ {
		INSTANCE;
		@Autowired
		private OrderService orderServ;

		public OrderService getOrderService() {
			return orderServ;
		}
	}

	public enum StorerServ {
		INSTANCE;
		@Autowired
		private StorerService storerServ;

		public StorerService getStoreServ() {
			return storerServ;
		}
	}

	public enum UserServ {
		INSTANCE;
		@Autowired
		private UserService userServ;

		UserServ() {
			userServ = new UserServiceImpl();
		}

		public UserService getUserServ() {
			return userServ;
		}
	}
}
