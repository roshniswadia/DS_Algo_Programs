import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Testclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = Arrays.asList("geeks", "test", "roshni", "to");
		
		list.stream().map(a -> a.length()).forEach(System.out::println);
		
		list.stream().map(a -> new StringBuffer(a).reverse()).forEach(System.out::println);
		
		NullableBook nullableBook = new NullableBook(Optional.ofNullable(null));
		Optional<String> name = nullableBook.getName();
		System.out.println();
		name.ifPresent(System.out::println).orElse("Empty");

	}

}
