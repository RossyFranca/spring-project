package com.franca.hrworker.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Worker {
    private  Long id;
    private  String name;
    private Double dailyIncome;
}
