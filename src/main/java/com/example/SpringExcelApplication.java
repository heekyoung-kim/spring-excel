package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.entity.Book;
import com.example.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootApplication
public class SpringExcelApplication {
	
	private final BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringExcelApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return (args) -> {
			bookRepository.save(new Book("불편한 편의점", "김호연", "남우폎의자", "", 15000));
			bookRepository.save(new Book("물고기는 존재하지 않는다.", "룰러 밀러", "곰출판", "", 16500));
			bookRepository.save(new Book("세븐 테크", "김기명,김상균", "지식하우스", "", 18000));
			bookRepository.save(new Book("웰 씽킹 WEALTHINKINGS", "켈리 최", "다산북스", "", 16000));
			bookRepository.save(new Book("잘 살아라 그게 최고의 복수다.", "권민창", "마인드셋", "", 15000));
			bookRepository.save(new Book("달러구트 꿈 백화점 합본호", "이미예", "패토리나인", "", 23000));
			bookRepository.save(new Book("돈의 심리학", "모건 하우징", "인플루엔셜", "", 19500));
			bookRepository.save(new Book("부자 아빠 가난한 아빠", "로버트 기요사키", "민음인", "", 16000));
			bookRepository.save(new Book("진짜 쓰는 실무 엑셀", "전진권", "제이펍", "", 21000));
			bookRepository.save(new Book("미드나잇 라이브러리", "매트 헤이그", "인플루엔셜", "", 15000));
			bookRepository.save(new Book("이상한 과자 가게 전천당", "히로시마 레이코", "길벗스쿨", "", 11500));
			bookRepository.save(new Book("서울 수도권 아파트 지금 사야 합니다.", "함태식", "황금부엉이", "", 19500));
			bookRepository.save(new Book("ETS 토익 정기시험 기출문제집 1000 READING", "ETS", "YBM", "", 18000));
			bookRepository.save(new Book("럭키 드로우", "드로우 앤드류", "다산북스", "", 16000));
			bookRepository.save(new Book("ETS 토익 정기시험 기출문제집 1000 LISTENING", "ETS", "YBM", "", 18000));
			bookRepository.save(new Book("해커스 토익 기출 보카", "데이비드 조", "해커스어학연구소", "", 12000));
			bookRepository.save(new Book("오늘 밤, 세계에서 이 사랑이 사라진다 해도", "이치조 미사키", "모모", "", 14000));
			bookRepository.save(new Book("고양이 해결사 깜냥 4", "홍민정", "창비", "", 10000));
			bookRepository.save(new Book("돈의 속성", "김승호", "스노우폭스북스", "", 18000));
			bookRepository.save(new Book("오은영의 화해", "오은영", "코리아닷컴", "", 16000));
			bookRepository.save(new Book("나태주, 시간의 쉼표", "나태주", "서울문화사", "", 17000));
			bookRepository.save(new Book("잘했고 잘하고 있고 잘 될 것이다", "정영욱", "부크럼", "", 15000));
			bookRepository.save(new Book("종목 선정 나에게 물어봐", "김정수", "하음출판사", "", 26000));
		};
	}

}
