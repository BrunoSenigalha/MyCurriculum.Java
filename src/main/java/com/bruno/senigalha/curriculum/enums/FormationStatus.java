package com.bruno.senigalha.curriculum.enums;

public enum FormationStatus {
    COMPLETO(1),
    EM_ANDAMENTO(2),
    INCOMPLETO(3);

    private final int code;

    FormationStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static FormationStatus valueOf(int code) {
        for (FormationStatus value : FormationStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid formation status code");
    }
}
