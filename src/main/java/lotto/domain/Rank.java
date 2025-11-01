package lotto.domain;

public enum Rank {
    First(6, -1, 2_000_000_000L),
    Second(5, 1,30_000_000L),
    Third(5,0,1_500_000L),
    Fourth(4,-1,50_000L),
    Fifth(3,-1,5_000L);

    private final int hitCount;
    private final int hitBonus;
    private final long reward;

    Rank(int hitCount, int hitBonus, long reward) {
        this.hitCount = hitCount;
        this.hitBonus = hitBonus;
        this.reward = reward;
    }

    public int getHitCount() {
        return hitCount;
    }

    public int getHitBonus() {
        return hitBonus;
    }

    public long getReward() {
        return reward;
    }
}
