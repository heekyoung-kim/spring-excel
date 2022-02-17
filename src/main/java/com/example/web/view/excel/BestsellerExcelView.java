package com.example.web.view.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.example.entity.Book;

@Component
public class BestsellerExcelView extends AbstractXlsxView {
	
	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 엑셀파일 생성에 필요한 데이터 가져오기
		String[] titles = (String[])model.get("titles");
		List<Book> books = (List<Book>) model.get("books");
		
		// 워크시트 생성
		Sheet  sheet = workbook.createSheet("베스트 셀러 목록");
		
		// 제목행 생성
		Row titleRow = sheet.createRow(0);
		for(int cellIndex = 0; cellIndex < titles.length; cellIndex++) {
			titleRow.createCell(cellIndex).setCellValue(titles[cellIndex]);
		}
		
		// 데이터행 생성
		// 행하나 만들고 값넣고를 반복.
		int rowIndex = 1;
		for (Book book : books) {
			Row dataRow = sheet.createRow(rowIndex);
			dataRow.createCell(0).setCellValue(book.getId());	
			dataRow.createCell(1).setCellValue(book.getTitle());	
			dataRow.createCell(2).setCellValue(book.getAuthor());	
			dataRow.createCell(3).setCellValue(book.getPublisher());	
			dataRow.createCell(4).setCellValue(book.getPrice());	
			dataRow.createCell(5).setCellValue(book.getDiscountPrice());	
			dataRow.createCell(6).setCellValue(book.getDescription());	
			rowIndex++;
		}
	}
}
