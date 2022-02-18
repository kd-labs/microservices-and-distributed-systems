package com.kdlabs.clients.fraud;


import com.kdlabs.clients.fraud.dto.FraudCheckResponse;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "fraud", path = "api/v1/checkfraud")
public interface FraudClient {

    @GetMapping("{customerId}")
    FraudCheckResponse isFraudster(@PathVariable(value="customerId") Integer customerId);
}
