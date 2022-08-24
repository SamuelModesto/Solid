package tributacao;

import interfaces.ReajusteTributavel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajustePromocao implements ReajusteTributavel{

    private BigDecimal valor;
    private LocalDate data;

    public ReajustePromocao(BigDecimal valor, LocalDate data) {
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

    @Override
    public BigDecimal valorImpostoDeRenda() {
        return valor.multiply(new BigDecimal("0.1"));
    }
}
