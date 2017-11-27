package com.itheima.crm.service;

import java.util.List;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.utils.Page;

public interface CustomerService {
	Page<Customer> list(QueryVo vo);
	Customer selectCustomerById(Integer id);
	void updateCustomer(Customer customer);
	void deleteCustomer(Integer id);
}
