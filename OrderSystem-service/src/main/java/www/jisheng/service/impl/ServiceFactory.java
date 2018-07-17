package www.jisheng.service.impl;

import com.zengjisheng.www.service.*;

/**
 * 用简单工厂加枚举单例来实现只有一个service对象
 * 
 * @author 63023
 *
 */
public class ServiceFactory {
	public enum AdminServ {
		INSTANCE;
		private AdminService adminServ;

		AdminServ() {
			adminServ = new AdminServiceImpl();
		}

		public AdminService getAdminServ() {
			return adminServ;
		}
	}

	public enum AssessServ {
		INSTANCE;
		private AssessService assessServ;

		AssessServ() {
			assessServ = new AssessServiceImpl();
		}

		public AssessService getAssessServ() {
			return assessServ;
		}
	}

	public enum CusServ {
		INSTANCE;
		private CustomerService cusServ;

		CusServ() {
			cusServ = new CustomerServiceImpl();
		}

		public CustomerService getCusService() {
			return cusServ;
		}

	}

	public enum FoodServ {
		INSTANCE;
		private FoodService foodServ;

		FoodServ() {
			foodServ = new FoodServiceImpl();
		}

		public FoodService getFoodService() {
			return foodServ;
		}
	}

	public enum OrderServ {
		INSTANCE;
		private OrderService orderServ;

		OrderServ() {
			orderServ = new OrderServiceImpl();
		}

		public OrderService getOrderService() {
			return orderServ;
		}
	}

	public enum StorerServ {
		INSTANCE;
		private StorerService storerServ;

		StorerServ() {
			storerServ = new StorerServiceImpl();
		}

		public StorerService getStoreServ() {
			return storerServ;
		}
	}

	public enum UserServ {
		INSTANCE;
		private UserService userServ;

		UserServ() {
			userServ = new UserServiceImpl();
		}

		public UserService getUserServ() {
			return userServ;
		}
	}
}
