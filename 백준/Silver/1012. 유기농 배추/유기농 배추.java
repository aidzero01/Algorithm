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
    	
    	int loop = Integer.parseInt(br.readLine());
    	
    	//테케 횟수만큼 반복
    	for(int testcase=0; testcase<loop; testcase++) {
    		st = new StringTokenizer(br.readLine());
    		M = Integer.parseInt(st.nextToken());
    		N = Integer.parseInt(st.nextToken());
    		int cavage = Integer.parseInt(st.nextToken());
    		board = new int[N][M];
    		visitcheck = new boolean[N][M];
    		
    		//board 초기화 visit초기화
    		for(int i=0; i<N; i++) {
    			for(int j=0; j<M; j++) {
    				board[i][j] = 0;
    				visitcheck[i][j] = false;
    			}
    		}
    		
    		//배추 세팅
    		for(int i=0; i<cavage; i++) {
    			st = new StringTokenizer(br.readLine());
    			int x = Integer.parseInt(st.nextToken());
    			int y = Integer.parseInt(st.nextToken());
    			
    			board[y][x] = 1;
    		}
    		int count = 0;
    		for(int i=0; i<N; i++) {
    			for(int j=0; j<M; j++) {
    				if(board[i][j] == 1 && !visitcheck[i][j]) {
    					count++;
    					bfs(j,i);
    				}
    			}
    		}
    		
    		bw.write(count + "\n");
    		
    	}
    	bw.flush();
    	
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
    			
    			if(ny>=0 && nx>=0 && ny<N && nx<M) {
    				if(board[ny][nx] ==1 && !visitcheck[ny][nx]) {
	    				visitcheck[ny][nx] = true;
	    				q.add(new int[] {nx,ny});
	    			}
    			}
	    			
    		}
    	}
    	
    }
}
