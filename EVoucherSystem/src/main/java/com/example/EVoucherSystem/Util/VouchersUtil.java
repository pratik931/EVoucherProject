package com.example.EVoucherSystem.Util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.EVoucherSystem.Model.Vouchers;

public class VouchersUtil {
	private static final int NUMBEROFVOUCHERS = 10;
	private static final long DAYSTOADD = 15;
	private static final long DAYSTOSUBTRACT = 15;
	private static final LocalDate STARTDATE = LocalDate.now().minusDays(DAYSTOSUBTRACT);
	private static final LocalDate ENDDATE = LocalDate.now().plusDays(DAYSTOADD);
	private static final int AMOUNTRANGE = 100;
	
	public static List<Vouchers> getVouchersList() {
		
			List<Vouchers> vouchers = new ArrayList<Vouchers>();
			for(int i=0;i<NUMBEROFVOUCHERS;i++) {
				Vouchers voucher = new Vouchers();
				voucher.setVoucherCode(generateVoucherCode());
				voucher.setVoucherStartDate(generateVoucherStartDate());
				voucher.setVoucherEndDate(generateVoucherEndDate());
				voucher.setVoucherAmount(generateVoucherAmount());
				voucher.setRedeemFlag(isValidVoucher(voucher));
				voucher.setAssigned(false);
				System.out.println(voucher);
				vouchers.add(voucher);
			}
		
		return vouchers;
		
	}
	
	
	public static String generateVoucherCode() {
		
		int codeLength = 10;
		String alphaNumericPattern = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] chars = alphaNumericPattern.toCharArray();
        StringBuilder voucher = new StringBuilder();
        Random random = new SecureRandom();
        for (int i = 0; i < codeLength; i++) {
            char c = chars[random.nextInt(chars.length)];
            voucher.append(c);
        }
        String voucherCode = voucher.toString();
       
        return voucherCode ;
	}
	
	public static Date generateVoucherStartDate() {
		int days = (int) ChronoUnit.DAYS.between(STARTDATE, ENDDATE);
		Random random = new SecureRandom();
		Date voucherStartDate = Date.valueOf(STARTDATE.plusDays(random.nextInt(days - 10)));
		
		
		return voucherStartDate;
	}
	
	public static Date generateVoucherEndDate() {
		int days = (int) ChronoUnit.DAYS.between(STARTDATE, ENDDATE);
		Random random = new SecureRandom();
		Date voucherEndDate = Date.valueOf(ENDDATE.plusDays(random.nextInt(days - 10)));
		
		
		return voucherEndDate;
	}
	
	public static BigDecimal generateVoucherAmount() {
		BigDecimal max = new BigDecimal(AMOUNTRANGE);
        BigDecimal randFromDouble = new BigDecimal(Math.random());
        BigDecimal actualRandomDec = randFromDouble.multiply(max);
        actualRandomDec = actualRandomDec
                .setScale(2, RoundingMode.DOWN);
        
        return actualRandomDec; 
	}
	
	public static boolean isValidVoucher(Vouchers voucher) {
		Date currentDate = Date.valueOf(LocalDate.now());
		int comparisonResult = voucher.getVoucherEndDate().compareTo(currentDate);
		
		if(comparisonResult < 0 || voucher.isAssigned())
			return false;
		else
			return true;
		
	}
	
}
