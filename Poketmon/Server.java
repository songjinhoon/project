
package Project01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.xml.crypto.Data;

public class Server {
	ServerSocket serverSocket;
	List<ServerThread> user = new ArrayList<>(); 
	List<String> fuck = new Vector<>();
	Hashtable<String, String> ht = new Hashtable<>();
	Hashtable<String, DataOutputStream> stout = new Hashtable<>();
	
	public static void main(String[] args) {
		Server server = new Server();
		server.startServer();
	}

	void startServer() {
		try {
			serverSocket = new ServerSocket(5000);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("-Server Start-");
		
		while(true){
			try{
				System.out.println(getTime() + ": Client 연결을 기다리는 중입니다.");
				Socket socket = serverSocket.accept();
				System.out.println(getTime() + ": 연결완료 ->" + socket.getInetAddress().getHostAddress());
				ServerThread serverThread = new ServerThread(socket, ht, stout);
				Thread thread = new Thread(serverThread);
				thread.start();
				
			}catch(Exception e) { e.printStackTrace(); }
		}
	}

	public static String getTime() {
		String threadName = Thread.currentThread().getName();
		SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
		return sdf.format(new Date()) + threadName;
	}

}

//class 