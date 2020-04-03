package Project01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;

public class ServerThread implements Runnable {
	Socket socket;
	DataInputStream dis;
	String message;
	String user_id;
	String finalMsg;
	Hashtable<String, String> ht;
	Hashtable<String, DataOutputStream> stout;
	SimpleDateFormat sdf;
	
	public ServerThread(Socket socket, Hashtable ht, Hashtable stout) {
		sdf = new SimpleDateFormat("[hh:mm:ss]");
		this.socket = socket;
		this.ht = ht;
		this.stout=stout;
		try {
			dis = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			user_id = dis.readUTF();
			
			while (true) {
				System.out.println(sdf.format(new Date()) + " [IP: " + socket.getInetAddress().getHostAddress() + "] -> 데이터 처리 요청 기다리는 중입니다.");
				stout.put(user_id, new DataOutputStream(socket.getOutputStream()));
				finalMsg = dis.readUTF();
				synchronized (ht) {
					ht.put(user_id, user_id + ": " + finalMsg);
				}
				System.out.println("데이터받음 -> " + ht);
				broadcast();
			}
		}catch(Exception e){ e.printStackTrace(); }
	}
	
	public void broadcast() {
		String returnMsg = "\n";
		synchronized (ht) {
			for(String str : ht.values()){
				returnMsg += str + "\n";
			}
			System.out.print("[수정된 데이터]" + returnMsg);
			
			DataOutputStream dos;
			try {
				dos = new DataOutputStream(socket.getOutputStream());
				dos.writeUTF(returnMsg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}