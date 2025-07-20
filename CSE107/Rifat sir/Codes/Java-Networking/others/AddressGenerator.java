package others;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddressGenerator {
	public static void main(String args[]) {
		byte address[] = new byte[4];
		address[0] = (byte) 192;
		address[1] = (byte) 168;
		address[2] = (byte) 0;
		address[3] = (byte) 63;
		try {
			InetAddress ipAddress = InetAddress.getByAddress(address);
			System.out.println(ipAddress);
		} catch (UnknownHostException ex) {
			System.out.println(ex);
		}
	}
}