import java.io.*;
import java.util.*;

public class Main {
	static int[] move = {2,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		if(start == end) {
			System.out.println(0);
		}else {
			bfs(start,end);
		}
	}
	
	static void bfs(int start, int end) { 
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {start,0});
		boolean[] visitcheck = new boolean[100001]; 
		visitcheck[start] = true;
		while(!q.isEmpty()) {
			int[] tem = q.poll();
			int location = tem[0];
			int time = tem[1];
			
			if(location == end) {
				System.out.println(time);
				return;
			}
			
			for(int i=0; i<3; i++) {
				
				if(i==0) {
					location = tem[0] * move[i];
					time = tem[1];
					
					if(location<=100000 && location>=0 && visitcheck[location] == false) {
						visitcheck[location] = true;
						q.addFirst(new int[] {location, time});
					}
					
				}else { 
					location = tem[0] + move[i]; 
					time = tem[1] + 1;
					
					if(location<=100000 && location>=0 && visitcheck[location] == false) {
						visitcheck[location] = true;
						q.addLast(new int[] {location, time});
					}
				}
				
			}
		}
	}
}