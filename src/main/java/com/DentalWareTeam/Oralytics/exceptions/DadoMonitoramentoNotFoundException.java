package com.DentalWareTeam.Oralytics.exceptions;

import com.DentalWareTeam.Oralytics.model.DadoMonitoramento;

public class DadoMonitoramentoNotFoundException extends RuntimeException {

    public DadoMonitoramentoNotFoundException(String message) {
        super(message);
    }
}
