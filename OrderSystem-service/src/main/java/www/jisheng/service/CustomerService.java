package www.jisheng.service;

import com.zengjisheng.www.po.Customer;

import java.util.List;

public interface CustomerService {
	/**
	 * 添加新顾客
	 * 
	 * @param user
	 *            新顾客
	 * @return true - 添加成功 false - 添加失败
	 */
	boolean addCustomer(Customer customer);

	/**
	 * 删除顾客
	 */
	boolean removeCustomer(Customer customer);
	/**
	 * 更改顾客信息
	 */
	boolean updateCustomer(Customer customer);
	/**
	 * 搜索顾客
	 */
	List<Customer> lookSomeOne(Customer customer);
	/**
	 * 得到所有顾客信息
	 */
	List<Customer> lookAll();
}
