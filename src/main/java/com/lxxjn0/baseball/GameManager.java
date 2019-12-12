/*
 * @(#)GameManager.java     0.1 2019.12.13
 *
 * Copyright (c) 2019 lxxjn0.
 */

package com.lxxjn0.baseball;

import com.lxxjn0.ui.Input;
import com.lxxjn0.ui.Output;

import java.util.InputMismatchException;

/**
 * 게임의 시작과 종료, 재시작을 관리하는 전체 게임의 관리 클래스.
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 0.1 2019.12.13
 */
public class GameManager {
    /**
     * 게임을 다시 시작하는 입력을 확인하기 위한 문자열 상수
     */
    private static final int RESTART = 1;

    /**
     * 사용자로부터 입력받는 작업을 처리하기 위한 Input 인스턴스.
     */
    private Input in = new Input();

    /**
     * 출력하는 작업을 처리하기 위한 Output 인스턴스.
     */
    private Output out = new Output();

    /**
     * 숫자 야구 게임을 시작시키고, 재시작 여부를 확인 후 동작하는 매소드.
     */
    public void run() {
        do {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.playBaseball();
        } while (isRestartOpinion());
    }

    /**
     * 사용자로부터 재시작 여부를 입력받아 유효한 입력임을 확인하고 입력을 반환하는 메소드.
     *
     * @return 유효함이 검증된 사용자의 입력을 반환.
     */
    private int receiveRestartOpinion() {
        int opinion;

        try {
            out.printRequestRestartInput();
            opinion = in.receiveRestartInput();

            Validator validator = new Validator(opinion);
            validator.isValidRestartInput();
        } catch (InputMismatchException e) {
            out.printInputError();
            return receiveRestartOpinion();
        }
        return opinion;
    }
    /**
     * 사용자로부터 받은 입력으로 게임을 다시 시작 또는 종료 여부를 결정하는 메서드.
     *
     * @return 게임을 다시 시작할 경우 true 반환.
     */
    private boolean isRestartOpinion() {
        return (receiveRestartOpinion() == RESTART);
    }
}
