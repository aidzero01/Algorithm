import java.io.*;
import java.util.*;

public class Main {
	static int[][] board;
	static boolean[][] visitcheck;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int M;
	static int N;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    
    		st = new StringTokenizer(br.readLine());
    		M = Integer.parseInt(st.nextToken());
    		N = Integer.parseInt(st.nextToken());
    		
    		board = new int[M][N];
    		visitcheck = new boolean[M][N];
    		
    		//board 초기화 visit초기화
    		for(int i=0; i<M; i++) {
    			String tem = br.readLine();
    			for(int j=0; j<N; j++) {
    				board[i][j] = tem.charAt(j) - '0';
    				visitcheck[i][j] = false;
    			}
    		}
    		
    		for(int i=0; i<M; i++) {
    			for(int j=0; j<N; j++) {
    				if(board[i][j] == 1 && !visitcheck[i][j]) {
    					bfs(j,i);
    				}
    			}
    		}
    		
    	
    	System.out.println(board[M-1][N-1]);
    	
    }
    
    static void bfs(int x, int y) {
    	Queue<int[]> q = new LinkedList<>();
    	q.add(new int[] {x,y});
    	visitcheck[y][x] = true;
    	
    	while(!q.isEmpty()) {
    		int[] tem = q.poll();
    		int xx = tem[0];
    		int yy = tem[1];
    		for(int i=0; i<4; i++) {
    			int nx = xx + dx[i];
    			int ny = yy + dy[i];
    			
    			if(ny>=0 && nx>=0 && ny<M && nx<N) {
    				if(board[ny][nx] ==1 && !visitcheck[ny][nx]) {
	    				visitcheck[ny][nx] = true;
	    				q.add(new int[] {nx,ny});
	    				board[ny][nx]  = board[yy][xx] + 1;
	    			}
    			}
	    			
    		}
    	}
    	
    }
}
