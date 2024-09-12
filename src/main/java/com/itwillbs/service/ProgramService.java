package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.BoardDAO;
import com.itwillbs.dao.ProgramDAO;
import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.PageDTO;

@Service
public class ProgramService {

	@Inject
	private ProgramDAO programDAO;	
	
	public void insertBoard(BoardDTO boardDTO) {
		System.out.println("programService insertBoard()");
		
		//조회수 readcount 0 설정
		boardDTO.setReadcount(0);
		
		//글쓴날짜 date 시스템 날짜 설정
		boardDTO.setDate(new Timestamp(System.currentTimeMillis()));
		
		//ProgramDAO 객체 생성 insertBoard() 메서드 호출
		programDAO.insertBoard(boardDTO);
		
	}

	public List<BoardDTO> getBoardList(PageDTO pageDTO) {
		System.out.println("programSerivce getBoadList");
		
		//시작하는 행번호 구하기
		int startRow = (pageDTO.getCurrentPage()-1)*pageDTO.getPageSize()+1;
		
		
		//끝 행번호 구하기
		int endRow = startRow+pageDTO.getPageSize()-1;
		
		
		//pageDTO값 저장
		//limit startRow-1, pageSize
		pageDTO.setStartRow(startRow-1);
		pageDTO.setEndRow(endRow);
		
		
				
		return programDAO.getBoardList(pageDTO);
	}

	public int getBoardCount() {
		System.out.println("programSerivce getBoardCount");
		
		
		
		return programDAO.getBoardCount();
	}

		
		
		
		

	
	
	
	
	
	
	
	
	
}//
