package org.example.BruteForceBackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n2798 {
    static int N;
    static int M;
    static int []a;
    static int []arr;
    static boolean visit[];
    static int cnt=0;
    static int sum=0;
    static int result=0;

    public static void dfs(int cnt){
        if(cnt==3){
            if(sum<=M){
                result=Math.max(sum,result);
            }
            return;
        }
        for(int i=0;i<N;i++){
            if(!visit[i]){
                visit[i]=true;
                sum+=a[i];
                dfs(cnt+1);
                sum-=a[i];
                visit[i]=false;
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        a=new int[N];
        arr=new int[N];
        visit=new boolean[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(result);
    }
}
