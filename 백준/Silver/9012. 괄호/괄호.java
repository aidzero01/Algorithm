import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int roop = Integer.parseInt(br.readLine());
		int left = 0;
		int right = 0;
		int excp = -1;
		
		for(int i=0; i<roop; i++) {
			String tem = br.readLine();
			left= 0;
			right=0;
			excp = -1;
			for(int j=0; j<tem.length();j++) {
				String o = tem.charAt(j)+"";
				if(o.equals("(")) {
					left++;
				}else {
					right++;
				}
				
				if(left<right) {
					excp = 0;
					break;
				}
			}
			
			if(left != right || excp == 0) bw.write("NO\n");
			else bw.write("YES\n");
						
		}
		
		bw.flush();
		
		
	}

}