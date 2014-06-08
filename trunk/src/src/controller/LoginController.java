package src.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import src.service.ConnexionService;
@org.springframework.stereotype.Controller
public class LoginController implements Controller {

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		ConnexionService connexionService = (ConnexionService)context.getBean("connexionService");
		return null;
	}
	@RequestMapping(value="/connecter",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView connecter(HttpServletRequest response,
			HttpServletResponse request) throws Exception {
		return null;
	}

}
