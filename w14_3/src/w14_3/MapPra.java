package w14_3;

import java.util.*;

public class MapPra {

	public static void main(String[] args) {
		Emp p1 = new Emp("014", "p1");
		Emp p2 = new Emp("015", "p2");
		Emp p3 = new Emp("016", "p3");
		Emp p4 = new Emp("017", "p4");
		HashMap<String, Emp> m = new HashMap<String, Emp>();
		m.put(p1.getId(), p1);
		m.put(p2.getId(), p2);
		m.put(p3.getId(), p3);
		m.put(p4.getId(), p4);
		Iterator<String> i = m.keySet().iterator();
		System.out.println("移除前的Map集合：");
		while(i.hasNext()) {
			String id = i.next();		//调用一次.next()方法，迭代器就会迭代一次
			System.out.println(id + " " + m.get(id).getName());
		}
		m.remove("015");
		i = m.keySet().iterator();		//需要重新创建迭代器
		System.out.println("移除后的Map集合：");
		while(i.hasNext()) {
			String id = i.next();
			System.out.println(id + " " + m.get(id).getName());
		}
	}

}

class Emp {
	private String id;
	private String name;
	
	public Emp(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
}