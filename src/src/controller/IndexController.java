package src.controller;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@org.springframework.stereotype.Controller
/**
 * On arrive sur ce controller depuis l'accueil? En toute logique, on charge index.jsp dans WEB-INF/jsp et on affiche l'accueil du site!
 * @author dyonysos
 */
public class IndexController implements Controller {
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("message","salut le monde youhou");
		return modelAndView;
	}
//	@RequestMapping(value="/index/{idUser}",method=RequestMethod.GET)
//	public ModelAndView userLookup(HttpServletRequest req,HttpServletResponse res,@PathVariable String idUser){
//		ModelAndView modelAndView = new ModelAndView("index");
//		modelAndView.addObject("message",idUser);
//		return modelAndView;
//	}

}
