import java.io.*;
import java.util.*;


public class Main{
	
	static long gogo(int a) {
		if(a==0) return 1;
		return gogo(a-1) * a;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		System.out.println(gogo(Integer.parseInt(br.readLine())));
		
	}

}
