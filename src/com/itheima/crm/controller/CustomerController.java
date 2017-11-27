package com.itheima.crm.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.BaseDictService;
import com.itheima.crm.service.CustomerService;
import com.itheima.crm.utils.Page;

@Controller
public class CustomerController {
	
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	
	@Value("${customer_from}")
	private String customer_from;
	@Value("${cust_industry}")
	private String cust_industry;
	@Value("${cust_level}")
	private String cust_level;
	
	@RequestMapping(value="list")
	public String list(Model model,QueryVo queryVo) {
		
		
		
		List<BaseDict> fromType = baseDictService.queryBaseDictByDictTypeCode(customer_from);
		List<BaseDict> industryType = baseDictService.queryBaseDictByDictTypeCode(cust_industry);
		List<BaseDict> levelType = baseDictService.queryBaseDictByDictTypeCode(cust_level);
		
		Page<Customer> page = customerService.list(queryVo);
		
		// 把分页查询的结果放到模型中
		model.addAttribute("page", page);

		// 数据回显
		model.addAttribute("custName", queryVo.getCustName());
		model.addAttribute("custSource", queryVo.getCustSource());
		model.addAttribute("custIndustry", queryVo.getCustIndustry());
		model.addAttribute("custLevel", queryVo.getCustLevel());
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		return "customer";
	}
	//回显
	@RequestMapping(value="edit")
	public @ResponseBody Customer edit(Integer id) {
		Customer customer = customerService.selectCustomerById(id);
		return customer;
	}
	//修改客户信息
	@RequestMapping(value="update")
	public @ResponseBody String update(Customer customer) {
		customerService.updateCustomer(customer);
		return "OK";
	}
	//删除客户
	@RequestMapping(value="delete")
	public @ResponseBody String delete(Integer id) {
		customerService.deleteCustomer(id);
		return "OK";
	}
}
