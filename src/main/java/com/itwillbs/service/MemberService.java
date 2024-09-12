package com.itwillbs.service;

import java.sql.Timestamp;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.domain.MemberDTO;

@Service
public class MemberService {
	// MemberDAO 멤버변수 정의 => 자동으로 객체생성
	@Inject
	private MemberDAO memberDAO;
	
	// 리턴할형없음 insertMember(MemberDTO memberDTO 주소 저장하는 변수) 메서드 정의
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberService insertMember()");
		//이메일
		memberDTO.setEmail(memberDTO.getEmail()+"@"+memberDTO.getEmail2());
		//agree => 체크 안 한 경우 disagree
		if(memberDTO.getAgree() == null) {
			memberDTO.setAgree("disagree");
		}
		//가입날짜
		memberDTO.setDate(new Timestamp(System.currentTimeMillis()));
		//회원가입
		// 패키지 com.itwillbs.dao 파일 MemberDAO 만들기
		// 리턴할형없음 insertMember(MemberDTO memberDTO 주소 저장하는 변수) 메서드 정의
		
		// insertMember(memberDTO 주소값) 메서드 호출
		memberDAO.insertMember(memberDTO);
	}

	public MemberDTO userCheck(MemberDTO memberDTO) {
		System.out.println("MemberService userCheck()");
		
		return memberDAO.userCheck(memberDTO);
	}


	public MemberDTO getMember(String id) {
		System.out.println("MemberService getMember()");
		
		return memberDAO.getMember(id);
	}

	public void updateMember(MemberDTO memberDTO) {
		System.out.println("MemberService updateMember()");
		
		memberDAO.updateMember(memberDTO);
	}


	
}
