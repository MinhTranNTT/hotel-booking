package com.hotel.common.util;

import java.util.regex.Matcher;

public class RegularExpression {
	
	public final static String MONEY = "(\\-?([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){1,6})?";

	public final static String DATE = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";

	public final static String DATETIME = "(\\d{2}|\\d{4})(?:\\-)?([0]{1}\\d{1}|[1]{1}[0-2]{1})(?:\\-)?([0-2]{1}\\d{1}|[3]{1}[0-1]{1})(?:\\s)?([0-1]{1}\\d{1}|[2]{1}[0-3]{1})(?::)?([0-5]{1}\\d{1})(?::)?([0-5]{1}\\d{1})";

	public final static String NUMBER = "^[0-9]*$";

	public final static String EMAIL = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

	public final static String IP = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
			+ "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
			+ "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

	public final static String PHONE = "^1[1|2|3|4|5|6|7|8|9][0-9]\\d{8}$";

	public static void main(String[] args) {
		String reg = RegularExpression.MONEY;
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(reg);
		// ^2015-07-29^2015-07-29
		Matcher m2 = pattern.matcher("11111.11");
		System.err.println(m2.matches());
	}
}
