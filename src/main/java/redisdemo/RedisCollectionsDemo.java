package redisdemo;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;

public class RedisCollectionsDemo {
	public static void main(String[] args) throws IOException {

		RedissonClient redisson = Redisson.create();

		Map<String, Integer> newMap = redisson.getMap("myNewMap");

		Map<String, Integer> map = redisson.getMap("myMap");
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);

		System.out.println(map.get("a"));

		Set<String> set = redisson.getSet("mySet");
		set.add("programmer");
		set.add("loyer");
		set.add("accountant");
		set.add("nurse");

		boolean contains = set.contains("programmer");
		System.out.println("contains = " + contains);

		List<String> listStudents = redisson.getList("myList");
		listStudents.add("Alex");
		listStudents.add("Ivan");
		listStudents.add("Anton");
		listStudents.add("Sasha");

		String string = listStudents.get(2);
		System.out.println(string);

		newMap.putAll(map);

		redisson.shutdown();

	}

}
