import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Node>[] list;
	static int[] count;
	static long[] distance;
	static int vor;
	static int edge;
	static int k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		vor = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		list = new ArrayList[vor+1];
		count = new int[vor+1];
		distance = new long[vor+1];
		for(int i = 1; i<list.length; i++) {
			list[i] = new ArrayList();
		}
		for(int i = 0; i<edge; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list[s].add(new Node(e,d));
		}
		distra();
		for(int i = 1; i<distance.length; i++) {
			if(count[i]<k) {
				System.out.println(-1);
			}else {
				System.out.println(distance[i]);
			}
		}
	}
	static void distra() {
		PriorityQueue<Node> pq = new PriorityQueue(new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				Node n1 = (Node) o1;
				Node n2 = (Node) o2;
				return Long.compare(n1.dis, n2.dis);
			}
		});
		pq.add(new Node(1,0));
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			if(count[n.curr]==k) continue;
			count[n.curr]++;
			distance[n.curr] = n.dis;
			for(Node node : list[n.curr]) {
				pq.add(new Node(node.curr,n.dis+node.dis));
			}
		}
	}
	static class Node{
		int curr;
		long dis;
		public Node(int curr, long dis) {
			this.curr = curr;
			this.dis = dis;
		}
		
	}
}
