package br.com.cinefolos.cine.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cinefolos.cine.daos.UserDAO;
import br.com.cinefolos.cine.models.User;
import br.com.cinefolos.cine.validation.CinefolosValidation;
//import br.com.cinefolos.cine.models.User;

@Controller
//@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserDAO userDao;
	
	@org.springframework.web.bind.annotation.InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.addValidators(new CinefolosValidation());
	}
	
	@GetMapping("/listar")
	//@ResponseBody
	public ModelAndView list() {
		List<User> users = userDao.listar();
		ModelAndView modelAndView = new ModelAndView("list");
		modelAndView.addObject("users", users);
		
		return modelAndView;
	}

	@GetMapping("/form")
	public ModelAndView form(User user) {
		ModelAndView modelAndView = new ModelAndView("form");
		
		return modelAndView;
	}
	
	@PostMapping()
	public ModelAndView gravar(@Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			return form(user);
		}
		
		userDao.gravar(user);
		
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");

	    return new ModelAndView("redirect:listar");
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") long id){
	    ModelAndView modelAndView = new ModelAndView("/editar");
	    User user = userDao.find(id);
	    modelAndView.addObject("user", user);
	    return modelAndView;
	}
	
	@RequestMapping("alterar")
	public ModelAndView alterar(@Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {
		userDao.alterar(user);
		
		redirectAttributes.addFlashAttribute("sucesso", "Usuário alterado com sucesso!");
		
		return new ModelAndView("redirect:listar");
	}
	
	@RequestMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") long id){
	    userDao.removeById(id);
        
		return "redirect:/listar";
	}

}
