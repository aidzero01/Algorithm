import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Deque<Integer> q = new ArrayDeque<>();
		int loop = Integer.parseInt(br.readLine());
		
		for(int i=1; i<loop+1; i++) {
			q.add(i);
		}
		
		while(true) {
			if(q.size() == 1) break;
			q.pollFirst();
			q.addLast(q.pollFirst());
			
			
		}
		System.out.println(q.poll()); 
		
	}

}
