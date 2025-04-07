import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static String[][] arr;
	static boolean[][] resulted;
	static Queue<Data> hojer = new LinkedList();
	static Queue<Data> water = new LinkedList();
	static int[] moveX = {-1,0,1,0};
	static int[] moveY = {0,-1,0,1};
	static int answer = Integer.MAX_VALUE;
	static int row;
	static int col;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        arr = new String[row][col];
        resulted = new boolean[row][col];
        for(int i = 0; i<row; i++) {
        	arr[i] = br.readLine().split("");
        }
        for(int i = 0; i<row; i++) {
        	for(int j = 0; j<col; j++) {
        		if(arr[i][j].equals("S")) {
        			hojer.add(new Data(i,j,0));
        			resulted[i][j] = true;
        		}else if(arr[i][j].equals("X")) {
        			resulted[i][j] = true;
        		}else if(arr[i][j].equals("*")) {
        			water.add(new Data(i,j,0));
        			resulted[i][j] = true;
        		}
        	}
        }
        BFS();
        if(answer==Integer.MAX_VALUE) {
        	System.out.println("KAKTUS");
        }else {
        	System.out.println(answer);
        }
    }
    static void BFS() {
    	int count = 0;
    	Outer:while(true) {
	    	while(!hojer.isEmpty()&&hojer.peek().count==count) {
	    		Data d = hojer.poll();
	    		for(int i = 0; i<4; i++) {
	    			int x = d.col+moveX[i];
	    			int y = d.row+moveY[i];
	    			if(hojermove(y,x)) {
	    				if(arr[y][x].equals("D")) {
	    					answer = d.count+1;
	    					break Outer;
	    				}
	    				resulted[y][x] = true;
	    				hojer.add(new Data(y,x,count+1));
	    			}
	    		}
	    	}
	    	while(!water.isEmpty()&&water.peek().count==count) {
	    		Data d = water.poll();
	    		for(int i = 0; i<4; i++) {
	    			int x = d.col+moveX[i];
	    			int y = d.row+moveY[i];
	    			if(watermove(y,x)) {
	    				resulted[y][x] = true;
	    				water.add(new Data(y,x,count+1));
	    				arr[y][x] = "*";
	    			}
	    		}
	    	}
	    	if(hojer.isEmpty()) {
	    		break;
	    	}
	    	count++;
    	}
    }
    static class Data{
    	int row;
    	int col;
    	int count;
		public Data(int row, int col, int count) {
			this.row = row;
			this.col = col;
			this.count = count;
		}
    }
    static boolean watermove(int r, int c) {
    	if(r>=0&&c>=0&&r<row&&c<col&&(arr[r][c].equals(".")||arr[r][c].equals("S"))) {
    		return true;
    	}
    	return false;
    }
    static boolean hojermove(int r, int c) {
    	if(r>=0&&c>=0&&r<row&&c<col&&!resulted[r][c]) {
    		if(arr[r][c].equals("D")) {
				return true;
			}
    		for(int i = 0; i<4; i++) {
    			int x = c+moveX[i];
    			int y = r+moveY[i];
    			if(x>=0&&y>=0&&y<row&&x<col&&arr[y][x].equals("*")) {
    				return false;
    			}
    		}
    		return true;
    	}
    	return false;
    }
}
