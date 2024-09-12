package com.itwillbs.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.PageDTO;

@Repository
public class BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mapper.BoardMapper";

	public int getMaxNum() {
		System.out.println("BoardDAO getMaxNum()");
		return sqlSession.selectOne(namespace + ".getMaxNum");
	}

	public void insertBoard(BoardDTO boardDTO) {
		System.out.println("BoardDAO insertBoard()");
		
		sqlSession.insert(namespace + ".insertBoard", boardDTO);
	}

	public List<BoardDTO> getBoardList(PageDTO pageDTO) {
		System.out.println("BoardDAO getBoardList()");
		
		return sqlSession.selectList(namespace + ".getBoardList", pageDTO);
	}

	//검색어 포함
	public int getBoardCount(PageDTO pageDTO) {
		System.out.println("BoardDAO getBoardCount()");
		
		return sqlSession.selectOne(namespace + ".getBoardCount",pageDTO);
	}

}
