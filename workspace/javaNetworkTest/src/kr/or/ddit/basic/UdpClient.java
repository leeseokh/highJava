package kr.or.ddit.basic;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {

	
	//시작
	 // 1. 시작 메서드
	  public void start() throws IOException {
	    DatagramSocket socket = new DatagramSocket();
	    InetAddress serverAddress = InetAddress.getByName("192.168.42.149");

	    // 2. 데이터가 저장될 공간으로 byte배열을 생성한다 (패킷수신용)
	    byte[] msg = new byte[100];

	    DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddress, 8888); // 100바이트짜리 배열에서 1바이트만 전송
	    DatagramPacket inPakcet = new DatagramPacket(msg, msg.length); // 100바이트 넘어가는 데이터는 잘림

	    socket.send(outPacket); // 전송
	    socket.receive(inPakcet); // 서버가 데이터 보내기 전까지는 block, 그 후 패킷 수신

	    System.out.println("현재 서버시간 => " + new String(inPakcet.getData()));
	    // byte[]에 해당하는 문자열을 만들어주는 String 생성자 이용

	    socket.close(); // 소켓 종료
	  } // start()
	  public static void main(String[] args) throws IOException {
		new UdpClient().start();
	}
 
}

