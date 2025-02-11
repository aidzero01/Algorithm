import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int roop = Integer.parseInt(br.readLine());
		
		//여기에 각 시험장마다 응시생들 수가 담겨있음
		String participants = br.readLine();
		
		st = new StringTokenizer(br.readLine());
		int inspector = Integer.parseInt(st.nextToken());
		int subInspector = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(participants);
		
		Long count = 0L;
		
		for(int i=0; i<roop; i++) {
			int tem = Integer.parseInt(st.nextToken());
			
			tem -= inspector;
			count++;
			
			if(tem>0) {
				count += tem/subInspector;
				if(tem%subInspector != 0) {
					count++;
				}
				
			}
			
		}
		
		System.out.println(count);
		
	}

}
