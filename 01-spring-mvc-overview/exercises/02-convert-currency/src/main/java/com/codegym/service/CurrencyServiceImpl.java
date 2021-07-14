package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService{
    @Override
    public float convert(float usd, float rate) {
        return usd*rate;
    }
}
