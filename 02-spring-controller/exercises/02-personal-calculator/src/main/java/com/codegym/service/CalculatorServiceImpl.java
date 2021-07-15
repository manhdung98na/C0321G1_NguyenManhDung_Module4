package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{

    @Override
    public float calculator(float soHang1, float soHang2, String phepTinh) throws Exception {
        float result;
        switch (phepTinh){
            case "addition":
                result = soHang1 + soHang2;
                break;
            case "subtraction":
                result = soHang1 - soHang2;
                break;
            case "multiplication":
                result = soHang1 * soHang2;
                break;
            case "division":
                if (soHang2 == 0){
                    throw new Exception("Can not divide to Zero!");
                }else {
                    result = soHang1 / soHang2;
                }
                break;
            default:
                throw new Exception("Exception");
        }
        return result;
    }
}
