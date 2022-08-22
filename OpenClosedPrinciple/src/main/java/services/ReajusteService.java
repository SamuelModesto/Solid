package services;

import exceptions.ValidacaoException;
import model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ReajusteService {

    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento){
        BigDecimal salarioAtual = funcionario.getSalario();
        BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
        if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
        }
        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();
        long numMeses = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
        if (numMeses < 6){
            throw new ValidacaoException("Intervalo entre reajustes de ser de no minimo 6 meses");
        }
        BigDecimal salarioAtualizado = salarioAtual.add(aumento);
        funcionario.atualizarSalario(salarioAtualizado);
    }
}
