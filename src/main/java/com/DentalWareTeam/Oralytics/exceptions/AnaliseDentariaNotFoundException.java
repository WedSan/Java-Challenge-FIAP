package com.DentalWareTeam.Oralytics.exceptions;

import com.DentalWareTeam.Oralytics.model.AnaliseDentaria;

public class AnaliseDentariaNotFoundException extends RuntimeException{
    public AnaliseDentariaNotFoundException (String message) {
        super(message);
    }
}
