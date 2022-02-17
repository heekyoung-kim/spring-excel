package com.example.web.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.example.utils.FileUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FileDownloadView extends AbstractView {
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// Model객체에는 classpath가 있거나, directory, filename이 있다.
		String classpath = (String)model.get("classpath");
		String directory = (String)model.get("directory");
		String filename = (String)model.get("filename");
		
		log.info("클래스 패스: "+ classpath);
		log.info("디렉토리 경로: "+directory);
		log.info("파일명: "+filename);
		
		File file = null;
		if(classpath != null) {
			file = FileUtils.loadFile(classpath);
		}else {
			file = new File(directory, filename);
		}

		// 바이너리 파일을 내려보내기 위한 응답헤더 설정하기 / mime타입(알려지지않은 모든 파일의 타임= octect-stream)
		// attachment를 빼고 보내면 다운로드가 아니라 브라우저 창이 열러버림.
		response.setContentType("application/octet-stream"); 
		response.setHeader("Content-Disposition", "attachment; filename="+ URLEncoder.encode(file.getName(),"UTF-8")); 
		
		// 파일을 읽어오는 스트림 객체 생성
		InputStream in = new FileInputStream(file);
		// 응답객체에서 브라우저로 보내는 스트림객체 획득
		OutputStream out = response.getOutputStream();
		
		// 브라우저로 파일 보내기
		FileCopyUtils.copy(in, out);
		
	}
}
