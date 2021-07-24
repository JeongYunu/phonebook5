package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {
	
	@Autowired
	private PhoneDao phoneDao;
	
	// 전체 리스트
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("PhoneController.list");
		List<PersonVo> personList = phoneDao.getPersonList();
		model.addAttribute("personList", personList);
		
		return "/WEB-INF/views/list.jsp";
	}
	
	// 쓰기폼
	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("PhoneController.writeForm");
		return "/WEB-INF/views/writeForm.jsp";
	}
	
	// 저장
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController.write");
		phoneDao.personInsert(personVo);
		
		return "redirect:/list";
	}	
	
	// 수정폼
	@RequestMapping(value = "/updateForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateForm(Model model, @ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController.updateForm");
		PersonVo personInfo = phoneDao.getPersonListOne(personVo);
		model.addAttribute("personInfo", personInfo);
		
		return "/WEB-INF/views/updateForm.jsp";
	}
	
	//수정
	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String update(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController.update");
		phoneDao.personUpdate(personVo);
		
		return "redirect:/list";
	}
	
	//삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController.delete");
		phoneDao.personDelete(personVo);
		
		return "redirect:/list";
	}
}
