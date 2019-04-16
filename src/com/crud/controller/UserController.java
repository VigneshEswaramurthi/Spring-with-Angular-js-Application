package com.crud.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.crud.bean.UserBean;
import com.crud.service.IretrieveService;
import com.crud.service.Iretrievedataservice;

@RestController
public class UserController
{
	
	@Autowired
	public IretrieveService retrieveService;
	
	@Autowired
	public Iretrievedataservice retrievedataservice;

	@RequestMapping(value="/toRegister")
	public ModelAndView toRegister(Model model)
	{
		// Make sure to add model of UserBean in which login 
		// userName and password will be stored from the login form 
		model.addAttribute("userBean", new UserBean());
		// "login" will be resolved to login.jsp
		// where login-form is presented to user
 		return new ModelAndView("register");
	}
	@RequestMapping(value="/doRegister", method = RequestMethod.POST)
	public ModelAndView doRegister(@RequestBody UserBean userBean, BindingResult result)
	{
		if(!result.hasFieldErrors())
		{
			if(retrieveService.insert(userBean) != null)
			{
				System.out.println("inserted");
			}
		}
		RedirectView rv = new RedirectView();
        rv.setUrl("welcomes");
        return new ModelAndView("register");
		}
	@RequestMapping(value="/welcomes", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody Object welcomes(UserBean userBean, HttpServletResponse response)
	{ 
		List<UserBean> usernames=new ArrayList<UserBean>();
	    usernames = retrievedataservice.findAllUsers(userBean);
	    System.out.println(usernames.size());
        return usernames;
	}
	
	@RequestMapping(value="/delete/{username}")
	@ResponseBody
	public String delete(@PathVariable String username) 
	{
	    System.out.println("delete1" + username);
	    retrievedataservice.delete(username);
	    System.out.println("delete2");
	    return "delete successfully";
	}
	
	
}

