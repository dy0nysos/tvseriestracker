package src.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@org.springframework.stereotype.Controller
@RequestMapping("/index.html")
public class IndexController implements Controller {
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView("showMessage");
		modelAndView.addObject("message","salut le monde youhou");
		return modelAndView;
	}

}
