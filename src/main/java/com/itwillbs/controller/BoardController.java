package com.itwillbs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	// BoardService 자동으로 객체생성
	@Inject
	private BoardService boardService;

	//가상주소 http://localhost:8080/TourWeb/board/write
	// WEB-INF/views/notice/write.jsp 주소변경없이 이동 
	@GetMapping("/write")
	public String write() {
		// WEB-INF/views/notice/write.jsp 주소변경없이 이동 
		return "/notice/write";
	}
	
	//가상주소 http://localhost:8080/TourWeb/board/writePro
	//글목록 주소 변경하면서 이동
	@PostMapping("/writePro")
	public String writePro(BoardDTO boardDTO) {
		System.out.println("BoardController writePro()");
		System.out.println(boardDTO);
		//글쓰기 처리
		// 패키지 com.itwillbs.service  파일이름 BoardService
		// 리턴할형없음 insertBoard(BoardDTO boardDTO) 메서드 정의
		
		// insertBoard(boardDTO) 메서드 호출
		boardService.insertBoard(boardDTO);
		
		//글목록 주소 변경하면서 이동
		return "redirect:/board/list";
	}
	
	//가상주소 http://localhost:8080/TourWeb/board/list
	//가상주소 http://localhost:8080/TourWeb/board/list?pageNum=2
	@GetMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		// request에 저장된 파라미터값 pageNum = 2 가져오기
		String pageNum = request.getParameter("pageNum");
		// 파라미터값 pageNum 없으면 => 1페이지로 설정
		if(pageNum == null) {
			pageNum = "1";
		}
		// pageNum => 정수형 변경
		int currentPage = Integer.parseInt(pageNum);
		// 한 화면에 보여줄 글 개수 설정 
		int pageSize = 10;
		
		//검색어 가져오기
		String search = request.getParameter("search");
		
		// PageDTO 객체생성
		PageDTO pageDTO = new PageDTO();
		// pageNum, currentPage, pageSize => 값을 저장
		pageDTO.setPageNum(pageNum);
		pageDTO.setCurrentPage(currentPage);
		pageDTO.setPageSize(pageSize);
		//검색어
		pageDTO.setSearch(search);
		
//		ArrayList<BoardDTO> boardList = new ArrayList<BoardDTO>();
		// 부모인테페이스 = 자식클래스 객체생성
//		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		
		List<BoardDTO> boardList = boardService.getBoardList(pageDTO);
		
		// 게시판 전체 글 개수 구하기
		// 검색어 포함
		int count = boardService.getBoardCount(pageDTO);
		// 한 화면에 보여줄 페이지 개수 5 설정
		int pageBlock = 5;
		// 시작하는 페이지 번호 구하기
		int startPage = (currentPage-1) / pageBlock * pageBlock + 1;
		// 끝나는 페이지 번호 구하기
		int endPage = startPage + pageBlock - 1;
		// 전체 글개수 구하기  50/10 => 5 , 55/10 => 5 나머지 5 1페이지 증가
		int pageCount = count / pageSize + (count % pageSize==0?0:1);
		// endPage 전체 글개수 비교 => endPage 크면 전체 글개수로 변경
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		// pageDTO에 구한값 저장
		pageDTO.setCount(count);
		pageDTO.setPageBlock(pageBlock);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		pageDTO.setPageCount(pageCount);
		
		// model에 데이터 담아서 전달
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageDTO", pageDTO);
		
		// WEB-INF/views/notice/notice.jsp 주소변경없이 이동 
		return "/notice/notice";
	}
	
	//가상주소 http://localhost:8080/TourWeb/board/content
	// WEB-INF/views/notice/content.jsp 주소변경없이 이동 
	@GetMapping("/content")
	public String content() {
		// WEB-INF/views/notice/content.jsp 주소변경없이 이동 
		return "/notice/content";
	}
	
	

	
	
}
