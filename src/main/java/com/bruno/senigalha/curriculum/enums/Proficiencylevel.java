package com.bruno.senigalha.curriculum.enums;

public enum Proficiencylevel {
    BASICO(1),
    MEDIO(2),
    AVANCADO(3),
    FLUENTE(4);
    
    private final int code;
    
    Proficiencylevel(int code){
        this.code = code;
    }
    
    public int getCode(){
        return code;
    }
    
    public static Proficiencylevel valueOf(int code){
        for(Proficiencylevel value : Proficiencylevel.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid proficiency code!");
    }
}
