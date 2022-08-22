package services;

import exceptions.ValidacaoException;
import interfaces.ValidacaoReajuste;
import model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeriodoMinimoDeReajuste implements ValidacaoReajuste {

    public void validar(Funcionario funcionario, BigDecimal valorAumento) {
        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();
        long numMeses = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
        if (numMeses < 6) {
            throw new ValidacaoException("Intervalo entre reajustes de ser de no minimo 6 meses");
        }
    }
}
