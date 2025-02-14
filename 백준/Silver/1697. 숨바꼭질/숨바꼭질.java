import java.io.*;
import java.util.*;

public class Main {
	static int[] move = {1,-1,2};
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
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {start,0});
		boolean[] visitcheck = new boolean[100001];
		while(!q.isEmpty()) {
			int[] tem = q.poll();
			
			
			
			for(int i=0; i<3; i++) {
				int location;
				
				if(i==2) {
					location = tem[0] * move[i];
				}else { 
					location = tem[0] + move[i];
				}
				int time = tem[1] + 1;
				
				if(location == end) {
					System.out.println(time);
					return;
				}
				
				if(location<=100000 && location>=0 && visitcheck[location] == false) {
					visitcheck[location] = true;
					q.add(new int[] {location, time});
				}
			}
		}
	}
}