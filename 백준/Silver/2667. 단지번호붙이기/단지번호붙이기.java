import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int N;
		public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int various = 0;
    	N = Integer.parseInt(br.readLine());
    	board = new int[N][N];
		visited = new boolean[N][N];
		
    	//판, 방문 초기화
    	for(int i=0; i<N; i++) {
    		String tem = br.readLine();
    		for(int j=0; j<N; j++) {
    			board[i][j] = tem.charAt(j)-'0';
    			visited[i][j] = false;
    		}
    	}
    	
    	
    	//판 검색, count 0 초기화랑 various 1 추가 여기서 해야함
    	List<Integer> list = new ArrayList<>();
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			if(board[i][j] == 1 && !visited[i][j]) { 
    				int count = bfs(i,j);
    				list.add(count);
    				various++;
    			}
    		}
    	}
    	
    	System.out.println(various);
    	Collections.sort(list);
    	for(int i:list) System.out.println(i);
    	
    	
    }
		
		
	static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		visited[x][y] = true;
		int count = 1;
		
		while(!q.isEmpty()) {
			int[] tem = q.poll();
			for(int i=0; i<4; i++) {
				int nx = tem[0] + dx[i];
				int ny = tem[1] + dy[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<N) { 
					if (board[nx][ny] == 1 && !visited[nx][ny]) {
	                    q.add(new int[]{nx, ny});
	                    visited[nx][ny] = true;
	                    count++;
	                }
				}
			}
		
		}
		
		return count;
		
	}
}
