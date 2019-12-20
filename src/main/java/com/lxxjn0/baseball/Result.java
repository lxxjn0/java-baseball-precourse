/*
 * @(#)Result.java        1.0 2019.12.20
 *
 * Copyright (c) 2019 lxxjn0.
 */

package com.lxxjn0.baseball;

import com.lxxjn0.domain.Baseballs;
import com.lxxjn0.ui.Output;

/**
 * 스트라이크와 볼의 개수를 확인하고 낫싱 여부를 판단하는 클래스.
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 1.0 2019.12.20
 */
public class Result {
    private static final int COUNT_ZERO = 0;
    private int strikeNumber;
    private int ballNumber;

    public Result(Baseballs computerBaseballs, Baseballs userBaseballs) {
        strikeNumber = computerBaseballs.countStrike(userBaseballs);
        ballNumber = computerBaseballs.countBall(userBaseballs);
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();

        if (strikeNumber == COUNT_ZERO && ballNumber == COUNT_ZERO) {
            sb.append(Output.RESULT_NOTHING_MESSAGE);
        }
        if (strikeNumber != COUNT_ZERO) {
            sb.append(strikeNumber).append(Output.RESULT_STRIKE_MESSAGE);
        }
        if (ballNumber != COUNT_ZERO) {
            sb.append(ballNumber).append(Output.RESULT_BALL_MESSAGE);
        }
        return sb.toString();
    }
}
