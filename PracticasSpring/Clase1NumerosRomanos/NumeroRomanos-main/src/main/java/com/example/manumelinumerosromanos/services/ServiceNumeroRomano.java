package com.example.manumelinumerosromanos.services;

import com.example.manumelinumerosromanos.models.NumeroRomano;
import com.example.manumelinumerosromanos.utils.UtilsR;
import org.springframework.stereotype.Service;

@Service
public class ServiceNumeroRomano implements IServiceNumeroRomano {

    @Override
    public NumeroRomano traerNumeroRomano(int numero) {
        NumeroRomano ret = new NumeroRomano(numero, UtilsR.IntegerToRomanNumeral(numero));
        return ret;
    }

    @Override
    public NumeroRomano traerNumeroDecimal(String sRomano) {
        NumeroRomano res = new NumeroRomano(UtilsR.romanToInteger(sRomano),sRomano);
        return res;
    }


}
