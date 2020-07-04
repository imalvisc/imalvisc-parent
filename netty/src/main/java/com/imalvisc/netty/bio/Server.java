package com.imalvisc.netty.bio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chenjiaming
 * @version Id: Server.java, v 0.1 2020-07-04 11:58 chenjiaming Exp $$
 */
public class Server {

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress(6888));
		Socket socket = serverSocket.accept();

	}

}
