package kr.or.ddit.basic;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public static void main(String[] args) throws IOException {
		// 1. TCP 소켓통신을 하기 위해 ServerSocket 객체를 생성
		// 서버소켓을 가지고 클라이언트의 소켓 접속을 기다릴 것임
		ServerSocket server = new ServerSocket(7777); // ~1023은 WellKnown이라 사용불가
		System.out.println("서버가 접속을 기다립니다...");

		// 2. ServerSocket객체의 accept()메서드를 호출,
//		    Client로부터 연결요청이 올 때까지 계속 기다린다. (=main스레드 블락(wait))
		// 3. 연결요청이 들어오면 새로운 Socket객체를 생성하여 Client의 Socket과 연결한다
		Socket socket = server.accept();
		// ----------------------------
		// 이 이후는 클라이언트와 연결된 후의 작업을 진행하면 된다.

		System.out.println("접속한 클라이언트 정보");
		System.out.println("주소 : " + socket.getInetAddress()); // toString() 오버라이드

		// 4. Socket객체의 Stream객체(InputStream, OutputStream)를 이용하여 메시지를 주고 받는다.
//		    OutputStream객체를 구성하여 전송
//		    접속한 Socket의 getOutputStream()메서드를 이용하여 구한다.
		OutputStream out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		// ▶ OutputStreamReader를 쓸 수 도 있음
		dos.writeUTF("어서오세요!!"); // 메시지 보내기
		System.out.println("메세지를 보냈습니다.");

		// 5. 사용이 완료된 소켓은 close()메서드를 이용하여 종료 처리한다.
		dos.close();
		server.close(); // 소켓도 스트림처럼 사용 후에 닫아줘야 한다.
	}
}
