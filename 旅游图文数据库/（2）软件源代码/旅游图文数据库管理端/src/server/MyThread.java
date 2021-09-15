package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class MyThread extends Thread {
	
	int jud=0;
	String abc;
	
	@Override
	public void run() {
		super.run();
		
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(9669);
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
        System.out.println("接收端接收到的数据："+ new String(buf,0,datagramPacket.getLength())); 
        String str= new String (buf);
        String [] arr = str.split("><");
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        if(arr[0].equals("a")) {

        	//数据库
			try {  
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Success loading Mysql Driver!");  
			}
			catch (Exception e) {  
				System.out.print("Error loading Mysql Driver!");  
				e.printStackTrace();  
			}  
			try{  
				Connection connect = DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/1400330129薛天杭UML","root","616709");  
				System.out.println("Success connect Mysql server!");
				Statement stmt = connect.createStatement();  
				ResultSet rs = stmt.executeQuery("select * from user");
				String a = arr[1];
				String b = arr[2];
				
				while (rs.next()) {                           //1正确,2密码错误，3用户名不存在
					
					if(rs.getString("username").equals(a)) {
						if(rs.getString("password").equals(b)) {
							jud=1;
							break;
						}
						else {
							jud=2;
						break;
						}
					}
					else
						jud=3;
				}
				rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			System.out.println(jud);
			abc="a";
			try {
				tongxin();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
        else if(arr[0].equals("b")) {
        	//数据库
			try {  
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Success loading Mysql Driver!");  
			}
			catch (Exception e) {  
				System.out.print("Error loading Mysql Driver!");  
				e.printStackTrace();  
			}  
			try{  
				Connection connect = DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/1400330129薛天杭UML","root","616709");  
				System.out.println("Success connect Mysql server!");
				Statement stmt1 = connect.createStatement();  
				ResultSet rs1 = stmt1.executeQuery("select * from user");
				
				while (rs1.next()) {                           //2用户名已存在
					if(rs1.getString("username").equals(arr[1])) {
							jud=2;
							break;
					}
					else {
					jud = 3;
					}
				}
				if(jud==3) {
				String sql = "INSERT INTO user(username,password) VALUES('"+arr[1]+"','"+arr[2]+"')";  
				System.out.println(arr[2]);
                int result = stmt1.executeUpdate(sql);  
                if(result!=-1) {
                	jud=1;                              //1注册成功
                }
                }
		} catch (Exception e) {
			e.printStackTrace();
		}
			System.out.println(jud);
			abc ="b";
			try {
				tongxin();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
	}
	
	public void tongxin()throws Exception {
        DatagramSocket ds = new DatagramSocket();
        String localIp = InetAddress.getLocalHost().getHostAddress();
        String str=abc+"><"+jud;
        System.out.println(str);
        byte[] buf = str.getBytes();
        DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName(localIp), 9339);
        ds.send(dp);
    }
	
}