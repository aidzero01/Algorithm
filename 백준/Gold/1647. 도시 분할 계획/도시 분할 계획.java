import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<int[]> list = new ArrayList();
	static int[] arr;
	static int[] rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		rank = new int[N+1];
		for(int i = 1; i<arr.length; i++) {
			arr[i] = i;
		}
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		Collections.sort(list, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				int[] i1 = (int[]) o1;
				int[] i2 = (int[]) o2;
				return i1[2]-i2[2];
			}
		});
		int count = 0;
		int index = 0;
		long sum = 0;
		int last = 0;
		while(count!=N-1) {
			int[] tmp = list.get(index++);
			if(union(tmp[0],tmp[1])) {
				count++;
				sum += tmp[2];
				last = tmp[2];
			}
		}
		System.out.println(sum-last);
	}
	static boolean union(int a,int b) {
		int r1 = find(a);
		int r2 = find(b);
		if(r1==r2) {
			return false;
		}
		if(rank[r1]>rank[r2]) {
			arr[r2] = r1;
		}else if(rank[r1]<rank[r2]) {
			arr[r1] = r2;
		}else {
			arr[r1] = r2;
			rank[r2] += 1;
		}
		return true;
	}
	static int find(int a) {
		if(arr[a]==a) {
			return a;
		}
		return arr[a] = find(arr[a]);
	}
}
