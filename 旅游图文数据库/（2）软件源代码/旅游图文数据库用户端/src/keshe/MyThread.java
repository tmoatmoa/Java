package keshe;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class MyThread extends Thread {
	@Override
	public void run() {
		super.run();
		
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(9339);
		} catch (SocketException e) {
			e.printStackTrace();
		}
        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length); 
        while(true) {
        try {
			socket.receive(datagramPacket);
		} catch (IOException e) {
			e.printStackTrace();
		} 
        
        System.out.println("���ն˽��յ������ݣ�"+ new String(buf,0,datagramPacket.getLength())); 
        String str= new String (buf);
        String [] arr = str.split("><");
        System.out.println(arr[0]); 
        if(arr[0].equals("a")) {
        	if(arr[1].equals("1")) {
        		xinxi.main(null);
        		denglu.close();
			}
			if(arr[1].equals("2")) {
				JOptionPane.showMessageDialog(null, "�������", "error", JOptionPane.ERROR_MESSAGE);
				 System.out.println("�������"); 
			}
			if(arr[1].equals("3")) {
				JOptionPane.showMessageDialog(null, "�����ڵ��û���", "error", JOptionPane.ERROR_MESSAGE);
				System.out.println("�����ڵ��û���");
			}
	}
        else if(arr[0].equals("b")) {
        
        }
        }
	}
}
