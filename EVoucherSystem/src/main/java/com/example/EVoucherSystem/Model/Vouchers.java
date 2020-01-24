package com.example.EVoucherSystem.Model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Vouchers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int voucherID;
	private String voucherCode;
	private Date voucherStartDate;
	private Date voucherEndDate;
	private BigDecimal voucherAmount; 
	private boolean redeemFlag;
	@ManyToOne
	private Consumer consumer;
	public int getVoucherID() {
		return voucherID;
	}
	public void setVoucherID(int voucherID) {
		this.voucherID = voucherID;
	}
	
	public String getVoucherCode() {
		return voucherCode;
	}
	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}
	public Date getVoucherStartDate() {
		return voucherStartDate;
	}
	public void setVoucherStartDate(Date voucherStartDate) {
		this.voucherStartDate = voucherStartDate;
	}
	public Date getVoucherEndDate() {
		return voucherEndDate;
	}
	public void setVoucherEndDate(Date voucherEndDate) {
		this.voucherEndDate = voucherEndDate;
	}
	public BigDecimal getVoucherAmount() {
		return voucherAmount;
	}
	public void setVoucherAmount(BigDecimal voucherAmount) {
		this.voucherAmount = voucherAmount;
	}
	public boolean isRedeemFlag() {
		return redeemFlag;
	}
	public void setRedeemFlag(boolean redeemFlag) {
		this.redeemFlag = redeemFlag;
	}
	
	@Override
	public String toString() {
		return "Vouchers [voucherID=" + voucherID + ", voucherCode=" + voucherCode + ", voucherStartDate="
				+ voucherStartDate + ", voucherEndDate=" + voucherEndDate + ", voucherAmount=" + voucherAmount
				+ ", redeemFlag=" + redeemFlag + "]";
	}

}
