import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		Stack<String> stack = new Stack<>();
		String tem = "";
		int roop = Integer.parseInt(br.readLine());
		
		for(int i=0; i<roop; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch(command) {
			case "1":
				stack.add(st.nextToken());
				break;
			case "2":
				if(!stack.isEmpty()) {
					bw.write(stack.pop() +"\n"); 
				}
				else {
					bw.write(-1 +"\n"); 
				}
				break;
			case "3":
				bw.write(stack.size() + "\n");
				break;
			case "4":
				if(stack.isEmpty())
					bw.write(1 + "\n");
				else {
					bw.write(0 + "\n");
				}
				break;
			case "5":
				if(!stack.isEmpty())
					bw.write(stack.peek() + "\n");
				else {
					bw.write(-1 +"\n");
				}
				break;
				
			}
			
		}
		
		bw.flush();
		
		
		
		
	}

}
