package com.example.utils;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.util.ResourceUtils;

/**
 * 파일관련 헬프기능을 지원하는 클래스다.
 * @author i
 *
 */
public class FileUtils {

	/**
	 * 지정된 클래스패스에서 파일을 찾아서 반환한다.
	 * @param classpath 클래스 패스 -> 패키지경로, 포함하고있는 maven자료파일경로
	 * @return 파일객체 
	 * @throws FileNotFoundException 지정된 클래스패스에 파일이 존재하지 않으면 예외가 발생한다.
	 */
	public static File loadFile(String classpath) throws FileNotFoundException {
		return ResourceUtils.getFile(classpath);
	}
}
