/*
 * @(#)Baseballs.java       0.1 2019.12.20
 *
 * Copyright (c) 2019 lxxjn0
 */

package com.lxxjn0.domain;

import com.lxxjn0.ui.Output;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Baseballs {
    private static final int VALID_BASEBALLS_SIZE = 3;
    private static final int ZERO_START_INDEX = 0;
    private static final int EXIST_NUMBER = 1;

    private final List<Baseball> baseballs;

    public Baseballs(List<Baseball> baseballs) {
        isValidSize(baseballs);
        isDuplicate(baseballs);

        this.baseballs = baseballs;
    }

    private void isValidSize(List<Baseball> baseballs) {
        if (baseballs.size() != VALID_BASEBALLS_SIZE) {
            throw new IllegalArgumentException(Output.BASEBALLS_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private void isDuplicate(List<Baseball> baseballs) {
        if (baseballs.stream().distinct().count() != VALID_BASEBALLS_SIZE) {
            throw new IllegalArgumentException(Output.BASEBALLS_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    public int countStrike(Baseballs cmpBaseballs) {
        return (int) IntStream.range(ZERO_START_INDEX, VALID_BASEBALLS_SIZE)
                .filter(i -> baseballs.get(i).equals(cmpBaseballs.baseballs.get(i)))
                .count();
    }

    public int countBall(Baseballs cmpBaseballs) {
        return (int) IntStream.range(ZERO_START_INDEX, VALID_BASEBALLS_SIZE)
                .filter(i -> {
                    return !baseballs.get(i).equals(cmpBaseballs.baseballs.get(i)) &&
                            EXIST_NUMBER == cmpBaseballs.baseballs.stream()
                                    .filter(baseball -> baseball.equals(this.baseballs.get(i)))
                                    .count();
                })
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baseballs baseballs = (Baseballs) o;
        return VALID_BASEBALLS_SIZE ==
                IntStream.range(ZERO_START_INDEX, VALID_BASEBALLS_SIZE)
                        .filter(i -> this.baseballs.get(i).equals(baseballs.baseballs.get(i)))
                        .count();
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseballs);
    }
}
