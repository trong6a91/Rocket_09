import java.util.Scanner;

import com.sun.accessibility.internal.resources.accessibility;
import com.sun.org.apache.xpath.internal.axes.ReverseAxesWalker;
import com.sun.xml.internal.ws.api.message.saaj.SAAJFactory;

public class Exercise4 {

	public static void main(String[] args) {
//		question1();
//		question2();
//		question3();
//		question4();
//		question5();
//		question6();
//		question7();
//		question8();
//		question9();
//		question10();
//		System.out.print(question11_Count("Ba Tien"));
//		System.out.print(question12_Reverse_String("Ba Tien"));
//		question13();
//		question14();
//		question15();
		question16();

	}
	
	public static void question1() {
		Scanner scanner= new Scanner(System.in);
		System.out.print("Nhap vao 1 chuoi: ");
		String str = scanner.nextLine();
		scanner.close();
		//str.trim();
		int dem=0;
		if(str.charAt(0)!=' ')
		{
			dem++;
		}
		for(int i=0; i < str.length()-1; i++)
		{
			if(str.charAt(i)==' ' && str.charAt(i+1)!=' ')
				dem++;
		}
		System.out.println("Chuoi co "+ dem+ " tu.");
	}
	
	
	public static void question2() {
		Scanner scanner= new Scanner(System.in);
		System.out.print("Nhap vao chuoi 1: ");
		String str1 = scanner.nextLine();
		System.out.print("Nhap vao chuoi 2: ");
		String str2 = scanner.nextLine();
		scanner.close();
		str1 +=str2;
		System.out.println("Chuoi sau khi noi: "+str1);
	}
	
	public static void question3() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao ten: ");;
		String str= scanner.nextLine();
		str= str.trim();
//		str =str.replaceAll("  "," ");
		
		int q= str.length();
		for(int i=0; i<q; i++)
		{
			
			if(str.charAt(i) ==' ' && str.charAt(i+1)==' ')
			{
				str = str.replaceFirst(" ","");
				i--;
				q--;
			}
		}
		
		String str1="";
		String a[] = str.split(" ");
		for(int i=0; i<a.length; i++)
		{
			str1+= String.valueOf(a[i].charAt(0)).toUpperCase() + a[i].substring(1).toLowerCase();
			if( i!= (a.length-1))
				str1+=" ";
		}
		
		System.out.println("Ten sau khi chuan hoa: "+str1);
		scanner.close();
	}
	
	public static void question4() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao ten: ");
		String str = scanner.nextLine();
		for(int i=0; i< str.length(); i++)
		{
			System.out.println("Ki tu thu "+(i+1)+ ": "+String.valueOf(str.charAt(i)).toUpperCase());
		}
		scanner.close();
	}
	
	public static void  question5() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap vao ho: ");
		String ho = scanner.nextLine();
		System.out.print("Nhap vao ten: ");
		String ten = scanner.nextLine();
		System.out.print("Ho va ten: "+ho+" "+ten );
		scanner.close();
	}
	
	public static void question6() {
		Scanner scanner = new Scanner(System.in);
		String[] a,b;
		do {
			System.out.print("Nhap vao ten: ");
			String str = scanner.nextLine();
			str= str.trim();
			int q=str.length();
			for(int i=0; i<q; i++)
			{
				if(str.charAt(i) ==' ' && str.charAt(i+1)==' ')
				{
					str = str.replaceFirst("  "," ");
					i--;
					q--;
				}
			}
			String str1="";
			a = str.split(" ");
			for(int i=0; i<a.length; i++)
			{
				str1+= String.valueOf(a[i].charAt(0)).toUpperCase() + a[i].substring(1).toLowerCase();
				if( i!= (a.length-1))
					str1+=" ";
			}
			b = str1.split(" ");
			if(a.length <=1)
			{
				System.out.println(a.length);
				System.out.print("Khong day du ho va ten! Vui long nhap lai\n");
			}
		}
		while(a.length<=1);
		int n= b.length;
		if(n==2)
		{
			System.out.println("Ho: "+b[0]);
			System.out.println("Ten: "+ b[1]);
		}
		else {
			System.out.print("Ho: "+ b[0]);
			System.out.print("\nHo dem: ");
			for(int i=1; i<n-1; i++)
			{
				System.out.print(b[i]+" ");
			}
			System.out.print("\nTen: "+b[n-1]);
		}
		scanner.close();
	}
	
	
	public static void question7() {
		//question6 da lam dieu tuong tu
	}
	
	public static void  question8() {
		// chuyen sang lam tren exercise1 trong testing system 1
		
	}
	public static void  question9() {
		// chuyen sang lam tren exercise1 trong testing system 1
	}
	public static void  question10() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap chuoi 1: ");
		String str1 = scanner.nextLine();
		System.out.print("Nhap chuoi 2: ");
		String str2 = scanner.nextLine();
		String str3 = new StringBuffer(str2).reverse().toString();
		if(str1.equals(str3))
		{
			System.out.print("\""+str1 +"\""+" va "+"\""+str2+"\""+ " la 2 chuoi dao nguoc");
		}
		scanner.close();
	}
	
	public static int  question11_Count(String str) {
		int dem=0;
		for(int i=0; i<str.length(); i++)
		{
			if(str.charAt(i)=='a')
				dem++;
		}
		return dem;
	}
	
	public static String question12_Reverse_String(String str) {
		String str1="";
		for(int i=str.length()-1; i>=0; i--)
		{
			str1 += String.valueOf(str.charAt(i));
		}
		return str1;
	}
	
	public static void question13() {
		Scanner scanner= new Scanner(System.in);
		System.out.print("Nhap vao 1 chuoi: ");
		String str = scanner.nextLine();
		int dem=0;
		for(int i=0; i<str.length(); i++)
		{
			for(int j=48; j<58; j++)
			{
				if(str.charAt(i)==j)
				{
					System.out.print("Chuoi co chua ki tu so");
					dem++;
					break;
				}
			}
			if(dem>0)
				break;
		}
		if(dem==0)
			System.out.print("Chuoi khong chua ki tu so");
		scanner.close();
	}
	
	
	public static void question14() {
		Scanner scanner= new Scanner(System.in);
		System.out.print("Nhap vao 1 chuoi: ");
		String str = scanner.nextLine();
		String str1;
		do {
			System.out.print("Nhap vao 1 ki tu can thay the: ");
			str1 = scanner.nextLine();
			if(str1.length()>1)
			{
				System.out.println("Khong phai 1 ki tu! Vui long nhap lai");
			}
		} while (str1.length()>1);
		
		String str2;
		do {
			System.out.print("Nhap vao 1 ki tu thay the: ");
			str2 = scanner.nextLine();
			if(str2.length()>1)
			{
				System.out.println("Khong phai 1 ki tu! Vui long nhap lai");
			}
		} while (str2.length()>1);
		
		str=str.replaceAll(str1, str2);
		
		System.out.println("Chuoi sau khi thay: "+str);
		scanner.close();
	}
	
	public static void  question15() {
		Scanner scanner = new Scanner(System.in);
		String[] a,b;
		System.out.print("Nhap vao 1 chuoi: ");
		String str = scanner.nextLine();
		str= str.trim();
		int q=str.length();
		for(int i=0; i<q; i++)
		{
			if(str.charAt(i) ==' ' && str.charAt(i+1)==' ')
			{
				str = str.replaceFirst("  "," ");
				i--;
				q--;
			}
		}
		String str1="";
		a = str.split(" ");
		for(int i=0; i<a.length; i++)
		{
			str1+= String.valueOf(a[i].charAt(0)).toUpperCase() + a[i].substring(1).toLowerCase();
			if( i!= (a.length-1))
				str1+=" ";
		}
		b = str1.split(" ");
		System.out.print("Chuoi sau khi dao tu: ");
		for(int i=b.length-1; i>=0; i--)
		{
			System.out.print(b[i]+" ");
		}
		scanner.close();
	}
	
	public static void  question16() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap vao 1 chuoi: ");
		String str = scanner.nextLine();
		System.out.print("Nhap vao 1 so n= ");
		int n = scanner.nextInt();
		if(str.length()%n!=0 || str.equals(null))
		{
			System.out.print("KO");
		}
		else {
			for(int j=0; j<str.length(); j+=n)
			{
				System.out.println( str.substring(j, j+n));
			}
		}
		scanner.close();
	}
}