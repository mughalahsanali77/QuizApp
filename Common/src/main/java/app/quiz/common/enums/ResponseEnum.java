package app.quiz.common.enums;

import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;

public enum ResponseEnum {
    SUCCESS(0,"SUCCESS"),
    FAILURE(1,"FAILURE");


    private static final ResponseEnum[] VALUES;
    static {
        VALUES=values();
    }
    private final String reason;
    private int value;
    ResponseEnum(int value,String reason){
        this.value=value;
        this.reason=reason;
    }
    ResponseEnum(Object value,String reason){
        if (value instanceof Integer){
            this.value=(int) value;
        }
        this.reason=reason;
    }



    
    public static ResponseEnum valueOf(int value){
        ResponseEnum responseEnum=resolve(value);
        if (ObjectUtils.isEmpty(responseEnum)){
            throw new IllegalArgumentException("No matching constant for["+value+"]");
        }
        return responseEnum;
    }
    @Nullable
    public static ResponseEnum resolve(int value){
        for (ResponseEnum responseEnum:VALUES){
            if (responseEnum.value==value){
                return responseEnum;
            }
        }
        return null;
    }

    public String getReason() {
        return reason;
    }

    public int getValue() {
        return value;
    }
}
