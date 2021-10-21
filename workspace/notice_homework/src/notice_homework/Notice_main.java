package notice_homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import notice_homework.JDBCUtil;

/*
   회원정보를 관리하는 프로그램을 작성하는데 
   아래의 메뉴를 모두 구현하시오. (CRUD기능 구현하기)
   (DB의 MYMEMBER테이블을 이용하여 작업한다.)
   
   * 자료 삭제는 회원ID를 입력 받아서 삭제한다.
   기능 구현하기 ==> 1. 전체 목록 출력, 2. 새글작성, 3. 수정, 4. 삭제, 5. 검색 
*/
public class Notice_main {

   private Connection conn;
   private Statement stmt;
   private PreparedStatement pstmt;
   private ResultSet rs;

   private Scanner scan = new Scanner(System.in);

   /**
    * 메뉴를 출력하는 메서드
    */
   public void noticeMenu() {
      System.out.println();
      System.out.println("----------------------");
      System.out.println("  === 작 업 선 택 ===");
      System.out.println("  1. 전체 목록 출력");
      System.out.println("  2. 새글 작성");
      System.out.println("  3. 수정");
      System.out.println("  4. 삭제");
      System.out.println("  5. 검색");
      System.out.println("  6. 종료");
      System.out.println("----------------------");
      System.out.print("작업 선택 >> ");
   }
   // 시작 메서드

   public void start() {
      int select;
      do {
         noticeMenu();
         select = scan.nextInt();
         switch (select) {
         case 1:
            disaplayAll();
            break;
         case 2:
            write();
            break;
         case 3:
            update();
            break;
         case 4:
            delete();
            break;

         case 5:
            search();
            break;
            
         case 6: 
            System.out.println("작업이 끝났습니다");
            
            break;
            default :
               System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
         }

      } while (select != 6);

   }

   private void disaplayAll() {
      System.out.println();
      System.out.println("-----------------------------------");
      System.out.println("글 순서\t제목\t작성자\t날짜\t내용");
      System.out.println("-----------------------------------");

      try {
         conn = JDBCUtil.getConnection();

         String sql = " select * from jdbc_board ";
         stmt = conn.createStatement();
         rs = stmt.executeQuery(sql);

         while (rs.next()) {
            String boardNo = rs.getString("board_no");
            String boardTitle = rs.getString("board_title");
            String boardWriter = rs.getString("board_writer");
            String boardDate = rs.getString("board_date");
            String boardContent = rs.getString("board_content");

            System.out.println(
                  boardNo + "\t" + boardTitle + "\t" + boardWriter + "\t" + boardDate + "\t" + boardContent);

         }
         System.out.println("출력 완료");
      } catch (SQLException e) {
         System.out.println("회원자료 가져오기 실패");
         e.printStackTrace();
      } finally {
         JDBCUtil.disConnect(conn, stmt, pstmt, rs);
      }
   }

   private void write() {
      boolean chk = false;
      String boardNo = "";

      do {
         System.out.println();
         System.out.println("게시글을 작성해주세요.");
         System.out.println("글 번호");
         boardNo = scan.next();

         chk = checkNoticeNo(boardNo);

         if (chk == true) {
            System.out.println("글 번호가" + boardNo + "인 글은 존재합니다.");
            System.out.println("다시 입력하세요.");
         }
      } while (chk == true);

      System.out.print("게시글 제목 >> ");
      String boardTitle = scan.next();

      System.out.print("글쓴이 >> ");
      String boardWriter = scan.next();

      scan.nextLine(); // 입력 버퍼 지우기

      System.out.print("내용 >> ");
      String boardContent = scan.nextLine();

      try {
         conn = JDBCUtil.getConnection();

         String sql = " insert into jdbc_board " + " (board_no,board_title,board_writer,board_date,board_content) "
               + " values (?, ?, ?, SYSDATE, ?) ";

         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, boardNo);
         pstmt.setString(2, boardTitle);
         pstmt.setString(3, boardWriter);
         pstmt.setString(4, boardContent);

         int cnt = pstmt.executeUpdate();

         if (cnt > 0) {
            System.out.println(boardNo + "회원 추가 작업 성공!");
         } else {
            System.out.println(boardNo + "회원 추가 작업 실패!!!");
         }

      } catch (SQLException ex) {
         ex.printStackTrace();
      }
   }

   private void update() {

      boolean chk = false;

      String boardNo = "";
      do {
         System.out.println();
         System.out.println("수정할 게시글넘버를 입력해주세요.");
         System.out.print("게시글 번호 >> ");
         boardNo = scan.next();
         chk = checkNoticeNo(boardNo);

         if (chk == false) {
            System.out.println("이" + boardNo + "번호는 없는 번호 입니다.");
            System.out.println("다시 입력하세요.");
         }
      } while (chk == false);

      System.out.println("글 제목 >> ");
      String boardTitle = scan.next();

      System.out.println("글쓴이>> ");
      String boardWriter = scan.next();

      scan.nextLine();

      System.out.println("내용 >> ");
      String boardContent = scan.nextLine();

      try {
         conn = JDBCUtil.getConnection();

         String sql = " update jdbc_board " + " set board_title = ? " + " ,board_writer = ? " + " ,board_content =? "
               + " where board_no = ? ";

         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, boardTitle);
         pstmt.setString(2, boardWriter);
         pstmt.setString(3, boardContent);
         pstmt.setString(4, boardNo);

         int cnt = pstmt.executeUpdate();

         if (cnt > 0) {
            System.out.println(boardNo + "회원의 정보를 수정");
         } else {
            System.out.println("boardNo +회원 정보 수정 실패.");
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBCUtil.disConnect(conn, stmt, pstmt, rs);
      }

   }

   private void delete() {

      System.out.println("삭제할 게시글을 입력하세요.");
      System.out.println("게시글 넘버 >> ");
      String boardNo = scan.nextLine();

      try {
         conn = JDBCUtil.getConnection();

         String sql = "delete from jdbc_board where board_no = ? ";

         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, boardNo);

         int cnt = pstmt.executeUpdate();

         if (cnt > 0) {
            System.out.println(boardNo + "게시글 삭제 성공");
         } else {
            System.out.println(boardNo + "게시글 삭제 실패");
         }

      } catch (SQLException ex) {
         ex.printStackTrace();
      } finally {
         JDBCUtil.disConnect(conn, stmt, pstmt, rs);
      }

   }

   private void search() {
	   System.out.println("검색할 게시글 번호를 입력하세요");
	      System.out.print("번호 >> ");
	      
	      String board_no1 = scan.next();
	      
	   
	       System.out.println("---------------------------------------------------------------");
	      
	      try {
	         conn = JDBCUtil.getConnection();
	         
	         String sql = "select * from jdbc_board where board_no = ? ";
	         
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, board_no1);
	         
	         rs = pstmt.executeQuery();
	          
	          while(rs.next()) {
	             String board_no = rs.getString("board_no");
	             String board_title = rs.getString("board_title");
	             String board_writer = rs.getString("board_writer");
	             String board_date = rs.getString("board_date");
	             String board_content = rs.getString("board_content");
	              
	             System.out.println("번호 : " + board_no + "\n" +  "제목 : "+ board_title+ "\n" + "작성자 : " + board_writer + "\n" + "날짜 : " +board_date +   "\n" + "내용 : "+ board_content);
	             
	          }
	          System.out.println("---------------------------------------------------------------");
	          System.out.println("출력 끝.");
	         
	         
	      }catch (SQLException e) {
	         System.out.println("게시글 가져오기 실패!");
	         System.out.println();
	      }finally {
	         JDBCUtil.disConnect(conn, stmt, pstmt, rs);
	      }
	      

   }

   private boolean checkNoticeNo(String boardNo) {
      boolean check = false;

      try {
         conn = JDBCUtil.getConnection();

         String sql = " select count(*) cnt from jdbc_board " + " where board_no = ? ";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, boardNo); // 첫번째 물음표 위치

         rs = pstmt.executeQuery();

         int count = 0;

         if (rs.next()) {
            count = rs.getInt("cnt");
         }

         if (count > 0) {
            check = true;
         }
      } catch (SQLException ex) {
         ex.printStackTrace();
         check = false;
      } finally {
         JDBCUtil.disConnect(conn, stmt, pstmt, rs);
      }

      return check;
   }

   public static void main(String[] args) {
      Notice_main notice = new Notice_main();
      notice.start();
   }

}