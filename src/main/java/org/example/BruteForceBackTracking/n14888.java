package org.example.BruteForceBackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n14888 {
    static int N;
    static int[] num;
    static int[] operation = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void dfs(int value, int idx) {
        if(idx==N){
            max=Math.max(max,value);
            min=Math.min(min,value);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operation[i] > 0) {
                operation[i]--;

                switch (i) {
                    case 0:
                        dfs(value+num[idx], idx+1);
                        break;

                    case 1:
                        dfs(value-num[idx], idx+1);
                        break;
                    case 2:
                        dfs(value*num[idx], idx+1);
                        break;
                    case 3:
                        dfs(value/num[idx], idx+1);
                        break;
                }
                operation[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operation[i] = Integer.parseInt(st.nextToken());
        }

        dfs(num[0],1);
        System.out.println(max);
        System.out.println(min);
    }
}
