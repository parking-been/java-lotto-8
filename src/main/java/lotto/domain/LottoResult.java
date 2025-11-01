package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<Rank,Integer> score = new HashMap<>();

    public LottoResult() {
        for (Rank r : Rank.values()){
            score.put(r,0);
        }
    }

    public LottoResult(Map<Rank,Integer> nscore){
        this.score = nscore;
    }

    public Map<Rank, Integer> getScore() {
        return score;
    }

    public void updateScore(int correctCountOfNumbers, int correctCountOfBonus){
        Rank rank = checkRankOfResult(correctCountOfNumbers, correctCountOfBonus);
        if (rank!=null){
            score.put(rank,score.get(rank)+1);
        }
    }

    public Rank checkRankOfResult(int correctCountOfNumbers, int correctCountOfBonus){
        for (Rank r : Rank.values()){
            if (r.getHitCount() != correctCountOfNumbers){
                continue;
            }
            if (r.getHitBonus()==-1 || (r.getHitBonus()==correctCountOfBonus)){
                return r;
            }
        }
        return null;
    }

    public long getTotalReword(){
        long sum = 0;
        for (Rank r : Rank.values()){
            sum+=score.get(r)*r.getReward();
        }
        return sum;
    }
}
