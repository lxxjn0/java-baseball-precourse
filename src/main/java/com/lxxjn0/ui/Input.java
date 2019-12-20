/*
 * @(#)Input.java       0.2 2019.12.20
 *
 * Copyright (c) 2019 lxxjn0.
 */

package com.lxxjn0.ui;

import java.util.Scanner;

/**
 * 프로그램에서 입력과 관련된 모든 기능을 담당하는 클래스(UI 로직).
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 0.2 2019.12.20
 */
public class Input {
    private static Scanner scanner;

    public static String receiveNumberInput() {
        scanner = new Scanner(System.in);

        Output.printRequestNumberInput();
        return scanner.nextLine();
    }

    public static String receiveResumeInput() {
        scanner = new Scanner(System.in);

        Output.printRequestResumeInput();
        return scanner.nextLine();
    }
}
