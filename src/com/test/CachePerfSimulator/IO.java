package com.test.CachePerfSimulator;

public class IO {
	public static String int_to_hex(int n) {
        String hex_string = Integer.toHexString(n);
	while(hex_string.length() < 8) {
		hex_string = "0" + hex_string;
	}
	return hex_string;
    }

    public static long hex_to_int(String s) {
        String digits = "0123456789ABCDEF";
        s = s.toUpperCase();
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int d = digits.indexOf(c);
            val = 16*val + d;
        }
        return val;
    }
    
    public static String dec_to_hex(String s) {
		long no = Long.parseLong(s);
		String hex = Long.toHexString(no);
		while (hex.length() < 8) {
			hex = "0" + hex;
		}
		return hex;
	}
    
	public static String binary_to_hex(String s) {
		long baseten = binary_to_int(s);
		return Long.toHexString(baseten);
	}

	public static String int_to_hex(long input_integer) {
		String hex_string;
		hex_string = Long.toHexString(input_integer);
		while (hex_string.length() < 8) {
			hex_string = "0" + hex_string;
		}

		return hex_string;
	}

	public static String int_to_binary(long input_integer) {
		String temp = int_to_hex(input_integer);
		return hex_to_binary(temp);
	}
	
	public static long binary_to_int(String s) {
		
		String digits = "01";
		long val = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int d = digits.indexOf(c);
			val = 2 * val + d;
		}
		return val;
	}
	
	public static String hex_to_binary(String s) {
		String digits = "0123456789ABCDEF";
		String[] binaryArray = { "0000", "0001", "0010", "0011", "0100",
				"0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100",
				"1101", "1110", "1111" };
		String result = "";
		s = s.toUpperCase();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			result += binaryArray[digits.indexOf(c)];
		}
		return result;
	}
}
