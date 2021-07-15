package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class SandwichServiceImpl implements SandwichService {
    @Override
    public String getCondiments(String[] condiments) {
        String result = "";
        for (int i = 0; i < condiments.length; i++) {
            result += condiments[i];
            if (i != condiments.length - 1) {
                result += ", ";
            }
        }
        if (!result.equals("")) {
            result = "Condiments: " + result;
            return result;
        }
        return null;
    }
}
