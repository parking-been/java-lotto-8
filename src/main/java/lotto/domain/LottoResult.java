package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {
    private static final int RANK_COUNT = 6;
    private int[] score = new int[RANK_COUNT];
    private static final int[][] RANKING_POLICYS = {
            {6,-1}, //1등
            {5,1},  //2등
            {5,0},  //3등
            {4,-1}, //4등
            {3,-1} //5등
    };
    private static final int[] REWORD_POLICYS = {
            2000000000,
            30000000,
            1500000,
            50000,
            5000
    };

    public void updateScore(int correctCountOfNumbers, int correctCountOfBonus){
        for (int i=0;i<RANK_COUNT;i++){
            if (RANKING_POLICYS[i][0]!=correctCountOfNumbers){
                continue;
            }
            if (RANKING_POLICYS[i][1]==-1 || (RANKING_POLICYS[i][1]==correctCountOfBonus)){
                score[i]+=1;
                return;
            }
        }
    }

    public List<Integer> getScore() {
        return Arrays.stream(score)
                .boxed()
                .collect(Collectors.toList());
    }

    public int getTotalReword(){
        int sum = 0;
        for(int i=0;i<RANK_COUNT;i++){
            sum +=score[i]*REWORD_POLICYS[i];
        }
        return sum;
    }
}
