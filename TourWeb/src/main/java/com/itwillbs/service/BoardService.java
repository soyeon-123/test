package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.BoardDAO;
import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.PageDTO;

@Service
public class BoardService {
	// BoardDAO 자동으로 객체생성
	@Inject
	private BoardDAO boardDAO;
	
	public void insertBoard(BoardDTO boardDTO) {
		System.out.println("BoardService insertBoard");
		// 글쓰기 처리
		// 패키지 com.itwillbs.dao  파일이름 BoardDAO
		// num 구하기 => max(num) + 1
		// int getMaxNum() 메서드 정의
		//     getMaxNum() 메서드 호출 + 1
		boardDTO.setNum(boardDAO.getMaxNum() + 1);
		// readcount 조회수 0 설정
		boardDTO.setReadcount(0);
		// date  시스템 오늘 날짜 설정
		boardDTO.setDate(new Timestamp(System.currentTimeMillis()));
		
		// 리턴할형없음 insertBoard(BoardDTO boardDTO) 메서드 정의
		// insertBoard(boardDTO) 메서드 호출
		boardDAO.insertBoard(boardDTO);
	}

	public List<BoardDTO> getBoardList(PageDTO pageDTO) {
		System.out.println("BoardService getBoardList");
		// 시작하는 행번호 구하기  1, 11, 21,...
		int startRow = (pageDTO.getCurrentPage()-1) * pageDTO.getPageSize() + 1;
		// 끝나는 행번호 구하기 10 20 30 
		int endRow = startRow + pageDTO.getPageSize() - 1;
		
		// pageDTO startRow, endRow 저장
		// limit   시작하는 행번호 - 1, 글개수 
		pageDTO.setStartRow(startRow - 1);
		pageDTO.setEndRow(endRow);
		
		return boardDAO.getBoardList(pageDTO);
	}

	//검색어 포함
	public int getBoardCount(PageDTO pageDTO) {
		System.out.println("BoardService getBoardCount");
		
		return boardDAO.getBoardCount(pageDTO);
	}
	
	
}
