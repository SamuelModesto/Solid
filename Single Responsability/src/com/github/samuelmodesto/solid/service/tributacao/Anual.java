package com.github.samuelmodesto.solid.service.tributacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Anual implements Reajuste {

    private BigDecimal valor;
    private LocalDate data;

    public Anual(BigDecimal valor) {
        this.valor = valor;
        this.data = LocalDate.now();
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
