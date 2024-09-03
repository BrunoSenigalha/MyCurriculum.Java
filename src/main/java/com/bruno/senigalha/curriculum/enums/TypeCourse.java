package com.bruno.senigalha.curriculum.enums;

import java.lang.reflect.Type;

public enum TypeCourse {

    CURSO(1),
    CERTIFICACAO(2);

    private int code;

    TypeCourse(int code) {
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static TypeCourse valueOf(int code){
        for(TypeCourse value : TypeCourse.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid type course code");
    }
}
