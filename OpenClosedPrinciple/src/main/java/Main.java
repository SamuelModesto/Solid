import interfaces.ValidacaoReajuste;
import model.Funcionario;
import services.ReajusteService;
import services.ValidacaoPercentualReajuste;
import services.ValidacaoPeriodoMinimoDeReajuste;

import java.math.BigDecimal;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("samuel", "432874283478234", new BigDecimal("1000"));
        List<ValidacaoReajuste> validacoes = Arrays.asList(
                new ValidacaoPercentualReajuste(),
                new ValidacaoPeriodoMinimoDeReajuste());



        ReajusteService service = new ReajusteService(validacoes);
        BigDecimal aumento = new BigDecimal("1000");
        service.reajustarSalarioDoFuncionario(funcionario, aumento);
    }
}
