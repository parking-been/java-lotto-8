package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomValueGenerator {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND =45;
    private static final int COUNT = 6;

    public static List<Integer> getRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(LOWER_BOUND, UPPER_BOUND, COUNT);
    }
}
