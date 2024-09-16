package org.example.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n2178 {
    static int N;
    static int M;
    static int [][]map;
    static boolean [][]visit;
    static int[] dx ={-1,0,0,1};
    static int[] dy ={0,-1,1,0};

    public static void bfs(int x, int y) {
        Queue<int []> queue=new LinkedList<>();
        queue.add(new int [] {x,y});
        visit[x][y]=true;

        while(!queue.isEmpty()){
            int []cur=queue.poll();
            int curX=cur[0];
            int curY=cur[1];

            for(int i=0; i<4; i++){
                int nx=curX+dx[i];
                int ny=curY+dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    if(map[nx][ny]==1 && !visit[nx][ny]){
                        queue.offer(new int [] {nx,ny});
                        visit[nx][ny]=true;
                        map[nx][ny]=map[curX][curY]+1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        visit=new boolean[N][M];

        for(int i=0;i<N;i++){
            String tmp=br.readLine();
            for(int j=0;j<M;j++){
                map[i][j]=tmp.charAt(j)-'0';
            }
        }

        bfs(0,0);
        System.out.println(map[N-1][M-1]);
    }
}
