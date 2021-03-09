package programmers.lv2;

public class Solution49993 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] skillArr = skill.split("");
        for (int i = 0; i < skill_trees.length; i++) {
            int index = 0;
            boolean possible = true;
            String[] tree = skill_trees[i].split("");
            for (int j = 0; j < tree.length; j++) {
                if (skill.contains(tree[j])) {
                    if (!tree[j].equals(skillArr[index])) {
                        possible = false;
                        break;
                    }
                    index++;
                }
            }
            if (possible) {
                answer++;
            }
        }
        return answer;
    }
}