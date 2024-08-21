package com.bruno.senigalha.curriculum.enums;

public enum Gender {
    MASCULINO(1),
    FEMININO(2),
    OUTROS(3),
    PREFIRO_NAO_INFORMAR(4);

    private final int code;

    Gender(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Gender valueOf(int code) {
        for (Gender value : Gender.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid gender code!");
    }
}
