/*
 * @(#)Computer.java        0.8 2019.12.20
 *
 * Copyright (c) 2019 lxxjn0.
 */

package com.lxxjn0.baseball;

import com.lxxjn0.domain.BaseballFactory;
import com.lxxjn0.domain.Baseballs;

/**
 * 1부터 9까지 서로 다른 수로 이루어진 3자리 수를 생성하는 클래스.
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 0.8 2019.12.20
 */
public class Computer {
    public Baseballs generateRandomBaseballs() {
        return BaseballFactory.createRandomBaseballs();
    }
}
