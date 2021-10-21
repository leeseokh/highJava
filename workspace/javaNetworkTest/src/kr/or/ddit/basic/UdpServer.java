package kr.or.ddit.basic;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UdpServer {
	private DatagramSocket socket;

	// 1. 프로그램 시작

	public void start() throws IOException {

		// 2. 포트 8888번을 사용하는 소켓 생성
		socket = new DatagramSocket(8888);

		// 3. 패킷 송수신을 위한 객체 변수 선언
		DatagramPacket inPacket, outPacket;

		byte[] inMsg = new byte[1]; // 4. 패킷 수신을 위한 바이트 배열 선언
		byte[] outMsg;			    // 5. 패킷 송신을 위한 바이트 배열 선언

		while (true) {
			// 6. 데이터를 수신하기 위한 패킷을 생성   데이터가 전달될 때 까지 블락 상태
			inPacket = new DatagramPacket(inMsg, inMsg.length);

			System.out.println("패킷 수신 대기중...");

			// 7. 패킷을 통해 데이터를 수신 (Receive) 한다.
			socket.receive(inPacket);

			System.out.println("패킷 수신 완료.");

			// 8. 수신한 패킷으로부터 client의 IP 주소와 port 번호를 얻는다.
			InetAddress address = inPacket.getAddress();
			int port = inPacket.getPort();

			// 9.서버의 현재 시간을 시분초 형태로 반환한다.
			SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
			String time = sdf.format(new Date());
			outMsg = time.getBytes(); // 10. 시간 문자열을 byte배열로 변환
			
			//11.패킷을 생성해서 client에게 전송(send)한다.
			outPacket = new DatagramPacket(outMsg, outMsg.length, address, port);
			socket.send(outPacket); //12. 전송시작
			}
		}
		public static void main(String[] args) throws IOException {
			new UdpServer().start();
		}
}


























