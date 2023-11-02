package com.ukbtech.springwithhibernatecrudapp.app.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.MySQLDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ukbtech.springwithhibernatecrudapp.app.model.student;

@Controller
public class HomeController {

	@Autowired
	SessionFactory sf;
	
	@RequestMapping("/")
	public String preLogin()
	{
		return "login";
	}
	
	@RequestMapping("/openregister")
	public String preregister()
	{
		return "register";
	}
	
	@RequestMapping("/save")
	public String studentRegister(@ModelAttribute student s)
	{
		Session se = sf.openSession();
		se.save(s);
		se.beginTransaction().commit();
		
		return "login";
	}
}
