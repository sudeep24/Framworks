package com.user.service.login;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.user.dao.dataobject.UserInfo;
import com.user.dao.impl.UserIfoServiceDaoImpl;
import com.user.service.bean.UserInifoBean;

@Controller
@SessionAttributes
public class LoginService {
	
	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute("userInfoBean") UserInifoBean userInfobean, BindingResult result) {

		UserIfoServiceDaoImpl userIfoServiceDaoImpl = new UserIfoServiceDaoImpl();
		UserInifoBean userbean = userIfoServiceDaoImpl.queryInfoById(userInfobean.getId());
		if (userbean != null && userbean.getId().equals(userInfobean.getId())) {
			return "redirect:success.html";
		}
		return "redirect:fail.html";
	}

	@RequestMapping("/success")
	public ModelAndView showSuccess() {
		return new ModelAndView("success", "command", new UserInifoBean());
	}

	@RequestMapping(value = "/userRegister", method = RequestMethod.POST)
	public String doRegister(@ModelAttribute("userInfoBean") UserInifoBean userInifoBean, BindingResult result) {
		UserIfoServiceDaoImpl userIfoServiceDaoImpl = new UserIfoServiceDaoImpl();

		if ((userInifoBean.getId() != null) && (userInifoBean.getName() != null)
				&& (userInifoBean.getPassword() != null)) {
			UserInfo userInfo = new UserInfo();
			userInfo.setUserId(userInifoBean.getId());
			userInfo.setName(userInifoBean.getName());
			userInfo.setPassword(userInifoBean.getPassword());
			userIfoServiceDaoImpl.saveUserInfo(userInfo);
			return "redirect:registerd.html";
		}
		return "redirect:fail.html";
	}

	@RequestMapping("/registerd")
	public ModelAndView registerdSuccess() {
		return new ModelAndView("register", "command", new UserInifoBean());
	}

	@RequestMapping("/fail")
	public ModelAndView fail() {
		return new ModelAndView("fail", "command", new UserInifoBean());
	}
}
