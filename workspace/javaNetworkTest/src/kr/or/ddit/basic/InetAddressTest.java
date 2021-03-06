package kr.or.ddit.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException {
		// InetAddress클래스 - > IP 주소를 다루기 위한 클래스

		// getByName()메서드는 www.naver.com 또는 SEM-PC등과
		// 같은 머신 이름이나 IP주소를 파라미터를 이용하여 유효한 InetAddress 객체를 제공한다.
		// (IP주소 자체를 넣으면 주소 구성 자체의 유효성 정도만 체크함.)

		// naver 사이트의 ip정보 가져오기

		InetAddress naverIp = InetAddress.getByName("www.naver.com");
		// new 없이 static메서드를 이용한 객체 생성 방식

		// 2. Host Name과 Host Address 가져오기
		// Host Name: 머신이름, 도메인명, 또는 ip주소 문자열
		System.out.println("네이버의 Host Name => " + naverIp.getHostName()); // 도메인 없으면 address 나옴
		System.out.println("네이버의 Host Address => " + naverIp.getHostAddress());

		// 1.자기 자신 컴퓨터의 IP주소 가져오기
		InetAddress localIp = InetAddress.getLocalHost();
		// 2. Host Name과 Host Address 가져오기
		System.out.println("내 컴퓨터의 Host Name => " + localIp.getHostName());
		System.out.println("내 컴퓨터의 Host Address => " + localIp.getHostAddress());

		System.out.println();

		// ip주소가 여러개인 호스트의 정보 가져오기
		InetAddress[] naverIps = InetAddress.getAllByName("www.naver.com");
		for (InetAddress nIp : naverIps) {
			System.out.println(nIp.toString());
		}
	}

}
