package com.dozersoftware.net;

import gov.nucas.messages.JAvPG1Msg;

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
			
			//byte[] msg = BasicByteTest();
			byte[] msg = PG1Test();
			
			dgram = new DatagramPacket(msg, msg.length,
					InetAddress.getByName("239.150.100.75"), 55120);

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
	
	private static byte[] BasicByteTest() {
		String test = "This is a test!";
		byte[] msg = test.getBytes();
		msg[0] = 0x13;
		msg[1] = (byte)0x96;
		msg[14] = 0x03;
		return msg;
	}
	
	private static byte[] PG1Test() {
		JAvPG1Msg oMsg = new JAvPG1Msg();
		
		byte[] ret = new byte[60];
		
		oMsg.Update();
		oMsg.Set_ShipLat(34.0);
	    oMsg.Set_ShipHdgRate(8);	
		
		oMsg.ToBuffer(ret);
		
		
		return ret;
	}

}
