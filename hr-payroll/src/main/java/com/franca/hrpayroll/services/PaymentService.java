package com.franca.hrpayroll.services;

import com.franca.hrpayroll.entities.Payment;
import com.franca.hrpayroll.entities.Worker;
import com.franca.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days) {

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", "" + workerId);
        Worker worker = workerFeignClient.findById(workerId).getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
