/*
 * @(#)Input.java       0.1 2019.12.12
 *
 * Copyright (c) 2019 lxxjn0.
 */

package com.lxxjn0.ui;

import java.util.Scanner;

/**
 * 프로그램에서 입력과 관련된 모든 기능을 담당하는 클래스(UI 로직).
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 0.1 2019.12.12
 */
public class Input {
    /**
     * 사용자로부터 입력을 받아올 scanner 객체.
     */
    private Scanner scanner;

    /**
     * 숫자를 입력하라는 요청에 대한 사용자의 입력을 받는 메소드.
     *
     * @return 사용자로부터 받은 입력을 반환.
     */
    public String receiveNumberInput() {
        scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    /**
     * 게임 재시작 여부를 입력하라는 요청에 대한 사용자의 입력을 받는 메소드.
     *
     * @return 사용자로부터 받은 입력(숫자)을 반환.
     */
    public int receiveRestartInput() {
        scanner = new Scanner(System.in);

        return scanner.nextInt();
    }
}
