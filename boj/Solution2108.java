package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution2108 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] positiveArr = new int[4001];
        int[] negativeArr = new int[4001];

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        Arrays.sort(arr);
        long avg = Math.round(Arrays.stream(arr).average().getAsDouble());
        int centerNumber = arr[n / 2];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                positiveArr[arr[i]]++;
            } else {
                negativeArr[-arr[i]]++;
            }
        }

        List<Integer> modeList = new ArrayList<>();

        int count = positiveArr[0];
        for (int i = 0; i < positiveArr.length; i++) {
            if (count < positiveArr[i]) {
                count = positiveArr[i];
            }
        }

        for (int i = 0; i < negativeArr.length; i++) {
            if (count < negativeArr[i]) {
                count = negativeArr[i];
            }
        }
        for (int i = 0; i < positiveArr.length; i++) {
            if (positiveArr[i] == count) {
                modeList.add(i);
            }
        }
        for (int i = 0; i < negativeArr.length; i++) {
            if (negativeArr[i] == count) {
                modeList.add(-i);
            }
        }
        Collections.sort(modeList);

        int range = Arrays.stream(arr).max().getAsInt() - Arrays.stream(arr).min().getAsInt();

        bw.write(avg + "\n");
        bw.write(centerNumber + "\n");
        if (modeList.size() > 1) {
            bw.write(modeList.get(1) + "\n");
        } else {
            bw.write(modeList.get(0) + "\n");
        }
        bw.write(range + "\n");

        bw.flush();
        bw.close();
    }
}
