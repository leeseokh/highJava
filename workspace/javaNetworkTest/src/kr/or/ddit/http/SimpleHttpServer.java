package kr.or.ddit.http;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class SimpleHttpServer {
	
	private final byte[] content;
	private final byte[] header;
	private final int port;
	private final String encoding;
	
	public SimpleHttpServer(String data, String encoding, String mimeType,int port) throws UnsupportedEncodingException {
		this(data.getBytes(encoding), encoding, mimeType, port);
	}
	
	public SimpleHttpServer(byte[] data, String encoding, String mimeType, int port) {
		this.content = data;
		this.port = port;
		this.encoding = encoding;
		String header = "HTTP/1.1 200 OK\r\n" + "Server: SimpleHTTPServer 1.0\r\n"
						+ "Content-length: " + this.content.length + "\r\n"
						+ "Content-type: " + mimeType + "; charset="
						+ encoding + "\r\r\r\n";
		this.header = header.getBytes(Charset.forName("US-ASCII"));
	}
	
	public void start() {
		try(ServerSocket server = new ServerSocket(this.port)) {
			while(true) {
				try {
					Socket socket = server.accept();
					
					// Http요청 처리를 위한 핸들러 생성 및 실행
					HttpHandler handler = new HttpHandler(socket);
					new Thread(handler).start();
					
				}catch(IOException ex) {
					ex.printStackTrace();
				}
			}
			
		}catch(IOException ex) {
			System.out.println("서버 시작 에러발생");
			ex.printStackTrace();
		}
	}
	//Http 요청 처리를 위한 Runnable 클래스	
	private class HttpHandler implements Runnable{
		private final Socket socket;
		
		public HttpHandler(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				OutputStream out =  new BufferedOutputStream(socket.getOutputStream());
				
				   BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				   
				   //여기서는 필요한 첫번째 줄만 읽는다.
				   StringBuilder request = new StringBuilder();
			        while (true) { // while문으로 request header 부분 만드려는 중
			          String str = br.readLine();
			          
			          // 빈줄(Empty Line)이 포함되었으면 중지
			          if(str.equals(""))break;
			          
			          request.append(str + "\n");
			        }
			        System.out.println("요청헤더:\n" + request.toString());
			
			        //HTTP/ 1.0이나 그 이후의 버전을 지원할 경우 MIME 헤더를 전송한다.
			        if(request.toString().indexOf("HTTP/") !=-1) {
			        	out.write(header);
			        }
			        
			        System.out.println("응답헤더:\n" + new String(header));
			        
			        out.write(content);
			        out.flush();
			        
			}catch(IOException ex) {
				ex.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		//대기(Listen)할 포트번호를 설정한다.
		int port = 80;
		String encoding ="UTF-8";
		if(args.length > 2) encoding = args[2];
		
		FileInputStream fis = null;
		
		try {
		      File file = new File(args[0]);
		      byte[] data = new byte[(int) file.length()];
		      fis = new FileInputStream(file);
		      fis.read(data);
		      
		      //해당 파일 이름을 이용하여
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}



















