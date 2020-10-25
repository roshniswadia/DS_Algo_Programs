import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariableTest {
	
	public static AtomicInteger count = new AtomicInteger(0);
	
	static class Decrementor extends Thread
	{
		public void run() {
			count.decrementAndGet();
		}
	}

	
	static class Incrementor extends Thread
	{
		public void run() {
			count.incrementAndGet();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=0; i<5; i++) {
			new Incrementor().start();
			new Decrementor().start();
		}
		
		System.out.println(count);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSSXXX", Locale.getDefault());
		Date now = new Date();
	    simpleDateFormat .format(now);
	    System.out.println(now);
	}

	
}
