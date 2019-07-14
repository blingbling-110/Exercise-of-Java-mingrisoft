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
		System.out.println("�Ƴ�ǰ��Map���ϣ�");
		while(i.hasNext()) {
			String id = i.next();		//����һ��.next()�������������ͻ����һ��
			System.out.println(id + " " + m.get(id).getName());
		}
		m.remove("015");
		i = m.keySet().iterator();		//��Ҫ���´���������
		System.out.println("�Ƴ����Map���ϣ�");
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