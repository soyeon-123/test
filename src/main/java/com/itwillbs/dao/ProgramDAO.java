package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.PageDTO;

@Repository
public class ProgramDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mapper.ProgramMapper";
	

	public void insertBoard(BoardDTO boardDTO) {
		System.out.println("programDAO insertBoard()");
		
		sqlSession.insert(namespace+".insertBoard", boardDTO);
		
		
	}//




	public List<BoardDTO> getBoardList(PageDTO pageDTO) {
		System.out.println("programDAO getBoardList()");
		return sqlSession.selectList(namespace+".getBoardList", pageDTO);
	}








	public int getBoardCount() {
		System.out.println("programDAO getBoardCount()");
		
		
		return  sqlSession.selectOne(namespace+".getBoardCount");
	}

	
	
	
}//
