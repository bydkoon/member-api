package com.asnisum.api.error.exception;

public class DuplicatedMemberIdException extends DuplicatedException {

    public DuplicatedMemberIdException() {
    }

    public DuplicatedMemberIdException(String message) {
        super(message);
    }

    public DuplicatedMemberIdException(String message, Throwable cause) {
        super(message, cause);
    }


}
