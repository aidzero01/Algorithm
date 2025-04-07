import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.xml.crypto.Data;

public class Main {
	static int row;
	static int col;
	static boolean[][][] resulted;
	static char[][] map;
	static int[] moveX = new int[] {0,0,-1,1};
	static int[] moveY = new int[] {-1,1,0,0};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new char[row][col];
		resulted = new boolean[row][col][2];
		for(int i = 0; i<row; i++) {
			map[i] = br.readLine().toCharArray();
		}
		BFS();
	}
	static void BFS() {
		Queue<Data> q = new ArrayDeque();
		q.add(new Data(0,0,1,1));
		while(!q.isEmpty()) {
			Data d = q.poll();
			if(d.row==row-1&&d.col==col-1) {
				System.out.println(d.left);
				return;
			}
			for(int i = 0; i<4; i++) {
				int y = d.row+moveY[i];
				int x = d.col+moveX[i];
				if(y>=0&&x>=0&&y<row&&x<col&&!resulted[y][x][d.count]&&map[y][x]=='0') {
					resulted[y][x][d.count] = true;
					q.add(new Data(y,x,d.count,d.left+1));
				}
			}
			if(d.count==1) {
				for(int i = 0; i<4; i++) {
					int y = d.row+moveY[i];
					int x = d.col+moveX[i];
					if(y>=0&&x>=0&&y<row&&x<col&&!resulted[y][x][d.count]&&map[y][x]=='1') {
						resulted[y][x][d.count-1] = true;
						q.add(new Data(y,x,d.count-1,d.left+1));
					}
				}
			}
		}
		System.out.println(-1);
	}
	static class Data{
		int row;
		int col;
		int count;
		int left;
		Data(int row,int col,int count,int left){
			this.row = row;
			this.col = col;
			this.count = count;
			this.left = left;
		}
	}
}
