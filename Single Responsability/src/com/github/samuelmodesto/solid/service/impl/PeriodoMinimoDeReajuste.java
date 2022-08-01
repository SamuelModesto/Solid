package com.github.samuelmodesto.solid.service.impl;

import com.github.samuelmodesto.solid.ValidacaoException;
import com.github.samuelmodesto.solid.model.Funcionario;
import com.github.samuelmodesto.solid.service.interfaces.ValidarReajuste;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PeriodoMinimoDeReajuste implements ValidarReajuste {

    @Override
    public void validar(Funcionario funcionario, BigDecimal aumento) {
        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();
        long qtdMesesUltimoReajuste = ChronoUnit.MONTHS.between(dataAtual, dataUltimoReajuste);
        if(qtdMesesUltimoReajuste < 6 ){
            throw new ValidacaoException("Intervalo entre reajustes deve ser maior que 6 meses.");
        }
    }
}
