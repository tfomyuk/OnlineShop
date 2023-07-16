package ua.teamchallenge.onlineShop.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.teamchallenge.onlineShop.controller.AppError;

@Service
public class ResponseEntityHandler {
    public ResponseEntity<?> responseEntityNotFound(String exception) {
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(), exception),
                HttpStatus.NOT_FOUND);
    }
}
