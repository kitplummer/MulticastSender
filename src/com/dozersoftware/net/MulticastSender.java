package com.dozersoftware.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;


public class MulticastSender {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MulticastSocket socket;
		try {
			socket = new MulticastSocket();
			//socket.setNetworkInterface(NetworkInterface.getByName(inf));
			DatagramPacket dgram;
			String test = "This is a test!";
			byte[] msg = test.getBytes();
			dgram = new DatagramPacket(msg, msg.length,
					InetAddress.getByName("224.0.0.6"), 6789);

			System.out.println("Sending " + msg.length + " bytes to " +
					dgram.getAddress() + ':' + dgram.getPort());

			socket.send(dgram);

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
