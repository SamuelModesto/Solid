package model;

import enums.Cargo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario {


    private DadosPessoais dadosPessoais;
    private LocalDate dataUltimoReajuste;


    public Funcionario(DadosPessoais dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }

    public void atualizarSalario(BigDecimal novoSalario) {
        this.dadosPessoais.setSalario(novoSalario);
        this.dataUltimoReajuste = LocalDate.now();
    }

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }

    public void setDadosPessoais(DadosPessoais dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }

    public LocalDate getDataUltimoReajuste() {
        return dataUltimoReajuste;
    }

    public void setDataUltimoReajuste(LocalDate dataUltimoReajuste) {
        this.dataUltimoReajuste = dataUltimoReajuste;
    }

    public void promover(Cargo novoCargo){
        dadosPessoais.setCargo(novoCargo);
    }

}
