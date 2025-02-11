import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int loop = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<Integer> s = new Stack<>();
		Queue<Integer> q = new LinkedList<Integer>();
		
		//값 저장
		for(int i=0; i<loop; i++) {
			q.add(Integer.parseInt(st.nextToken()));
		}
		
		int index = 1;
		
		//큐에 있는거 출력
		while(!q.isEmpty()) {
			if(q.peek() == index) {
				index++;
				q.poll();	
			}else{
				s.add(q.poll());
			}
			
			
			while(true) {
				if(!s.isEmpty()) {
					if(index == s.peek()) {
						index++;
						s.pop();
					}else
						break;
				}else {
					break;
				}
			}
			
		}
		
		//스택에 있는거 출력
		int size = s.size();
		
		for(int i=0; i<size; i++) {
			if(index == s.peek()) {
				index++;
				s.pop();
			}
		}
		
		if(!s.isEmpty()) {
			bw.write("Sad");
		}else {
			bw.write("Nice");
		}
		bw.flush();
		
		
	}

}
