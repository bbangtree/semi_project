package com.fm.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fm.action.Action;
import com.fm.action.ActionForward;
import com.fm.dao.MemberDAO;
import com.fm.dto.MemberDTO;

public class AlterInfo implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward af=new ActionForward();
		MemberDTO mDto=new MemberDTO();
		MemberDAO mdDao=new MemberDAO();
		
		mDto.setId(request.getParameter("id"));
		mDto.setPw(request.getParameter("pw1"));
		mDto.setName(request.getParameter("name"));
		mDto.setGender(request.getParameter("gender"));
		mDto.setBirth1(request.getParameter("birth1"));
		mDto.setBirth2(request.getParameter("birth2"));
		mDto.setBirth3(request.getParameter("birth3"));
		mDto.setMail1(request.getParameter("mail1"));
		mDto.setMail2(request.getParameter("mail2"));
		mDto.setPhone1(request.getParameter("phone1"));
		mDto.setPhone2(request.getParameter("phone2"));
		mDto.setPhone3(request.getParameter("phone3"));
		mDto.setCkmessage(request.getParameter("ckmessage"));
		
		mDto=mdDao.alterInfo(mDto);
		
		if(mDto != null){
			request.setAttribute("message", "회원정보 수정 완료");
			af.setPath("/sub/myPage/myPage_result.jsp");
			af.setRedirect(true);
		}else{
			request.setAttribute("message", "회원정보 수정 실패");
			af.setPath("/sub/myPage/myPage_result.jsp");
			af.setRedirect(false);
		}
		return af;
	}

}
