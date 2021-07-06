package com.example.manumelinumerosromanos.controllers;

import com.example.manumelinumerosromanos.models.NumeroRomano;
import com.example.manumelinumerosromanos.routes.Router;
import com.example.manumelinumerosromanos.services.IServiceNumeroRomano;
import com.example.manumelinumerosromanos.services.ServiceNumeroRomano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Router.BASE)
public class ControladorRomanos {

    @Autowired
    private IServiceNumeroRomano serviceNumeroRomano;

    @GetMapping(value = Router.ROMANOS)
    public ResponseEntity<NumeroRomano> convertirARomano(@PathVariable("numero") String sNumero){
        Integer numero = Integer.valueOf(sNumero);
        NumeroRomano response;
        if(numero > 0) {//validar en otra capa,no hacer validaciones en controlador (en servicio)
            response = serviceNumeroRomano.traerNumeroRomano(numero);
        }else {
            response = null;
        }
        return (response == null)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(response);
    }

    @GetMapping(value = Router.DECIMALES)
    public ResponseEntity<NumeroRomano> convertirADecimal(@PathVariable("romano") String sRomano){
        NumeroRomano response;
        response = serviceNumeroRomano.traerNumeroDecimal(sRomano);
        return (response == null)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(response);
    }
}
