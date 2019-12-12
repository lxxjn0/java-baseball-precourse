/*
 * @(#)Computer.java        0.7 2019.12.13
 *
 * Copyright (c) 2019 lxxjn0.
 */

package com.lxxjn0.baseball;

import java.util.ArrayList;
import java.util.Random;

/**
 * 1부터 9까지 서로 다른 수로 이루어진 3자리 수를 생성하는 클래스.
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 0.7 2019.12.13
 */
public class Computer {
    /**
     * 생성해야 하는 수의 길이에 해당하는 상수
     */
    private static final int NUM_LEN_TO_GENERATE = 3;

    /**
     * 각 자리에 생성될 숫자 범위의 하한 상수
     */
    private static final int MIN_NUM = 1;

    /**
     * 각 자리에 생성될 숫자 범위의 상한 상수
     */
    private static final int MAX_NUM = 9;

    /**
     * 1부터 9까지 서로 다른 수로 이루어진 3자리 수를 생성하는 메서드.
     */
    public ArrayList<Integer> generateRandomNumber() {
        ArrayList<Integer>generatedNumber = new ArrayList<>();

        while (generatedNumber.size() < NUM_LEN_TO_GENERATE) {
            int tmp = new Random().nextInt(MAX_NUM) + MIN_NUM;
            if (!generatedNumber.contains(tmp)) {
                generatedNumber.add(tmp);
            }
        }
        return  generatedNumber;
    }
}
