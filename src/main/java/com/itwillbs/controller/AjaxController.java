package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.MemberDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.service.BoardService;
import com.itwillbs.service.MemberService;

@RestController
public class AjaxController {
	
	@Inject
	private MemberService memberService;
	@Inject
	private BoardService boardService;
	
	//id 중복체크
		@GetMapping("/member/idCheck")
		public String idCheck(HttpServletRequest request) {
			System.out.println("AjaxController idCheck ");
			String id = request.getParameter("id");
			MemberDTO memberDTO=memberService.getMember(id);

			String result="";
			
			if(memberDTO!=null) {
				//아이디 있음 중복
//				result = "아이디중복"; //한글처리
				result = "iddup";
				
			}else {
				//아이디없음 아이디 사용가능
//				result = "아이디사용가능";
				result = "idok";
			}
			return result;
		}
		
		//게시한 최근글 5개 가져오기
		@GetMapping("/board/listjson")
		public List<BoardDTO> Listjson() {
			System.out.println("AjaxController Listjson");
			
			int pageSize = 5;
			String pageNum = "1";
			int currentPage=Integer.parseInt(pageNum);
			PageDTO pageDTO = new PageDTO();
			pageDTO.setPageSize(pageSize);
			pageDTO.setPageNum(pageNum);
			pageDTO.setCurrentPage(currentPage);
			
			
			List<BoardDTO>boardList=boardService.getBoardList(pageDTO);
			return boardList;
		}

}//
