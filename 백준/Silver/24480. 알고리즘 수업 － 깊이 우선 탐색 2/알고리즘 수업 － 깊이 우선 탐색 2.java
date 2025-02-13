import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{
	static int[] visitCheck;
	static ArrayList<Integer>[] graph;
	static Deque<Integer> dq = new ArrayDeque<>();
	static int[] result;
	static int count = 1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
	
		graph = new ArrayList[Integer.parseInt(st.nextToken())+1];
		visitCheck = new int[graph.length+1];
		
		int E = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		result = new int[graph.length];
		
		//도착순서 저장
		for(int i=0; i<graph.length; i++) {
			result[i] = 0;
		}
		
		// 방문체크 초기화
		for(int i=0; i<visitCheck.length; i++) {
			visitCheck[i] = -1;
		}
		
		int a = 0;
		int b=0;
		// 리스트 초기화
		for(int i=0; i<graph.length; i++) {
			graph[i] = new ArrayList<>(); 
		}
		
		//그래프에 값 추가
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b= Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		//그래프 정렬
		for(int i=0; i<graph.length; i++) {
			Collections.sort(graph[i]);
		}
		
//		for(ArrayList<Integer> i:graph) {
//			System.out.println(i); 
//		}
//		
		
		
		dfs(R);
		
		for(int i=1; i<result.length; i++) {
			System.out.println(result[i]);
		}
		
	}
	
	static void dfs(int n) {
		if(visitCheck[n] != -1) return;
		visitCheck[n] = 1;
		result[n] = count++;
		for(int i=0; i<graph[n].size(); i++) {
			dq.push(graph[n].get(i));
		}
		
		while(!dq.isEmpty()) {			
			dfs(dq.pop());
		}
		
		
	}
	
	
}