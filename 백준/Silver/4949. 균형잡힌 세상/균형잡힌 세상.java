import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int small = 0;
		int big = 0;
		int cc = -1;
		Stack<Character> back = new Stack<>();
		
		while(true) {
			String tem = br.readLine(); 
			cc = -1;
			small = 0;
			big = 0;
			int excp = -1;
			
			
			if(tem.charAt(0) == '.') break;
			
			for(int i=0; i<tem.length(); i++) {
				if(tem.charAt(i) == '[') {
					big++;
					back.add('[');
				}
				
				if(tem.charAt(i) == '(') {
					small++;
					back.add('(');
				}
				
				
				if(tem.charAt(i) == ']') {
					big--;
					if(!back.isEmpty() && back.pop() != '[') {
						excp = 0;
					}
				}
				
				if(tem.charAt(i) == ')') {
					small--;
					if(!back.isEmpty() && back.pop() != '(') {
						excp = 0;
					}
				}
				
				if(small<0 || big<0) {
					excp = 0;
					
				}
			}
			
			if(excp == 0 || small != 0 || big !=0)
				bw.write("no\n");
			else 
				bw.write("yes\n");	

		}
		
		bw.flush();
		
		
	}

}
