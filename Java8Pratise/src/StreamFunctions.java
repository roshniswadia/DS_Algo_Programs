import java.util.Arrays;
import java.util.stream.Stream;

public class StreamFunctions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		// 1st argument, init value = 0
		int sum = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);

		System.out.println("sum : " + sum); // 55
		
		String[] strings = {"a", "b", "c", "d", "e"};

		// |a|b|c|d|e , the initial | join is not what we want
		String reduce = Arrays.stream(strings).reduce("", (a, b) -> a + "|" + b);
	}

}
