package org.sfm.csv.parser;

import java.io.IOException;
import java.io.Reader;

public final class CharBuffer {


	private char[] buffer;
	private int bufferLength;

	private int mark;

	public CharBuffer(final int bufferSize) {
		this.buffer = new char[bufferSize];
	}
	
	public void mark(int index) {
		this.mark = index;
	}
	
	public boolean fillBuffer(Reader reader) throws IOException {
		int length = reader.read(buffer, bufferLength, buffer.length- bufferLength);
		if (length != -1) {
			bufferLength += length;
			return true;
		} else {
			return false;
		}
	}


	public int shiftBufferToMark() {
		// shift buffer consumer data
		int newLength = Math.max(bufferLength - mark, 0);

		// if buffer tight double the size
		if (newLength <= (bufferLength >> 1)) {
			System.arraycopy(buffer, mark, buffer, 0, newLength);
		} else {
			// double buffer size
			char[] newBuffer = new char[buffer.length << 1];
			System.arraycopy(buffer, mark, newBuffer, 0, newLength);
			buffer = newBuffer;
		}
		bufferLength = newLength;

		int m = mark;
		mark = 0;
		return m;
	}

	public char[] getCharBuffer() {
		return buffer;
	}


	public int getMark() {
		return mark;
	}



	public char getChar(int bufferIndex) {
		return buffer[bufferIndex];
	}

	public int getBufferLength() {
		return bufferLength;
	}
}
