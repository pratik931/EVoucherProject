package com.example.EVoucherSystem;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.EVoucherSystem.Model.Consumer;
import com.example.EVoucherSystem.Model.Vouchers;
import com.example.EVoucherSystem.Util.VouchersUtil;
import com.example.EVoucherSystem.dao.ConsumerDAO;
import com.example.EVoucherSystem.dao.VoucherDAO;

@Controller
public class ConsumerController {
	@Autowired
	ConsumerDAO consumerDAO;
	
	
	
	@RequestMapping("/index")
	public String indexPage(HttpServletRequest req) {
	
		String name = req.getParameter("name");
		
		HttpSession session = req.getSession();
		session.setAttribute("name", name);
		
		return "index.jsp";
	}
	
	@RequestMapping("/admin")
	public String adminPage() {
		
		return "adminDashboard.jsp";
	}
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("username") String userName,@RequestParam("password") String pwd) {
		
		ModelAndView mv = new ModelAndView("consumer.jsp");
		Consumer consumer = consumerDAO.findConsumer(userName, pwd);
		if(consumer!=null) {
			System.out.println("Welcome " + consumer.getUserName());
			mv.addObject("welcome", "Welcome " + userName);
		}
		else {
			System.out.println("Username or password is incorrect");
			mv.addObject("loginError", "Username or password is incorrect");
			mv.setViewName("index.jsp");
		}
			return mv;
	}
	
	@RequestMapping("/signup")
	public ModelAndView signup(Consumer consumer) {
		ModelAndView mv = new ModelAndView("signupSuccess.jsp");
		System.out.println(consumer.getUserName());
		if(consumerDAO.findByUserName(consumer.getUserName())!= null) {
			mv.addObject("userExists", "This user already exists!");
			mv.setViewName("index.jsp");
			return mv;
		}
		Consumer newConsumer = consumerDAO.save(consumer);
		mv.addObject("newConsumer",newConsumer);
		return mv;
	}
	
	
}
