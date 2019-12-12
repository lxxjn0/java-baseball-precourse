/*
 * @(#)Validator.java        0.7 2019.12.13
 *
 * Copyright (c) 2019 lxxjn0.
 */

package com.lxxjn0.baseball;

import java.util.InputMismatchException;

/**
 * 사용자로부터 3자리 수를 입력받는 클래스.
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 0.7 2019.12.13
 */
public class Validator {
    /**
     * 입력해야 하는 수의 길이에 해당하는 상수
     */
    private static final int NUM_LEN_TO_ENTER = 3;

    /**
     * 각 자리에 입력될 숫자 범위의 하한 문자 상수
     */
    private static final char MIN_NUM = '1';

    /**
     * 각 자리에 입력될 숫자 범위의 상한 문자 상수
     */
    private static final char MAX_NUM = '9';

    /**
     * 게임을 다시 시작하는 입력을 확인하기 위한 int 상수
     */
    private static final int RESTART = 1;

    /**
     * 게임을 종료하는 입력을 확인하기 위한 int 상수
     */
    private static final int STOP = 2;

    /**
     * 사용자로부터 입력을 받아 저장해 둘 변수
     */
    private String userInput;

    /**
     * 사용자로부터 재시작 여부를 입력을 받아 저장해 둘 변수
     */
    private int opinion;

    /**
     * 사용자의 입력을 매개변수로 받아와서 생성하는 String 매개변수 생성자.
     *
     * @param userInput 사용자로부터 입력받은 문자열.
     */
    public Validator(String userInput) {
        this.userInput = userInput;
    }

    /**
     * 사용자의 입력을 매개변수로 받아와서 생성하는 int 매개변수 생성자.
     *
     * @param opinion 사용자로부터 입력받은 정수.
     */
    public Validator(int opinion) {
        this.opinion = opinion;
    }

    /**
     * 사용자로부터 받은 입력의 길이가 3인지, 1부터 9까지의 숫자가 아닌 입력이 존재하는지, 또는 각 자리에 중복되는 수가 존재하는 지 판단하고
     * 유효하지 않은 입력일 경우 예외를 발생시키는 메소드.
     */
    public void isValidInput() throws InputMismatchException {
        if (!(isValidLength() && isValidNumber() && isNoDuplication())) {
            throw new InputMismatchException();
        }
    }

    /**
     * 사용자의 입력의 길이가 3인지 여부를 확인하는 메서드.
     *
     * @return 사용자의 입력의 길이가 3인 경우 true 반환.
     */
    private boolean isValidLength() {
        return (userInput.length() == NUM_LEN_TO_ENTER);
    }

    /**
     * 사용자의 입력의 각 자리가 1 ~ 9까지의 숫자로 이루어져 있는지 확인하는 메서드.
     *
     * @return 각 자리가 1부터 9까지 범위 내의 숫자일 경우 true 반환.
     */
    private boolean isValidNumber() {
        for (int i = 0; i < userInput.length(); i++) {
            char c = userInput.charAt(i);
            if ((c < MIN_NUM) || (c > MAX_NUM)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 사용자의 입력의 각 자리에 중복된 수가 존재하는지 확인하는 메서드.
     *
     * @return 각 자리가 서로 다른 수일 경우 true 반환.
     */
    private boolean isNoDuplication() {
        for (int i = 0; i < userInput.length(); i++) {
            if (isDuplicatePosition(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 해당 position 위치의 문자가 문자열의 다른 위치에 존재하는지(중복되는지) 확인하는 메서드.
     *
     * @param position 중복 여부를 확인하고 싶은 자리.
     * @return 해당 position이 아닌 자리에 동일한 문자가 존재 시 true 반환.
     */
    private boolean isDuplicatePosition(int position) {
        for (int i = 0; i < userInput.length(); i++) {
            if ((userInput.charAt(position) == userInput.charAt(i))
                    && (i != position)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 사용자의 입력이 1또는 2가 아닌 다른 유효하지 않은 입력일 경우 예외를 발생시키는 메소드.
     */
    public void isValidRestartInput() throws InputMismatchException {
        if (!((opinion == RESTART) || (opinion == STOP))) {
            throw new InputMismatchException();
        }
    }
}
