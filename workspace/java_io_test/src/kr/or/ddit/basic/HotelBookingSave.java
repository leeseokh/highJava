package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelBookingSave {
	Scanner sc = new Scanner(System.in);
	private Map<String, HotelBook> hotelBooking;

	public HotelBookingSave() {
		hotelBooking = new HashMap<>();

	}

	public static void main(String[] args) { // 실행
		new HotelBookingSave().start();
	}

	public void start() { // 시작
		System.out.println("========================");
		System.out.println("호텔문을 열었습니다.");
		System.out.println("========================");
		
		ObjectInputStream ois;

		try {

			// 스트림으로 입력받을 객체 생성
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("d:/D_Other/hotel.bin")));
			Object obj = null;

			obj = ois.readObject(); // 읽은것 객체로 변환
			hotelBooking = (HashMap<String, HotelBook>) obj;

			ois.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("-작업 완료했습니다-");
		}

		while (true) { // 메뉴
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인 2.체크아웃 3.객실상태 4.업무종료");

			int select = sc.nextInt();
			sc.nextLine();
			switch (select) {

			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				roomStatus();
				break;
			case 4:
				try {
					// 객체를 파일에 저장.
					ObjectOutputStream oos = new ObjectOutputStream(
							new BufferedOutputStream(new FileOutputStream("d:/D_Other/hotel.bin")));

					oos.writeObject(hotelBooking); // 직렬화
					System.out.println("작업 완료");
					System.out.println("호텔 문 닫겠습니다.");

					oos.close();

				} catch (Exception e) {
					e.printStackTrace();

				}
				System.exit(0);

			}
		}
	}

	private void checkIn() {
		System.out.println();
		System.out.println("어느방에 체크인 하시겠습니까?");
		String roomNo = sc.nextLine();

		if (hotelBooking.get(roomNo) != null) {
			System.out.println("죄송합니다. 이미 등록된 객실입니다.");
			return;
		}
		System.out.println("누구를 체크인 하시겠습니까?");
		String name = sc.next();

		hotelBooking.put(roomNo, new HotelBook(roomNo, name));
		System.out.println(name + "님 방 등록 완료 되었습니다.");
	}

	private void checkOut() {
		System.out.println();
		System.out.println("체크아웃 하시겠습니까?");
		System.out.println("방번호를 알려주세요");
		String roomNo = sc.nextLine();
		if (hotelBooking.remove(roomNo) == null) {
			System.out.println("빈 객실 입니다.");
		} else {
			System.out.println("체크아웃 완료 되었습니다.");
		}

	}

	private void roomStatus() {
		Set<String> keySet = hotelBooking.keySet();
		System.out.println("====================================");
		System.out.println("번호\t객실번호\t\t투숙객");
		System.out.println("====================================");

		if (keySet.size() == 0) {
			System.out.println("등록된 룸이 없습니다");
		} else {
			Iterator<String> it = keySet.iterator();

			int count = 0;
			while (it.hasNext()) {
				count++;
				String roomNo = it.next();
				HotelBook h = hotelBooking.get(roomNo);
				System.out.println(count + "번" + "\t" + "객실번호 : " + h.getRoomNo() + "\t" + "투숙객 : " + h.getName());

			}
		}
		System.out.println("====================================");

	}
}

class HotelBook implements Serializable {
	private String roomNo;
	private String name;

	public HotelBook(String roomNo, String name) {
		super();
		this.roomNo = roomNo;
		this.name = name;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HotelBook [roomNo=" + roomNo + ", name=" + name + "]";

	}

}