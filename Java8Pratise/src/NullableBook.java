import java.util.Optional;

public class NullableBook {

	Optional<String> bookName;
	
	public NullableBook(Optional<String> bookName) {
		this.bookName = bookName;
	}
	
	public Optional<String> getName(){
		return bookName;
	}
}
