package util.test.db;

import java.io.UnsupportedEncodingException;

public class StringConvert {

	public static String convert(String s)
	{
		String gb;
		try{
		if(s.equals("") || s == null){
			return "";
		}
		else{
			s = s.trim();
		gb = new String(s.getBytes("ISO-8859-1"),"GBK");
		return gb;
			}
		}
		catch(Exception e){
		System.err.print("±àÂë×ª»»´íÎó£º"+e.getMessage());
		return "";
		}
	}
	
	public static String ConvertISO(String s)
	{
		String gb;
		try{
		if(s.equals("") || s == null){
			return "";
		}
		else{
			s = s.trim();
		gb = new String(s.getBytes("GBK"),"ISO-8859-1");
		return gb;
			}
		}
		catch(Exception e){
		System.err.print("±àÂë×ª»»´íÎó£º"+e.getMessage());
		return "";
		}
	}
}
