package com.example.microcreditstub;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/v1/transactions")
public class TransactionController {

    // Берет значение из application.yml (1 сек, 2 сек или 4 сек)
    @Value("${delay.ms}")
    private long delayMs;

    @DeleteMapping("/cleare/{id}")
    public void clearTransaction(@PathVariable String id, HttpServletResponse response) throws Exception {
        // Задержка
        Thread.sleep(delayMs);

        // Устанавливаем код ответа 100 и plain text
        response.setStatus(100);
        response.setContentType("text/plain");
        response.getWriter().write("deleted success");
    }
}