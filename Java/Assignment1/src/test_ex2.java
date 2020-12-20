import java.text.SimpleDateFormat;

public class test_ex2 {

	public static void main(String[] args) {
	// Question 1
		int i = 5;
		System.out.println(i);
	// Question2
		int n=10000000;
		System.out.printf("%d",n);
	//Question 3
		float m = (float) 5.567098;
		System.out.printf("\n%.04f",m);
	// Question 4
		String pattern = "dd/MM/yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
	}

}
