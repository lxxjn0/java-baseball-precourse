/*
 * @(#)GameManager.java     0.2 2019.12.20
 *
 * Copyright (c) 2019 lxxjn0.
 */

package com.lxxjn0.baseball;

import com.lxxjn0.ui.Input;
import com.lxxjn0.ui.Output;

/**
 * 게임의 시작과 종료, 재시작을 관리하는 전체 게임의 관리 클래스.
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 0.2 2019.12.20
 */
public class GameManager {
    public void run() {
        do {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.playBaseball();
        } while (isResumeOpinion());
    }

    private boolean isResumeOpinion() {
        try {
            ResumeOrNot opinion = new ResumeOrNot(Input.receiveResumeInput());
            return opinion.isResume();
        } catch (IllegalArgumentException e) {
            Output.printExceptionMessage(e.getMessage());
            return isResumeOpinion();
        }
    }
}
