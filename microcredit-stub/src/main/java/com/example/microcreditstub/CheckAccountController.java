package com.example.microcreditstub;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/v2")
public class CheckAccountController {

    @GetMapping("/checkAccount")
    public ResponseEntity<Map<String, Object>> checkAccount(
            @RequestParam String acc,
            @RequestParam int days) {

        Map<String, Object> response = new HashMap<>();
        response.put("account", acc);

        // Логика: если acc заканчивается на нечетную цифру -> vip-client = true
        char lastChar = acc.charAt(acc.length() - 1);
        boolean isVip = Character.isDigit(lastChar) && (lastChar - '0') % 2 != 0;

        response.put("vip-client", isVip);
        response.put("blocked", false);
        response.put("inn", acc + "111");

        // Генерация массива debt (кол-во = days)
        List<Map<String, Object>> debts = new ArrayList<>();
        for (int i = 0; i < days; i++) {
            debts.add(Map.of("sum", 1000 + i, "description", "debt-" + i));
        }
        response.put("debt", debts);

        // Возвращаем код 202
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
}