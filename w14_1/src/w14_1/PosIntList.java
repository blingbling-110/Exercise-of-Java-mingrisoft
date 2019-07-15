package w14_1;

import java.util.*;

public class PosIntList {
	public static void printList(ArrayList<Integer> list) {
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		ArrayList<Integer> positive_int_list = new ArrayList<Integer>();
		
		for(int i = 1; i <= 100; i++) {
			positive_int_list.add(i);
		}
		System.out.println("List集合中的元素：");
		printList(positive_int_list);
		
		positive_int_list.remove(10);
		System.out.println("移除后，List集合中的元素：");
		printList(positive_int_list);
	}

}
