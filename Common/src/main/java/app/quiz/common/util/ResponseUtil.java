package app.quiz.common.util;

import app.quiz.common.dtos.ResponseDto;
import app.quiz.common.enums.ResponseEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    public static ResponseEntity<Object> returnResponse(RuntimeException ex){
        ResponseDto responseDto=new ResponseDto();
        responseDto.setCode(ResponseEnum.FAILURE);
        responseDto.setMessage(ex.getMessage());
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    public static ResponseEntity<Object> returnResponse(Exception ex){
        ResponseDto responseDto=new ResponseDto();
        responseDto.setCode(ResponseEnum.FAILURE);
        responseDto.setMessage(ex.getMessage());
        ex.printStackTrace();
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    public static ResponseEntity<Object>returnResponse(Integer httpCode,String message,Object date){
        ResponseDto responseDto=new ResponseDto();
        responseDto.setCode(ResponseEnum.SUCCESS);
        responseDto.setMessage(message);
        responseDto.setData(date);
        return new ResponseEntity<>(responseDto,HttpStatus.valueOf(httpCode));
    }

    public static ResponseEntity<Object>returnResponse(Object data){
        ResponseDto responseDto=new ResponseDto();
        responseDto.setCode(ResponseEnum.SUCCESS);
        responseDto.setMessage(ResponseEnum.SUCCESS.getReason());
        responseDto.setData(data);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }

    public static ResponseEntity<Object>returnResponse(ResponseDto responseDto){
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
}

