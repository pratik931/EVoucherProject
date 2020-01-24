package com.example.EVoucherSystem;

import javax.servlet.http.HttpSession;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.EVoucherSystem.Model.Consumer;
import com.example.EVoucherSystem.Model.Vouchers;
import com.example.EVoucherSystem.Util.VouchersUtil;
import com.example.EVoucherSystem.dao.ConsumerDAO;
import com.example.EVoucherSystem.dao.VoucherDAO;

@Controller
public class VoucherController {
	@Autowired
	ConsumerDAO consumerDAO;
	
	@Autowired
	VoucherDAO vouchersDAO;
	
	@RequestMapping("/index")
	public String callIndex(HttpServletRequest req) {
	
		String name = req.getParameter("name");
		
		HttpSession session = req.getSession();
		session.setAttribute("name", name);
		
		return "index.jsp";
	}
	
	@RequestMapping("/admin")
	public String callAdmin() {
		
		return "adminDashboard.jsp";
	}
	
	@RequestMapping("/login")
	public String login(Consumer consumer) {
		System.out.println("Login me aaya");
		System.out.println(consumer.getUserName());
		System.out.println(consumer.getUserPwd());
		return "index.jsp";
	}
	
	@RequestMapping("/signup")
	public ModelAndView signup(Consumer consumer) {
		System.out.println(consumer.getUserName());
		
		Consumer newConsumer = consumerDAO.save(consumer);
		ModelAndView mv = new ModelAndView("signupSuccess.jsp");
		mv.addObject("newConsumer",newConsumer);
		return mv;
	}
	
	@RequestMapping("/generateVouchers")
	public ModelAndView addVouchers() {
		List<Vouchers>vouchers =  VouchersUtil.getVouchersList();
		for(Vouchers voucher: vouchers) {
			voucher.getVoucherID();
			vouchersDAO.save(voucher);
		}
		ModelAndView mv = new ModelAndView("voucherGenerationMessage.jsp");
		mv.addObject("vouchers",vouchers);
		return mv;
	}
	
	@RequestMapping("/showVouchers")
	public ModelAndView showVouchers() {
		List<Vouchers> allVouchers = (List<Vouchers>) vouchersDAO.findAll();
		System.out.println(allVouchers.toString());		
		ModelAndView mv = new ModelAndView("allValidVouchersList.jsp");
		mv.addObject("allVouchers", allVouchers);
		return mv;
		
	}
	
	
}
