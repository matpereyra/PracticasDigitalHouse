package com.example.manumelinumerosromanos.services;

import com.example.manumelinumerosromanos.models.NumeroRomano;

public interface IServiceNumeroRomano {
    NumeroRomano traerNumeroRomano(int numero);
    NumeroRomano traerNumeroDecimal(String sRomano);
}
