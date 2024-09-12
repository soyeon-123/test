package com.itwillbs.controller;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.itwillbs.domain.BoardDTO;

@Controller
@RequestMapping("/program/*")
public class ProgramController {
	
	// 업로드 파일경로 servlet-context.xml 에서 가져오기
	// <beans:bean id="uploadPath" class="java.lang.String">
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	//가상주소 http://localhost:8080/TourWeb/program/program
	// WEB-INF/views/program/program.jsp 주소변경없이 이동 
	@GetMapping("/program")
	public String program() {
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
		
		// BoardService객체생성  insertBoard() 메서드 호출
		
		// /program/program 주소 변경 이동
		return "redirect:/program/program";
	}
	

}
