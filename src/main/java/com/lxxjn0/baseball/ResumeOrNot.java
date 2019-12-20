/*
 * @(#)ResumeOrNot.java     0.1 2019.12.20
 *
 * Copyright (c) 2019 lxxjn0
 */

package com.lxxjn0.baseball;

import com.lxxjn0.ui.Output;

import java.util.Objects;

public class ResumeOrNot {
    private static final int VALID_OPINION_INPUT_SIZE = 1;
    private static final int RESUME_REPLY = 1;
    private static final int STOP_REPLY = 2;
    private static final char ZERO_CHAR = '0';

    private final int opinion;

    public ResumeOrNot(String userReply) {
        isValidLength(userReply);

        this.opinion = userReply.charAt(0) - ZERO_CHAR;
        isValidOpinionRange(opinion);
    }

    private void isNullValue(String userReply) {
        if (Objects.isNull(userReply)) {
            throw new IllegalArgumentException(Output.NULL_EXCEPTION_MESSAGE);
        }
    }

    private void isValidLength(String userReply) {
        if (userReply.length() != VALID_OPINION_INPUT_SIZE) {
            throw new IllegalArgumentException(Output.RESUME_INPUT_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private void isValidOpinionRange(int opinion) {
        if ((opinion != RESUME_REPLY) && (opinion != STOP_REPLY)) {
            throw new IllegalArgumentException(Output.RESUME_INPUT_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    public boolean isResume() {
        return (opinion == RESUME_REPLY);
    }
}
