package com.example.microcreditstub;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/v2")
public class PaymentController {

    @PostMapping("/payment/")
    public ResponseEntity<Map<String, Object>> payment(
            @RequestHeader("BankCode") String bankCode,
            @RequestBody Map<String, Object> request) {

        // Кол-во строк telecom = сумме цифр BankCode
        int sumDigits = bankCode.chars().map(Character::getNumericValue).sum();

        List<String> telecom = new ArrayList<>();
        for (int i = 0; i < sumDigits; i++) {
            telecom.add("contact_" + i);
        }

        Map<String, Object> contact = Map.of(
                "name", "HL pay company",
                "telecom", telecom
        );

        Map<String, Object> response = new HashMap<>();
        response.put("transaction_id", request.get("transaction_id"));
        response.put("bank_bik", "2345678997"); // Числовая строка не менее 10 символов
        response.put("status", "accepted");
        response.put("contact", List.of(contact));

        // Хидер ответа с текущим временем
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

        return ResponseEntity.ok()
                .header("ProcessingTime", time)
                .body(response);
    }
}