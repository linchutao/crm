package com.itheima.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.crm.mapper.CustomerMapper;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.utils.Page;
@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerMapper customerMapper;
	
	public Page<Customer> list(QueryVo vo) {
		Page<Customer> page = new Page<Customer>();
		//查询总行数
		Integer total = customerMapper.count(vo);
		page.setTotal(total);
		vo.setStart((vo.getPage()-1)*vo.getRows());
		List<Customer> list = customerMapper.queryCustomer(vo);
		page.setRows(list);
		page.setPage(vo.getPage());
		page.setSize(10);
		return page;
	}

	public Customer selectCustomerById(Integer id) {
		return customerMapper.selectCustomerById(id);
	}

	public void updateCustomer(Customer customer) {
		customerMapper.updateCustomer(customer);
	}

	public void deleteCustomer(Integer id) {
		customerMapper.deleteCustomer(id);
	}
	
	
}
