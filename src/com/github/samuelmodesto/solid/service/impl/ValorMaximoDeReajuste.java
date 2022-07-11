package com.github.samuelmodesto.solid.service.impl;

import com.github.samuelmodesto.solid.ValidacaoException;
import com.github.samuelmodesto.solid.model.Funcionario;
import com.github.samuelmodesto.solid.service.interfaces.ValidarReajuste;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValorMaximoDeReajuste implements ValidarReajuste {

    @Override
    public void validar(Funcionario funcionario, BigDecimal aumento) {
        BigDecimal salarioAtual = funcionario.getSalario();
        BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
        if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
        }
    }
}
