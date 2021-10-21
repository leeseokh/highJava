package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		String serverIp = "127.0.0.1"; // loopback주소
		// 자기 자신의 컴퓨터를 나타내는 방법
		// IP : 127.0.0.1
		// 컴이름 : localhost

		System.out.println(serverIp + " 서버에 접속 중입니다.");

		// 1. 소켓을 생성하여 서버에 연결을 요청한다.
		Socket socket = new Socket(serverIp, 7777);

		// 2. 연결이 정상적으로 이루어지면 생성된 소켓 객체를 이용하여 서버와 메시지를 주고받음
		//   생성된 소켓으로부터 스트림(InputStream, OutputStream)객체를 가져와 이용
		System.out.println("연결되었습니다.");

		// 서버에서 보내온 메시지 받기
		// 메시지를 받기 위해 InputStream객체를 생성
		// Socket의 getInputStream()메서드 이용
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		// 서버로부터 받은 메시지 출력하기
		System.out.println(dis.readUTF());

		System.out.println("연결종료");

		// 3. 사용이 완료된 소켓은 close() 메서드를 이용하여 종료처리한다.
		dis.close(); // 스트림닫기
		socket.close();
	}
}