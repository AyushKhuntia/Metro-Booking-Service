package com.moveinsync.assignment.service;


import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class QRService {

    private static final String SECRET = "moveinsync-secret";

    public String generateQRString(String bookingRef) {
        String raw = bookingRef + ":" + SECRET;
        return Base64.getEncoder()
                .encodeToString(raw.getBytes(StandardCharsets.UTF_8));
    }
}
