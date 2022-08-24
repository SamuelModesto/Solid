<br />
<p >
  <h1> LISKOV SUBSTITUITION PRINCIPLE </h1>
</p>


<!-- TABLE OF CONTENTS -->

## Conteúdo

- [Propósito](#Propósito)
- [Explicação](#Explicação)
  - [Cenário](#Cenário-De-Aplicação)
  - [Exemplo de Código](#Exemplo-de-código)

- [Créditos](#Créditos)
- [Licença](#Licença)
- [Contato](#Contato)

## Propósito
"Se q(x) é uma propriedade demonstrável dos objetos x de tipo T. Então q(y) deve ser verdadeiro para objetos y de tipo S onde S é um subtipo de T."
## Explicação
### Cenário de aplicação
Um sistema que controla funcionários e funcionários terceirizados e tem como funcionalidade para funcionários a promoção de cargo e o reajuste salarial, porém, neste exemplo o requisito diz que funcionários terceirizados não recebem promoções ou reajustes salariais, ficando a cargo da empresa terceira essa função.

### Exemplo de código
Classe que representam os cargos com métodos para indicar qual o próximo cargo dentro do plano de carreira.
```java 
package enums;

public enum Cargo {

    ASSISTENTE {
        @Override
        public Cargo getProximoCargo() {
            return ANALISTA;
        }
    },
    ANALISTA {
        @Override
        public Cargo getProximoCargo() {
            return ESPECIALISTA;
        }
    },
    ESPECIALISTA {
        @Override
        public Cargo getProximoCargo() {
            return GERENTE;
        }
    },
    GERENTE {
        @Override
        public Cargo getProximoCargo() {
            return GERENTE;
        }
    };

    public abstract Cargo getProximoCargo();

}

```
Os dados pessoais de funcionários foram abstraídos para uma classe separada, evitando assim a herança indesejada na classe FuncionarioTerceirizado, favorecendo assim a composição.
```java 
package model;

import enums.Cargo;

import java.math.BigDecimal;

public class DadosPessoais {

    private String nome;
    private String cpf;
    private BigDecimal salario;
    private Cargo cargo;

    public DadosPessoais(String nome, String cpf, BigDecimal salario, Cargo cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.cargo = cargo;
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

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}

```

<!--
```java 
```
-->
A classe FuncionarioTerceirizado possui um atributo do tipo DadosPessoais.
```java 
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

```
A classe Funcionario possui um atributo do tipo DadosPessoais.
```java 
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

```
<!-- ## Diagrama de classe -->

<!-- <p align="center">
  <a href="https://github.com/SamuelModesto">
      <img alt="Minerva" src="https://github.com/SamuelModesto/Imagens/blob/master/Imagens%20Minerva/strategy.png" />
  </a>
</p> -->

## Créditos
- https://www.alura.com.br/
- https://bityli.com/AqvfEN

## Licença

Distribuído sob a licença do MIT. Consulte `LICENSE` para obter mais informações.

## Contato
Samuel Modesto 
- [Github](https://github.com/SamuelModesto) 
- [LinkedIn](https://www.linkedin.com/in/samuelmodesto)
- **samuelmodestoes@gmail.com**
