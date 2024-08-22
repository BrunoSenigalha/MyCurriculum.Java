package com.bruno.senigalha.curriculum.enums;

public enum FormationType {
    FUNDAMENTAL(1),
    MEDIO(2),
    TECNICO(3),
    SUPERIOR(4);

    private final int code;

    FormationType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static FormationType valueOf(int code) {
        for (FormationType value : FormationType.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid formation type code");
    }
}
