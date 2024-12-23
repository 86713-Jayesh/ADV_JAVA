package com.sunbeam.beans;

import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class RegistrationBean {
	
	private String firstname;
	private String lastname;
	private String email;
	private String passwd;
	private String dob;
	private int count;
	

	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public void registerU() {
		try (UserDao userDao=new UserDaoImpl())
		{
		Date d= Date.valueOf(dob);
		User user=new User(0,firstname,lastname,email,passwd,d,0,"voter");

		count=userDao.save(user);
    	
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
}
