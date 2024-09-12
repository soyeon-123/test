package com.itwillbs.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.service.ProgramService;

@Controller
@RequestMapping("/program/*")
public class ProgramController {
	
	// ProgramService객체생성
	@Inject
	private ProgramService programService;
	
	// 업로드 파일경로 servlet-context.xml 에서 가져오기
	// <beans:bean id="uploadPath" class="java.lang.String">
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	//가상주소 http://localhost:8080/TourWeb/program/program
	//가상주소 http://localhost:8080/TourWeb/program/program?pageNum=2
	// WEB-INF/views/program/program.jsp 주소변경없이 이동 
	@GetMapping("/program")
	public String program(HttpServletRequest request, Model model) {
		// 현페이지 가져오기
		String pageNum = request.getParameter("pageNum");
		// 현페이지 없으면 1로 설정
		if(pageNum == null) {
			pageNum = "1";
		}
		// 현페이지 => 정수형 변경 
		int currentPage = Integer.parseInt(pageNum);
		// 한 화면에 보여줄 글개수 설정 12개 설정
		int pageSize = 12;
		
		// PageDTO 객체생성
		PageDTO pageDTO = new PageDTO();
		// set메서드 호출 값을 저장
		pageDTO.setPageNum(pageNum);
		pageDTO.setCurrentPage(currentPage);
		pageDTO.setPageSize(pageSize);
		
		//페이징처리
		
		//전체 게시판 글 개수 구하기
		int count = programService.getBoardCount();
		
		//한 화면에 보여줄 페이지 개수 설정
		int pageBlock = 5; 
				
		//시작하는 페이지 번호 구하기
		int startPage= (currentPage-1)/pageBlock*pageBlock+1; 
		
		//끝 페이지 번호 구하기
		int endPage = startPage+pageBlock-1;

		//전체페이지 개수 구하기
		int pageCount = count/pageSize+(count % pageSize ==0 ? 0:1);
		
		if(endPage>pageCount) {
			endPage = pageCount;
		}
		
		//pageDTO에 저장
		pageDTO.setCount(pageCount);
		pageDTO.setPageBlock(pageBlock);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		pageDTO.setPageCount(pageCount);
		
		
		//List<BoardDTO> = programService getBoardList(pageDTO) 호출
		List<BoardDTO> boardList = programService.getBoardList(pageDTO);
		
		//MODEL 에 저장
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageDTO", pageDTO);
		
		// WEB-INF/views/program/program.jsp 주소변경없이 이동 
		return "/program/program";
	}
	
	//가상주소 http://localhost:8080/TourWeb/program/write
	// WEB-INF/views/program/write.jsp 주소변경없이 이동 
	@GetMapping("/write")
	public String write() {
		// WEB-INF/views/program/write.jsp 주소변경없이 이동 
		return "/program/write";
	}
	
	//가상주소 http://localhost:8080/TourWeb/program/writePro POST방식
	// /program/program 주소 변경 이동
	@PostMapping("/writePro")
	public String writePro(HttpServletRequest request, MultipartFile file) throws Exception {
		System.out.println("ProgramController writePro()");
		// MultipartFile file 
		// => file 변수명이 write.jsp <input type="file" name="file"> 동일하게 변수명 지정
//		파일이름 : file.getOriginalFilename()
//		원본파일 : file.getBytes()
		
		// 파일업로드
		// 파일이름이 중복되지 않게 하기위해서 => 랜덤문자_파일이름
		UUID uuid = UUID.randomUUID();
		String filename = uuid.toString()+"_"+file.getOriginalFilename();
		System.out.println("업로드 경로 : " + uploadPath);
		System.out.println("랜덤문자_파일이름 : " + filename);
		
		// 파일 복사 => 원하는 폴더, 파일이름 붙여넣기 => 복제
//		FileCopyUtils.copy(원본파일, 복제할파일);
//		new File(파일위치경로,filename)
		FileCopyUtils.copy(file.getBytes(), new File(uploadPath,filename));
		
		// BoardDTO 객체생성
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setName(request.getParameter("name"));
		boardDTO.setSubject(request.getParameter("subject"));
		boardDTO.setContent(request.getParameter("content"));
		
		String s1 = request.getParameter("startDate");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = format.parse(s1);
		boardDTO.setStartDate(d1);
		
		String s2 = request.getParameter("endDate");
		Date d2 = format.parse(s2);
		boardDTO.setEndDate(d2);
		
		boardDTO.setFile(filename);
		
		// ProgramService객체생성  insertBoard() 메서드 호출
		programService.insertBoard(boardDTO);
		
		// /program/program 주소 변경 이동
		return "redirect:/program/program";
	}
	

}
