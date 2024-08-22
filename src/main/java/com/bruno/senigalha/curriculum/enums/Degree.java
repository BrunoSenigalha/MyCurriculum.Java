package com.bruno.senigalha.curriculum.enums;

public enum Degree {
    GRADUACAO(1),
    TECNOLOGO(2),
    POS_GRADUACAO(3),
    MESTRADO(4),
    DOUTORADO(5);

    private final int code;

    Degree(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Degree valueOf(int code) {
        for (Degree value : Degree.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid degree code!");
    }
}
