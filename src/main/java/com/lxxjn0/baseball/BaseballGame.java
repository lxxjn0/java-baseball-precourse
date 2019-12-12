/*
 * @(#)BaseballGame.java        0.9 2019.12.13
 *
 * Copyright (c) 2019 lxxjn0.
 */

package com.lxxjn0.baseball;

import com.lxxjn0.ui.Input;
import com.lxxjn0.ui.Output;

import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * 게임의 전체적인 진행을 담당. 컴퓨터와 사용자로부터 3자리 숫자를 저장하고 이를 통해 스트라이크와 볼,
 * 그리고 낫싱 여부를 구해서 출력. 위 결과를 통해 답과 일치 여부를 판단하고, 정답일 경우 게임을 종료,
 * 사용자로부터 재진행 여부를 입력을 받아서 결정하는 클래스.
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 0.9 2019.12.13
 */
public class BaseballGame {
    /**
     * 스트라이크 또는 볼이 0개인 경우를 판단하기 위한 상수
     */
    private static final int COUNT_ZERO = 0;

    /**
     * 사용자가 3개의 숫자를 맞췄는지 확인하기 위한 상수
     */
    private static final int CORRECT_ANSWER = 3;

    /**
     * 사용자로부터 입력받는 작업을 처리하기 위한 Input 인스턴스.
     */
    private Input in = new Input();

    /**
     * 출력하는 작업을 처리하기 위한 Output 인스턴스.
     */
    private Output out = new Output();

    /**
     * 게임 시작 시 3자리 수를 생성할 Computer 클래스 객체
     */
    private Computer computer = new Computer();

    /**
     * 생성된 수와 사용자가 입력한 수를 통해 판정을 내리는 Referee 클래스 객체
     */
    private Referee referee;

    /**
     * 컴퓨터가 생성한 3자리 수를 저장할 ArrayList
     */
    private ArrayList<Integer> generatedNumber;

    /**
     * 사용자가 입력한 3자리 수를 저장할 ArrayList
     */
    private ArrayList<Integer> enteredNumber;

    /**
     * 정답을 맞출 때까지 게임을 진행하는 메소드.
     */
    public void playBaseball() {
        generatedNumber = computer.generateRandomNumber();

        do {
            playBaseballOnce();
        } while(!isCorrectAnswer());
    }

    /**
     * 사용자로부터 입력을 받아서 스트라이크, 볼 또는 낫싱을 출력하는 과정까지 진행하는 메소드.
     */
    private void playBaseballOnce() {
        String userInput = receiveInput();

        toIntegerArrayList(userInput);
        referee = new Referee(generatedNumber, enteredNumber);
        printResult();
    }

    /**
     * 사용자로부터 입력을 받아와서 유효한 입력일 경우 해당 입력을 반환하는 메소드.
     *
     * @return 유효성이 검증된 사용자의 입력을 반환.
     */
    private String receiveInput() {
        String userInput;

        try {
            out.printRequestNumberInput();
            userInput = in.receiveNumberInput();

            Validator validator = new Validator(userInput);
            validator.isValidInput();
        } catch (InputMismatchException e) {
            out.printInputError();
            return receiveInput();
        }
        return userInput;
    }

    /**
     * 사용자의 입력을 Integer ArrayList로 변환해주는 메서드.
     */
    private void toIntegerArrayList(String userInput) {
        enteredNumber = new ArrayList<>();

        for (int i = 0; i < userInput.length(); i++) {
            enteredNumber.add(userInput.charAt(i) - '0');
        }
    }

    /**
     * 낫싱이면 낫싱을, 낫싱이 아니면 스트라이크와 볼을 출력하는 메소드.
     */
    private void printResult() {
        if (referee.judgeNothing()) {
            out.printNothing();
            return;
        }
        out.printStrikeAndBall(referee.getStrikeNumber(), referee.getBallNumber());
    }

    /**
     * 사용자가 입력한 3자리 수가 정답(생성된 수)과 일치하는지를 스트라이크 개수로 판단하는 메서드.
     *
     * @return 사용자가 입력한 3자리 수가 모두 일치한다면 true 반환.
     */
    private boolean isCorrectAnswer() {
        if (referee.getStrikeNumber() == CORRECT_ANSWER) {
            out.printCorrectAnswer();
            return true;
        }
        return false;
    }
}
