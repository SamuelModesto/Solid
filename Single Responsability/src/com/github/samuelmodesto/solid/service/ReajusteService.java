package com.github.samuelmodesto.solid.service;

import com.github.samuelmodesto.solid.model.Funcionario;
import com.github.samuelmodesto.solid.service.interfaces.ValidarReajuste;

import java.math.BigDecimal;
import java.util.List;

public class ReajusteService {

    private List<ValidarReajuste> validacoes;

    public ReajusteService(List<ValidarReajuste> validacoes) {
        this.validacoes = validacoes;
    }

    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento){
        this.validacoes.forEach(e -> e.validar(funcionario, aumento));
        BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
        funcionario.atualizarSalario(salarioReajustado);
    }
}
