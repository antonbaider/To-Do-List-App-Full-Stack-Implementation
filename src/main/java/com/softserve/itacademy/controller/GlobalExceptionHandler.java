package com.softserve.itacademy.controller;



import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

    @ControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(ConstraintViolationException.class)
        public String handleConstraintViolationException(ConstraintViolationException ex, Model model) {
            // Log the exception
            ex.printStackTrace();

            // Extract the list of ConstraintViolation objects
            Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();

            // Add the list of ConstraintViolation objects to the model
            model.addAttribute("constraintViolations", constraintViolations);

            // Return the error template
            return "error";
        }

        // Handle other exceptions if needed
        @ExceptionHandler(Exception.class)
        public String handleException(Exception ex, Model model) {
            // Log the exception
            ex.printStackTrace();

            // Return the error template
            return "error";
        }
    }