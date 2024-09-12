package com.itwillbs.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberDTO;

@Repository
public class MemberDAO {
	
	// 마이바티스 자동 객체생성
	@Inject
	private SqlSession sqlSession;
	
	//sql구문 전체 이름 변수 정의
	private static final String namespace="com.itwillbs.mapper.MemberMapper";

	// 리턴할형없음 insertMember(MemberDTO memberDTO 주소 저장하는 변수) 메서드 정의
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberDAO insertMember()");
		
		sqlSession.insert(namespace + ".insertMember", memberDTO);
	}

	public MemberDTO userCheck(MemberDTO memberDTO) {
		System.out.println("MemberDAO userCheck()");
		
		return sqlSession.selectOne(namespace + ".userCheck", memberDTO);
	}

	public MemberDTO getMember(String id) {
		System.out.println("MemberDAO getMember()");
		
		return sqlSession.selectOne(namespace + ".getMember", id);
	}

	public void updateMember(MemberDTO memberDTO) {
		System.out.println("MemberDAO updateMember()");
		
		sqlSession.update(namespace + ".updateMember", memberDTO);
	}
	
	
}
