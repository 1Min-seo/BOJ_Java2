package org.example.BruteForceBackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n10819 {
    static int n;
    static int []A;
    static int []arr;
    static boolean []visit;
    static int sum=0;
    static int result=0;

    public static void dfs(int cnt){
        if(cnt == n){
            sum=0;
            for(int i=0;i<n-1;i++){
                sum+=Math.abs(arr[i]-arr[i+1]);
            }
            result=Math.max(sum,result);
            return;
        }

        for(int i=0;i<n;i++){
            if(!visit[i]){
                arr[cnt]=A[i];
                visit[i]=true;
                dfs(cnt+1);
                visit[i]=false;
            }
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        A=new int[n];
        arr=new int[n];
        visit=new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            A[i]=Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(result);
    }
}
