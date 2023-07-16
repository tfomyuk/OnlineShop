package ua.teamchallenge.onlineShop.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppError {
    private int statusCode;
    private String message;
}
