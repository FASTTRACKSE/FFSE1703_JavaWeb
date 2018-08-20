package com.fasttrackse.controllers;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.fasttrackse.beans.Emp;
import com.fasttrackse.dao.EmpDao;
@Controller
public class EmpController {
    @Autowired
	EmpDao dao;
	@RequestMapping("/empform")
	public ModelAndView showform(){
		return new ModelAndView("empform","command",new Emp());
	}

	@RequestMapping(value="/save",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("emp") Emp emp){
		dao.save(emp);
		return new ModelAndView("redirect:/viewemp/1");
	}
	
	@RequestMapping(value = "/viewemp/{pageid}")
	public ModelAndView viewemp(@PathVariable int pageid, Model model) throws SQLException{
		double perPage = 2;
		double pageTotal = (int) Math.ceil(dao.countSV()/perPage);
 		int start = (pageid-1)*(int)perPage;
		List<Emp> list=dao.getEmployees(start,(int)perPage);
		model.addAttribute("pageid", pageid);
		model.addAttribute("pagetotal",pageTotal);
		return new ModelAndView("viewemp","list",list);
	}

	@RequestMapping(value="/editemp/{id}")
	public ModelAndView edit(@PathVariable int id){
		Emp emp=dao.getEmpById(id);
		return new ModelAndView("empeditform","command",emp);
	}
	
	@RequestMapping(value="/editsave",method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("emp") Emp emp){
		dao.update(emp);
		return new ModelAndView("redirect:/viewemp/1");
	}
	@RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id){
		dao.delete(id);
		return new ModelAndView("redirect:/viewemp/1");
	}

}