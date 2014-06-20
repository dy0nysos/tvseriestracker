package src.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	/**
	 * Cette méthode permet de lancer l'authentification d'un utilisateur. Elle diffère de la première méthode par l'ajout de deux paramètres obligatoires, username,passwoprd
	 * @param request un HTTPServletRequest
	 * @param response un HTTPServletResponse
	 * @param userName une chaine contenant le login de l'utilisateur
	 * @param password une chaine contenant le mot de passe de l'utilisateur
	 * @return un ModalAndView
	 * @throws Exception
	 */
	@RequestMapping(value="/login",method={RequestMethod.GET,RequestMethod.POST},params={"username","password"})
	public ModelAndView loginRequest(HttpServletRequest request,
			HttpServletResponse response,@RequestParam("username") String userName, @RequestParam("password") String password) throws Exception {
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		ConnexionService connexionService = (ConnexionService)context.getBean("connexionService");
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("userName",userName);
		modelAndView.addObject("password",password);
		return modelAndView;
	}

}
