package no.group09.stk500;

import java.io.InputStream;
import java.io.OutputStream;

public class STK500v1 {
	private OutputStream output;
	private InputStream input;
	private Logger logger;
	private byte[] binary;
	
	public STK500v1 (OutputStream output, InputStream input, Logger logger, byte[] binary) {
		this.output = output;
		this.input = input;
		this.logger = logger;
		this.binary = binary;
		logger.debugTag("Initializing programmer");
	}
	
	
	/**
	 * Read two unsigned bytes into an integer
	 * @param high Most significant byte
	 * @param low  Least significant byte
	 * @return
	 */
	private static int unPackTwoBytes(byte high, byte low) {
		int out = (decodeByte(high) << 8) | (decodeByte(low));
		return out;
	}
	
	/**
	 * Get the unsigned value of a byte
	 * @param unsignedByte
	 * @return
	 */
	private static int decodeByte(byte unsignedByte) {
		return 0xFF & unsignedByte;
	}
}
