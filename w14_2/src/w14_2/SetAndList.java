package w14_2;

import java.util.*;

public class SetAndList {

	public static void main(String[] args) {
		HashSet<String> h = new HashSet<String>();
		ArrayList<String> a = new ArrayList<String>();
		h.add("A");
		h.add("a");
		h.add("c");
		h.add("C");
		h.add("a");
		a.add("A");
		a.add("a");
		a.add("c");
		a.add("C");
		a.add("a");
//		Iterator<String> hi = h.iterator();
//		Iterator<String> ai = a.iterator();
//		while(hi.hasNext()) {
//			System.out.print(hi.next() + " ");
//		}
//		System.out.println("");
//		while(ai.hasNext()) {
//			System.out.print(ai.next() + " ");
//		}
//		System.out.println("");
		System.out.println(h);		//可直接输出Set、List集合
		System.out.println(a);
	}

}
