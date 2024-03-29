package services;

import interfaces.ValidacaoReajuste;
import model.Funcionario;

import java.math.BigDecimal;
import java.util.List;

public class ReajusteService {

    private List<ValidacaoReajuste> validacoes;

    public ReajusteService(List<ValidacaoReajuste> validacoes) {
        this.validacoes = validacoes;
    }

    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento){
        this.validacoes.forEach(e -> e.validar(funcionario, aumento));
        BigDecimal salarioAtualizado = funcionario.getSalario().add(aumento);
        funcionario.atualizarSalario(salarioAtualizado);
    }
}
