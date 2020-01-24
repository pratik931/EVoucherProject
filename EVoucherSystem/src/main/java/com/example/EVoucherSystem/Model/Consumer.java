package com.example.EVoucherSystem.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Consumer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int consumerID;
	private String userName;
	private String userPwd;
	private String userMobileNumber;
	@OneToMany
	private Vouchers voucher;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserMobileNumber() {
		return userMobileNumber;
	}
	public void setUserMobileNumber(String userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
	@Override
	public String toString() {
		return "Consumer [userName=" + userName + ", userPwd=" + userPwd + ", userMobileNumber=" + userMobileNumber
				+ "]";
	}
	
	
	
}
