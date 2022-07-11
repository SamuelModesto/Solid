package com.github.samuelmodesto.solid.service.interfaces;

import com.github.samuelmodesto.solid.model.Funcionario;

import java.math.BigDecimal;

public interface ValidarReajuste {

    void validar(Funcionario funcionario, BigDecimal aumento);
}
