package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpFileReceiver {
   public static void main(String[] args) throws IOException {
      int port = 8888;
      
      long filesize = 0;
      long  totalReadBytes = 0;
      
      byte[] buffer = new byte[1000];
      int readBytes = 0;
      
      System.out.println("파일 수신 대기중...");
      DatagramSocket socket = new DatagramSocket(port);
      
      FileOutputStream fos = new FileOutputStream("d:/app/aaa.png");
      
      DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
      
      socket.receive(dp);
      String str = new String(dp.getData()).trim();
      
      if(str.equals("start")) {   //sender에서 전송을 시작한 경우...
         dp = new DatagramPacket(buffer, buffer.length);   // 수신용
         socket.receive(dp);
         str = new String(dp.getData()).trim();
         filesize = Long.parseLong(str);
         
         double startTime = System.currentTimeMillis();
         
         while(true) {
               socket.receive(dp);
//               str = new String(dp.getData()).trim();
               readBytes = dp.getLength();
               fos.write(dp.getData(), 0, readBytes);
               totalReadBytes += readBytes;
               
               System.out.println("진행상태 : " + totalReadBytes 
                     + "/" + filesize + " Byte ( " 
                     + (totalReadBytes * 100 / filesize) 
                     + "%)");
               
               if(totalReadBytes >= filesize) {
                  break;
            }

         }
         double endTime = System.currentTimeMillis();
         double diffTime = (endTime - startTime) / 1000;
         double transferSpeed = (filesize / 1000) / diffTime;
         
         System.err.println("걸린 시간 : " + diffTime + "(초)");
         System.out.println("평균전송속도 : " + transferSpeed + "KB/s");
         
         System.out.println("전송완료 .....");
         
         fos.close();
         socket.close();
      }else{
         System.out.println("비정상데이터발견");
         fos.close();
         socket.close();
      }
         
      
   }
}


