package com.example.EVoucherSystem;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.EVoucherSystem.Model.Vouchers;
import com.example.EVoucherSystem.Util.VouchersUtil;
import com.example.EVoucherSystem.dao.VoucherDAO;

@Controller
public class VoucherController {
	@Autowired
	VoucherDAO vouchersDAO;
	
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
