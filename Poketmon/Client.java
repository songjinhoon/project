package Project01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class Client {
	Socket socket;
	String serverIP = "211.63.89.78";
	String user_id;
	String data;
	int count = 1;
	String msg;

	public void startClient(String user_id) {
		this.user_id = user_id;
		try {
			socket = new Socket(serverIP, 5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void send(String data) {
		OutputStream os;
		try {
			os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			if (count == 1) {
				dos.writeUTF(user_id);
				count++;
			}
			dos.writeUTF(data);
			receive();
			dos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void receive(){
		try {
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			msg = dis.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}