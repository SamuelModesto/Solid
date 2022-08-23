package model;

import enums.Cargo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FuncionarioTerceirizado {

    private DadosPessoais dadosPessoais;
    private String nomeEmpresaTerceirizada;

    public FuncionarioTerceirizado(DadosPessoais dadosPessoais, String nomeEmpresaTerceirizada) {
        this.dadosPessoais = dadosPessoais;
        this.nomeEmpresaTerceirizada = nomeEmpresaTerceirizada;
    }

    public String getNomeEmpresaTerceirizada() {
        return nomeEmpresaTerceirizada;
    }

    public void setNomeEmpresaTerceirizada(String nomeEmpresaTerceirizada) {
        this.nomeEmpresaTerceirizada = nomeEmpresaTerceirizada;
    }

}
