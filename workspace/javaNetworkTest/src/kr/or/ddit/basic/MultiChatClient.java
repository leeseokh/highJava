package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MultiChatClient {
	Scanner scan = new Scanner(System.in);

	private String nickName; // 대화명

	// 시작 메서드
	public void clientStart() {

		// 대화명 입력받기
		System.out.println("대화명 : ");
		nickName = scan.next();

		Socket socket = null;

		try {
			String serverIp = "192.168.42.149";
			socket = new Socket(serverIp, 7777);

			System.out.println("서버에 연결 되었습니다.");

			// 송신용 스레드 생성
			ClientSender sender = new ClientSender(socket, nickName);
			

			// 수신용 스레드 생성
			ClientReceiver receiver = new ClientReceiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// 메시지를 전송하는 Thread
	class ClientSender extends Thread {
		private DataOutputStream dos;
		private String name;
		private Scanner scan = new Scanner(System.in);

		public ClientSender(Socket socket, String name) {
			this.name = name;

			try {
				dos = new DataOutputStream(socket.getOutputStream());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		@Override

		public void run() {
			try {
				// 4. 시작하자마자 자신의 대화명을 서버로 전송
				if (dos != null) {
					dos.writeUTF(name);
				}

				while (dos != null) {
					// 5. 키보드로 입력받은 메시지를 서버로 전송
					dos.writeUTF(scan.nextLine());
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	// 수신용 Thread 클래스 정의
	class ClientReceiver extends Thread {
		private DataInputStream dis;

		// 생성자
		public ClientReceiver(Socket socket) {

			try {
				dis = new DataInputStream(socket.getInputStream());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		@Override
		public void run() {
			while (dis != null) {
				try {
					// 7. 서버로부터 수신한 메시지 출력하기
					System.out.println(dis.readUTF());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}// 내부클래스

	public static void main(String[] args) {
		new MultiChatClient().clientStart();
	}
} // MultiChatClient class
