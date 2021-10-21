package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import board.vo.BoardVO;
import dao.Dao;
import service.Service;

public class MainBoard {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Service service;
	private Dao dao;

	private Scanner scan = new Scanner(System.in);

	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 자료 입력");
		System.out.println("  2. 자료 삭제");
		System.out.println("  3. 자료 수정");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  5. 자료 검색");
		System.out.println("  6. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}

	/**
	 * 프로그램 시작메서드
	 */
	public void start() {
		service = new Service();
		dao = new Dao();
		int choice;
		do {
			displayMenu(); // 메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch (choice) {
			case 1: // 자료 입력
				insertVo();
				break;
			case 2: // 자료 삭제
				deleteVo();
				break;
			case 3: // 자료 수정
				updateVo();
				break;
			case 4: // 전체 자료 출력
				displayVoAll();
				break;
			case 5: // 검색
				searchVo();
				break;
			case 6: // 작업 끝
				System.out.println("작업을 마칩니다.");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 6);
	}
	
	private void searchVo() {
		scan.nextLine();
		
		BoardVO vo = new BoardVO();
		List<BoardVO> list = new ArrayList<>();
		System.out.println("검색할 게시글 번호를 입력하세요");
		System.out.print("게시글 번호 >> ");
		String board_no = scan.nextLine();
		System.out.print("작성자 이름 >>");
		String board_writer = scan.nextLine();
		System.out.print("제목 >>");
		String board_title = scan.nextLine();
		System.out.print("내용 >>");
		String board_content = scan.nextLine();
		
		System.out.println();
		System.out.println("---------------------------------------------------------------");
		System.out.println(" 번호\t작성자\t제목\t내용\t시간");
		System.out.println("---------------------------------------------------------------");
		
		
		vo.setBoard_content(board_content);
		vo.setBoard_no(board_no);
		vo.setBoard_title(board_title);
		vo.setBoard_writer(board_writer);
		
		list = service.searchVo(vo);
		for(BoardVO vo2 : list) {
			System.out.println(vo2.getBoard_no() + "\t" + vo2.getBoard_writer() + "\t" + vo2.getBoard_title() + "\t" + vo2.getBoard_content() + "\t" + vo2.getBoard_date());
		}

	}

	//삭제
	private void deleteVo() {
		
		System.out.println();
		System.out.println("삭제할 게시글 번호를 입력하세요");
		System.out.print("board_no >> ");
		
		String board_no = scan.next();
		int cnt = 0;
		cnt = service.deleteVo(board_no);
		
		if(cnt>0) {
			System.out.println(cnt + "개의 게시글 삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
		
	}

	//수정
	private void updateVo() {

		boolean chk = false;
		String board_no = "";

		do {
			System.out.println();
			System.out.println("수정할 board_no를 입력하세요.");
			System.out.print("board_no >> ");
			board_no = scan.next();
			chk = checkVo(board_no);
			
			if (chk == false) {
				System.out.println("board_no가" + board_no + "존재하지 않습니다.");
				System.out.println("다시 입력하세요");
			}

		} while (chk == false);
		
		System.out.print("board_writer >>");
		String board_writer = scan.next();
		
		System.out.print("board_title >>");
		String board_title = scan.next();
		
		scan.nextLine(); // 입력버퍼 키우기
		
		System.out.print("board_content >>");
		String board_content = scan.nextLine();
		
		BoardVO vo = new BoardVO();
		vo.setBoard_content(board_content);
		vo.setBoard_no(board_no);
		vo.setBoard_title(board_title);
		vo.setBoard_writer(board_writer);
		
		int cnt = 0;
		
		cnt = service.updateVo(vo);
		
		if(cnt>0) {
			System.out.println("수정 성공");
		}else {
			System.out.println("수정 실패");
		}
	}

	
	
	//전체 조회
	private void displayVoAll() {
		System.out.println();
		System.out.println("---------------------------------------------------------------");
		System.out.println(" 번호\t작성자\t제목\t내용\t시간");
		System.out.println("---------------------------------------------------------------");
		List<BoardVO> list = new ArrayList<>();
		list = service.displayVoAll();
		for(BoardVO vo2 : list) {
			System.out.println(vo2.getBoard_no() + "\t" + vo2.getBoard_writer() + "\t" + vo2.getBoard_title() + "\t" + vo2.getBoard_content() + "\t" + vo2.getBoard_date());
		}
			 
		System.out.println("---------------------------------------------------------------");
		System.out.println("출력 끝.");

	}
	
	//입력
	private void insertVo() {
		scan.nextLine();
		boolean chk = false;
		String board_no = "";

		board_no = service.nextVo();
		
		System.out.print("작성자 이름 >>");
		String board_writer = scan.nextLine();
		
		System.out.print("제목 >>");
		String board_title = scan.nextLine();
		
		System.out.print("내용 >>");
		String board_content = scan.nextLine();
		
		BoardVO vo = new BoardVO();
		vo.setBoard_content(board_content);
		vo.setBoard_no(board_no);
		vo.setBoard_title(board_title);
		vo.setBoard_writer(board_writer);
		
		int cnt = 0;
		cnt = service.insertVo(vo);
		if(cnt>0) {
			System.out.println("입력 성공");
		}else {
			System.out.println("입력 실패");
		}
		
	}

	
	private boolean checkVo(String board_no) {

		boolean check = false;

		check = service.checkVo(board_no);

		return check;
	}

	public static void main(String[] args) {
		MainBoard memObj = new MainBoard();
		memObj.start();
	}

}
