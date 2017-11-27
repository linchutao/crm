package com.itheima.crm.mapper;

import java.util.List;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

public interface CustomerMapper {
	List<Customer> queryCustomer(QueryVo vo);
	Integer count(QueryVo vo);
	Customer selectCustomerById(Integer id);
	void updateCustomer(Customer customer);
	void deleteCustomer(Integer id);
}
