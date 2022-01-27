package collectionpkg;

import java.util.*;

public class QueueSample {

	public static void main(String[] args) {
		Queue <String> queue= new PriorityQueue<>(); 
		queue.add("Apple");
		queue.add("Orange");
		queue.add("Bananas");
		// queue.poll();

		for (String fruit: queue)
		{
			System.out.println(fruit);
		}
	}
}
