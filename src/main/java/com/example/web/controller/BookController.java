package com.example.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Book;
import com.example.service.BookService;
import com.example.web.view.FileDownloadView;
import com.example.web.view.excel.BestsellerExcelView;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private FileDownloadView fileDownloadView;

	@Autowired
	private BestsellerExcelView bestsellerExcelView;
	
	
	
	// 1.요청핸들러 메소드가 어떤 View를 사용할지 지정ㅎ지 않았다.
	// 2.DispatcherServlet은 기본 ViewResolver로 지정된 interResourceViewResolver를 실행시켜서 사용할 View객체를 제공받는다.
	// 3.InternalResourceViewResolver는 JstlView객체를 DispatcherServlet에게 제공한다.
	// 4.JstlView는 요청을 /WEN-INF/views/book/list.jsp로 내부이동 시킨다. list.jsp가 실행되면 HTML컨텐츠가 응답으로 제공된다.
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("books", bookService.getAllBooks());
		return "book/list";
	}
	
	// 1. 요청핸들러 메소드가 ModelAndView객체에 fileDownloadView를 사용하도록 지정했다.
	// 2. 요청핸들러 메소드가 ModelAndView객체에 엑섹파일 생성에 필요한 데이터를 저장했다.	
	// 3.DispatcherServlet은 ModelAndView에 포함된 FilewDownloadView를 사요한다.
	// 4.FileDownloadView는 디렉토리명, 파이명 혹은 클래스패스 경로에 해당하느 ㄴ파일을 읽어서 응답으로 제공한ㄷ.
	// 위의 2,3과정이 생략될 수 있음.
	@GetMapping("/books")
	public ModelAndView booksListFile() {
		ModelAndView mav = new ModelAndView();
		// ModelAndView객체에 View객체 저장
		mav.setView(fileDownloadView);
		// ModelAndView객체 Model정보 저장
		mav.addObject("classpath","classpath:excel/도서목록.xlsx"); // 파일다운로드해달라는 코드
		
		// mav.addObject("directory","전체디렉토리 경로"); // 파일다운로드해달라는 코드
		// mav.addObject("fileName","파일명"); // 파일다운로드해달라는 코드
		//
		
		
		return mav;
	}
	
	// 1. 요청핸들러 메소드가 ModelAndView객체에 BestsellerExcelView를 사용하도록 지정했다.
	// 2. 요청핸들러 메소드가 ModelAndView객체에 엑섹파일 생성에 필요한 데이터를 저장했다.
	// DispatcherServlet은 ModelAndView에 포함된 FilewDownloadView를 사요한다.
	// FileDownloadView는 디렉토리명, 파이명 혹은 클래스패스 경로에 해당하느 ㄴ파일을 읽어서 응답으로 제공한ㄷ.
	@GetMapping("/bestseller")
	public ModelAndView bestsellerFile() {
		ModelAndView mav = new ModelAndView();
		
		mav.setView(bestsellerExcelView);
		
		// ModelAndView 객체에 베스트셀러 도서 목록 엑셀파일 생성에 필요한 데이터 구성해서 저장하기.
		Map<String, Object> excelData = new HashMap<String, Object>();
		String[] titles = {"번호","제목","저자","출판사","가격", "할인가격","설명"};
		List<Book> bestsellerBooks = bookService.getAllBooks(); 
		
		excelData.put("titles", titles);
		excelData.put("books", bestsellerBooks);
		
		/*
		 * mav.addObject(excelData);
		 * 	  ModelAndView의 model에 model.put("excelData", excelData) 된다.
		 * mav.addObjet("excelData",excelData);
		 * 	  ModelAndView의 model에 model.put("excelData", excelData) 된다
		 * 
		 * mav.addAllObject(excelData);
		 * 	  ModelAndView의 model이 excelData로 대체된다
		 */
		mav.addAllObjects(excelData);
		
		return mav;
	}
	
	
}
