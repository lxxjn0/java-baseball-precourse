/*
 * @(#)BaseballGame.java        1.1 2019.12.20
 *
 * Copyright (c) 2019 lxxjn0.
 */

package com.lxxjn0.baseball;

import com.lxxjn0.domain.Baseballs;
import com.lxxjn0.domain.BaseballFactory;
import com.lxxjn0.ui.Input;
import com.lxxjn0.ui.Output;

/**
 * 게임의 전체적인 진행을 담당. 컴퓨터와 사용자로부터 3자리 숫자를 저장하고 이를 통해 스트라이크와 볼,
 * 그리고 낫싱 여부를 구해서 출력. 위 결과를 통해 답과 일치 여부를 판단하고, 정답일 경우 게임을 종료,
 * 사용자로부터 재진행 여부를 입력을 받아서 결정하는 클래스.
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 1.1 2019.12.20
 */
public class BaseballGame {
    private Computer computer = new Computer();
    private Baseballs userBaseballs;
    private Baseballs computerBaseballs;

    public void playBaseball() {
        computerBaseballs = computer.generateRandomBaseballs();

        do {
            playBaseballOnce();
        } while(!isCorrectAnswer());
        Output.printCorrectAnswer();
    }

    private void playBaseballOnce() {
        userBaseballs = receiveUserBaseballs();
        Result result = new Result(computerBaseballs, userBaseballs);

        Output.printBaseballGaemResult(result.getResult());
    }

    private Baseballs receiveUserBaseballs() {
        try {
            return BaseballFactory.createBaseballs(Input.receiveNumberInput());
        } catch (IllegalArgumentException e) {
            Output.printExceptionMessage(e.getMessage());
            return receiveUserBaseballs();
        }
    }

    private boolean isCorrectAnswer() {
        return userBaseballs.equals(computerBaseballs);
    }
}
