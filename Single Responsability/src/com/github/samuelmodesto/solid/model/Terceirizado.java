package com.github.samuelmodesto.solid.model;

import java.math.BigDecimal;

public class Terceirizado {

    private String empresa;
    private DadosPessoais dadosPessoais;

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }

    public void setDadosPessoais(DadosPessoais dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
