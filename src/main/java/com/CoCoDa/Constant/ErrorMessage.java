package com.CoCoDa.Constant;

public enum ErrorMessage {
    // Board 관련
    BOARD_NOT_FOUND("Board not found"),
    BOARD_CANNOT_BE_NULL("Board cannot be null"),

    // Reply 관련
    REPLY_CANNOT_BE_NULL("Reply cannot be null"),

    // User 관련
    USER_OR_USERID_CANNOT_BE_NULL("User or userid cannot be null"),
    USER_NOT_FOUND("User Not Found"),
    USER_EXIST("User Exist"),
    USERID_CANNOT_BE_NULL("Userid cannot be null"),
    USER_CANNOT_BE_NULL("User cannot be null"),

    // Index/Sales Division 관련
    SALES_DIVISON_L_CD_CANNOT_BE_NULL("sales_divison_l_cd cannot be null"),
    SALES_DIVISION_S_CD_CANNOT_BE_NULL("sales_division_s_cd cannot be null"),
    SALES_DIVISON_S_CD_CANNOT_BE_NULL("sales_divison_s_cd cannot be null"),

    // Total/Sigungu 관련
    SIGUNGU_ARR_CANNOT_BE_NULL_OR_EMPTY("sigungu_arr cannot be null or empty"),
    SIGUNGU_CD_CANNOT_BE_NULL("sigungu_cd cannot be null"),
    SIGUNGU_CD_AND_SALES_DIVISON_S_CD_CANNOT_BE_NULL("sigungu_cd and sales_divison_s_cd cannot be null"),

    // VO 관련
    UNIMPLEMENTED_METHOD_GET_CONTENT("Unimplemented method 'getContent'");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
