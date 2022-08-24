package tributacao;

import interfaces.Reajuste;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteAnual implements Reajuste {

    private BigDecimal valor;
    private LocalDate data;

    public ReajusteAnual(BigDecimal valor, LocalDate data) {
        this.valor = valor;
        this.data = data;
    }

    @Override
    public BigDecimal valor() {
        return valor;
    }

    @Override
    public LocalDate data() {
        return data;
    }

}
