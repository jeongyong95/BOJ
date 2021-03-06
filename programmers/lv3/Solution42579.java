package programmers.lv3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution42579 {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answerList = new ArrayList<>();

        Map<String, Integer> sumMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            sumMap.put(genres[i], sumMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Integer> sumList = new ArrayList<>(sumMap.values());
        Collections.sort(sumList, Collections.reverseOrder());
        String[] genreRankArr = new String[sumMap.keySet().size()];

        for (int i = 0, size = sumList.size(); i < size; i++) {
            for (String string : sumMap.keySet()) {
                if (sumMap.get(string) == sumList.get(i)) {
                    genreRankArr[i] = string;
                    break;
                }
            }
        }

        // 장르 우선순위 작성완료
        for (int i = 0; i < genreRankArr.length; i++) {
            String genre = genreRankArr[i];
            int count = 2;
            while (count-- > 0 && sumMap.get(genre) > 0) {
                int target = -1;
                int max = -1;
                for (int j = 0; j < genres.length; j++) {
                    if (genre.equals(genres[j]) && max < plays[j]) {
                        target = j;
                        max = plays[j];
                    }
                }
                answerList.add(target);
                genres[target] = "#";
                sumMap.put(genre, sumMap.get(genre) - max);
            }

        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}