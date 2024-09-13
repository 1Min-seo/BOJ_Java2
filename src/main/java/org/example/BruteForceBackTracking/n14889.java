package org.example.BruteForceBackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n14889 {
    static int N;
    static int [][]arr;
    static boolean[] visited;
    static int result=Integer.MAX_VALUE;

    public static void dfs(int idx, int cnt){
        if(cnt==(N/2)){
            int sTeam=0;
            int lTeam=0;

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(visited[i] && visited[j]){
                        sTeam+=arr[i][j];
                    }
                    if(!visited[i] && !visited[j]){
                        lTeam+=arr[i][j];
                    }
                }
            }

            result=Math.min(result, Math.abs(sTeam-lTeam));
        }

        for(int i=idx;i<N;i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(i+1,cnt+1);
                visited[i]=false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        arr=new int[N][N];
        visited=new boolean[N];

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        System.out.println(result);
    }
}
