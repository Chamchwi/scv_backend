package kr.smaker.scv.manager;

public class RemoveBOM {
	public static final String UTF8_BOM = "\uFEFF";

	public String remove(String s) {
	    if (s.startsWith(UTF8_BOM)) {
	        s = s.substring(1);
	    }
	    return s;
	}
}
