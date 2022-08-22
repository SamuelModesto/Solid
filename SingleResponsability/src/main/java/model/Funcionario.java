package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario {

    private String nome;
    private String cpf;
    private BigDecimal salario;
    private LocalDate dataUltimoReajuste;

    public Funcionario(String nome, String cpf, BigDecimal salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }

    public void atualizarSalario(BigDecimal novoSalario) {
        this.salario = novoSalario;
        this.dataUltimoReajuste = LocalDate.now();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public LocalDate getDataUltimoReajuste() {
        return dataUltimoReajuste;
    }

    public void setDataUltimoReajuste(LocalDate dataUltimoReajuste) {
        this.dataUltimoReajuste = dataUltimoReajuste;
    }

}
