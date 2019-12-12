/*
 * @(#)Output.java      0.1 2019.12.12
 *
 * Copyright (c) 2019 lxxjn0.
 */

package com.lxxjn0.ui;

/**
 * 프로그램에서 출력과 관련된 모든 기능을 담당하는 클래스(UI 로직).
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 0.1 2019.12.12
 */
public class Output {
    /**
     * 스트라이크와 볼의 개수가 0개인지를 확인하기 위한 상수.
     */
    private static final int COUNT_ZERO = 0;

    /**
     * 사용자로부터 세자리 수의 입력을 요청할 때 출력할 메시지 상수.
     */
    private static final String REQUIRE_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    /**
     * 사용자로부터 받은 입력이 유효하지 않을 경우 출력할 메시지 상수.
     */
    private static final String INPUT_ERROR_MESSAGE = "잘못된 입력입니다. 다시 확인하고 입력해주세요.";

    /**
     * 다시 게임을 시작할 것인지 게임을 종료할 것인지 여부를 출력할 메시지 상수.
     */
    private static final String REQUIRE_RESTART_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    /**
     * 정답을 맞추었을 때 출력하는 메시지 상수.
     */
    private static final String CORRECT_ANSWER_AND_EXIT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료.";

    /**
     * 스트라이크를 출력할 때 사용하는 문자열 상수.
     */
    private static final String STRIKE_MESSAGE = " 스트라이크";

    /**
     * 볼을 출력할 때 사용하는 문자열 상수.
     */
    private static final String BALL_MESSAGE = " 볼";

    /**
     * 낫싱을 출력할 때 사용하는 문자열 상수.
     */
    private static final String NOTHING_MESSAGE = "낫싱";

    /**
     * 세자리 수 입력 요청 메시지를 출력하는 메소드.
     */
    public void printRequestNumberInput() {
        System.out.println(REQUIRE_NUMBER_INPUT_MESSAGE);
    }

    /**
     * 잘못된 입력임을 알려주는 메시지를 출력하는 메소드.
     */
    public void printInputError() {
        System.out.println(INPUT_ERROR_MESSAGE);
    }

    /**
     * 개임 재시작 여부 입력 요청 메시지를 출력하는 메소드.
     */
    public void printRequestRestartInput() {
        System.out.println(REQUIRE_RESTART_INPUT_MESSAGE);
    }

    /**
     * 정답을 맞추었다는 메시지를 출력하는 메소드.
     */
    public void printCorrectAnswer() {
        System.out.println(CORRECT_ANSWER_AND_EXIT_MESSAGE);
    }

    /**
     * 결과가 낫싱임을 출력하는 메소드.
     */
    public void printNothing() {
        System.out.println(NOTHING_MESSAGE);
    }

    public void printStrikeAndBall(int strikeNumber, int ballNumber) {
        StringBuilder result = new StringBuilder();

        if (strikeNumber != COUNT_ZERO) {
            result.append(strikeNumber);
            result.append(STRIKE_MESSAGE);
        }
        if (ballNumber != COUNT_ZERO) {
            result.append(ballNumber);
            result.append(BALL_MESSAGE);
        }
        System.out.println(result);
    }
}
