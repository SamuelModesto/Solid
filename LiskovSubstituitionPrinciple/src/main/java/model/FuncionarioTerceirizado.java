package model;

import enums.Cargo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FuncionarioTerceirizado extends Funcionario {

    private String nomeEmpresaTerceirizada;

    public FuncionarioTerceirizado(String nome, String cpf, BigDecimal salario, Cargo cargo) {
        super(nome, cpf, salario, cargo);
    }

    public String getNomeEmpresaTerceirizada() {
        return nomeEmpresaTerceirizada;
    }

    public void setNomeEmpresaTerceirizada(String nomeEmpresaTerceirizada) {
        this.nomeEmpresaTerceirizada = nomeEmpresaTerceirizada;
    }

}
