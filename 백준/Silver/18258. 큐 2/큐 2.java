import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Deque<Integer> q = new ArrayDeque<>();
		int loop = Integer.parseInt(br.readLine());
		
		for(int i=0; i<loop; i++) {
			st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			case "push":
				q.add(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(q.isEmpty()) {
					bw.write(-1 + "\n");
				}else {
					bw.write(q.poll()+"\n");
				}
				break;
			case "size":
				bw.write(q.size() + "\n");
				break;
			case "empty":
				if(q.isEmpty()) bw.write(1+"\n");
				else bw.write(0+"\n");
				break;
			case "front":
				if(q.isEmpty()) bw.write(-1 + "\n");
				else bw.write(q.peekFirst() + "\n");
				break;
			case "back":
				if(q.isEmpty()) bw.write(-1 + "\n");
				else bw.write(q.peekLast()+ "\n");
				break;
			}
			
			
		}

		bw.flush();
		
		
	}

}
