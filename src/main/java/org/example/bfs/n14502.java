package org.example.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n14502 {
    static int N;
    static int M;
    static int[][] map;
    static int safeZone = 0;
    static int result = 0;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    static int installWall(int wallCnt) {
        if (wallCnt == 0) {
            safeZone=0;
            int[][] tmpMap = new int[N][M];
            for (int i = 0; i < N; i++) {
               System.arraycopy(map[i], 0, tmpMap[i], 0, M);
            }
            spreadVirus(tmpMap);

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(tmpMap[i][j] == 0){
                        safeZone++;
                    }
                }
            }
            result = Math.max(result, safeZone);
            return result;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    installWall(wallCnt - 1);
                    map[i][j] = 0;
                }
            }
        }
        return result;
    }

    static void spreadVirus(int[][] tmpMap) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmpMap[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (tmpMap[nx][ny] == 0) {
                        tmpMap[nx][ny] = 2;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result=installWall(3);
        System.out.println(result);
    }
}
