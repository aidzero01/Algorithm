import java.util.*;
import java.io.*;

public class Main {
	
	public static boolean bs (int[] house,int mid,int m) {
		
		m-=1;
		int prefix = 0;
		int cnt=0;
		for(int i=1;i<house.length;i++) {
			prefix += house[i] - house[i-1];
			
			if(prefix >= mid) {
				prefix = 0;
				cnt++;
			}
		}
		
		if (cnt >= m) {
			return true;
		}
		
		return false;
	}
	
	
	public static void main(String[] args) throws IOException{
		//--------------솔루션 코드를 작성하세요.--------------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
		int[] house = new int[n];
		
		for (int i=0;i<n;i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);
		
	
		//이탐
		int s = 1;
		int e = 1000000001;
		// ttttttfffff 구조
		
		for(int i=0; i<31;i++) {
			int mid = (s+e)/2;
			
			if (bs(house,mid,m)) {
				s = mid;
			} else {
				e = mid;
			}
		
		}
		System.out.println(s);
	
	}

}
