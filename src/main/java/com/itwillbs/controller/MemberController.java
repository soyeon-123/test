package com.itwillbs.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	// MemberService 멤버변수 정의 => 자동으로 객체생성
	@Inject
	private MemberService memberService;
	
//	//id 중복체크
//	@GetMapping("/idCheck")
//	@ResponseBody
//	public String idCheck(HttpServletRequest request) {
//		System.out.println("MemberController idCheck ");
//		String id = request.getParameter("id");
//		MemberDTO memberDTO=memberService.getMember(id);
//
//		String result="";
//		
//		if(memberDTO!=null) {
//			//아이디 있음 중복
////			result = "아이디중복"; //한글처리
//			result = "iddup";
//			
//		}else {
//			//아이디없음 아이디 사용가능
////			result = "아이디사용가능";
//			result = "idok";
//		}
//		return result;
//	}

	//가상주소 http://localhost:8080/TourWeb/member/insert
	@GetMapping("/insert")
	public String insert() {
		// WEB-INF/views/member/join.jsp 주소변경없이 이동 
		return "/member/join";
	}
	
	@PostMapping("/insertPro")
	public String insertPro(MemberDTO memberDTO) {
		System.out.println("MemberController insertPro");
		System.out.println(memberDTO);
		//회원가입
		// 패키지 com.itwillbs.service 파일 MemberService 만들기
		// 리턴할형없음 insertMember(MemberDTO memberDTO 주소 저장하는 변수) 메서드 정의
		
		// insertMember(memberDTO 주소값) 메서드 호출
		memberService.insertMember(memberDTO);
		
		// 로그인 주소변경 이동
		return "redirect:/member/login";
	}
	
	//가상주소 http://localhost:8080/TourWeb/member/login
	@GetMapping("/login")
	public String login() {
		// WEB-INF/views/member/login.jsp 주소변경없이 이동 
		return "/member/login";
	}
	
	@PostMapping("/loginPro")
	public String loginPro(MemberDTO memberDTO,HttpSession session) {
		System.out.println("MemberController loginPro");
		System.out.println(memberDTO);
		
		MemberDTO memberDTO2 = memberService.userCheck(memberDTO);
		if(memberDTO2 != null) {
			//아이디 비밀번호 일치
			//세션에 로그인 표시값 저장 "id",id값
			session.setAttribute("id", memberDTO.getId());
			// 메인페이지로 이동
			return "redirect:/member/main";
		}else {
			// 아이디 비밀번호 틀림
			// 로그인페이지로 이동
//			return "redirect:/member/login";
			// 방문 했던 페이지로 한칸 뒤로 이동
			// member/msg.jsp 이동
			return "/member/msg";
		}
	}
	
	//가상주소 http://localhost:8080/TourWeb/member/main
	// WEB-INF/views/main/main.jsp 주소변경없이 이동 
	@GetMapping("/main")
	public String main() {
		// WEB-INF/views/main/main.jsp 주소변경없이 이동 
		return "/main/main";
	}
	
	//가상주소 http://localhost:8080/TourWeb/member/logout
	// 로그인 표시값 삭제 (세션 기억장소 전체 삭제)
	// 주소 변경 되면서 /member/main 이동
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("MemberController logout");
		session.invalidate();
		return "redirect:/member/main";
	}
	
	//가상주소 http://localhost:8080/TourWeb/member/update
	@GetMapping("/update")
	public String update(HttpSession session, Model model) {
//		HttpSession session = request.getSession();
		// 세션에서 로그인표시 "id" => String id
		String id = (String)session.getAttribute("id");
		// MemberDTO memberDTO = getMember(id) 메서드 호출
		MemberDTO memberDTO = memberService.getMember(id);
		// model에 "memberDTO",memberDTO 담아서 이동
		model.addAttribute("memberDTO", memberDTO);
		// WEB-INF/views/member/update.jsp 주소변경없이 이동 
		return "/member/update";
	}
	
	//가상주소 http://localhost:8080/TourWeb/member/updatePro
	// userCheck(memberDTO)=> 아이디 비밀번호 일치 => 수정 updateMember(memberDTO) 
	//                                      => 주소 변경 되면서 /member/main 이동
	//                     => 아이디 비밀번호 틀림 => member/msg.jsp 이동 
	@PostMapping("/updatePro")
	public String updatePro(MemberDTO memberDTO) {
		System.out.println("MemberController updatePro");
		
		MemberDTO memberDTO2 = memberService.userCheck(memberDTO);
		if(memberDTO2 != null) {
			//아이디 비밀번호 일치
			//=> 수정 updateMember(memberDTO) 
			memberService.updateMember(memberDTO);
			// 메인페이지로 이동
			return "redirect:/member/main";
		}else {
			// 아이디 비밀번호 틀림
			// 방문 했던 페이지로 한칸 뒤로 이동
			// member/msg.jsp 이동
			return "/member/msg";
		}
	}
	
	
	
}//클래스
