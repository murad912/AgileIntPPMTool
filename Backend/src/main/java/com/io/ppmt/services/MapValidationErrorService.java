package com.io.ppmt.services;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapValidationErrorService {

    /*
        BindingResult help to getFieldError -> we have field validation in model class
        FieldError has field (ProjectDescription) and DefualtMessage (Project description is required)
        We are trying to display the user field name and error message from the validation
        We create a map and put field as a key and defualtMessage as a value
    */
    public ResponseEntity<?> MapValidationService(BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
