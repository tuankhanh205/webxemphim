//package org.example.bephim.exception;
//
//import org.example.clonezalo.base.ResponseData;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ResponseData<Map<String, String>>> handleValidationException(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//
//        ex.getBindingResult().getFieldErrors().forEach(error -> {
//            errors.put(error.getField(), error.getDefaultMessage());
//        });
//
//        return new ResponseEntity<>(
//                new ResponseData<>(400, "Dữ liệu không hợp lệ", errors),
//                HttpStatus.BAD_REQUEST
//        );
//    }
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseData<String> handleNotFoundException(NotFoundException e) {
//        return new ResponseData<>(404, "lỗi: ", e.getMessage());
//    }
//
//
//
//
//
//}
