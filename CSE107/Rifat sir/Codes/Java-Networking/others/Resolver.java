package others;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Resolver {
	public static void main(String args[]) {
		try {
			InetAddress ipAddress = InetAddress.getByName("www.google.com");
			System.out.println(ipAddress);
		} catch (UnknownHostException ex) {
			System.out.println(ex);
		}
	}
}