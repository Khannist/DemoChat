package com.inus.chat.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inus.chat.vo.MemberVO;

@RestController
public class ChatController {
	@Autowired
	private SqlSession ss;
	
	@RequestMapping({("/index"),("/")})
	public ModelAndView indexList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/index");
		return mav;
	}
	
	// 멤버리스트 
	@RequestMapping("/list")
	public ModelAndView viewList(Model model) {
		ModelAndView mav = new ModelAndView();
		List<MemberVO> memberList = ss.selectList("ChatMapper.getMember");
		mav.addObject("bList", memberList);
		mav.setViewName("/list");
		
		return mav;
	}
	
	//회원가입화면
	@RequestMapping("/insert")
	public ModelAndView insertList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/insert");
		return mav;
	}
	
	
	// 멤버리스트 
	@RequestMapping("/checkRegi")
	public ModelAndView checkRegi(MemberVO mVo) {
		ModelAndView mav = new ModelAndView();
		String Uid = ss.selectOne("ChatMapper.checkRegi",mVo.getUserId());
		System.out.println("mVo = " + mVo.getName());
		if(Uid == null || Uid.equals("")) {
			mav.addObject("mVo",mVo);
			mav.setViewName("forward:insertOK");
		}else {
			mav.addObject("msg", "이미 있는 아이디입니다.");
			mav.setViewName("insert");
		}
		return mav;
	}
		
	// 회원가입
	@RequestMapping("insertOK")
	public ModelAndView insertOK(MemberVO mVo) {
		System.out.println("mVo.getName = " + mVo.getName());
		ModelAndView mav = new ModelAndView();
		ss.insert("ChatMapper.insertMember",mVo);
		
		mav.setViewName("/index");
		return mav;
	}
	
	
	
	
	
	
	
}
