package DButil;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import User.Product;


public class DButils {
	private static Map<String,Product> map = new LinkedHashMap();

	public static Map<String,Product> getMap() {
		return map;
	}
	static{
		map.put("1",new Product("���ӻ�",5000,"1"));
		map.put("2",new Product("ˮ��",20,"2"));
		map.put("3",new Product("�ֻ�Ь",700,"3"));
	}
	
	
}
