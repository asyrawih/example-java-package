package com.axiatadigitallabs.common;

import java.util.Base64;

public class Encode {
    public String encodeToBase64(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes());
    }
}
