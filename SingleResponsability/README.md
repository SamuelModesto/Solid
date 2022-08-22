<br />
<p >
  <h1> SINGLE RESPONSABILITY</h1>
</p>


<!-- TABLE OF CONTENTS -->

## Conteúdo

- [Propósito](#Propósito)
- [Explicação](#Explicação)
  - [Cenário](#Cenário-De-Aplicação)
  - [Exemplo de Código](#Exemplo-de-código)
- [Diagrama de Classe](#Diagrama-de-Classe)

- [Créditos](#Créditos)
- [Licença](#Licença)
- [Contato](#Contato)

## Propósito
“Uma classe deve ter um, e apenas um, motivo para ser modificada”.
Se uma classe deve ter apenas um único motivo para ser modificada, então certamente ela deve ter apenas uma única responsabilidade.

## Explicação
### Cenário de aplicação
Um sistema de controle de funcionários, possui a classe de modelo Funcionario.java com os seus respectivos atributos  e regras de calculo de reajuste salarial. Dessa forma será aplicado o princípio da responsabilidade única para que a classe Funcionário.java não contenha mais informação do que o necessário. Nesse exemplo a classe Funcionario.java, representa um colaborador de uma empresa e não deveria ter regras de ajuste salarial na classe modelo.

### Exemplo de código
Na classe de Funcionario, foi removido as regras de calculo do ajuste salarial e adicionado um método atualizarSalario() que apenas recebe o valor do novo salário e  não precisa executar nenhuma lógica.
```java 
package model;

import enums.Cargo;
import exceptions.ValidacaoException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Funcionario {

    private String nome;
    private String cpf;
    private Cargo cargo;
    private BigDecimal salario;
    private LocalDate dataUltimoReajuste;

    public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
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

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
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

```

Classe criada para abstrair as regras de negócio que foram removidas da classe Funcionário.
```java 
package services;

import exceptions.ValidacaoException;
import model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReajusteService {

    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento){
        BigDecimal salarioAtual = funcionario.getSalario();
        BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
        if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
        }
        BigDecimal salarioAtualizado = salarioAtual.add(aumento);
        funcionario.atualizarSalario(salarioAtualizado);
    }
}

```

Classse de exceção para o caso de uma atualização salarial não ocorrer com sucesso.
```java 
package exceptions;

public class ValidacaoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ValidacaoException(String mensagem) {
        super(mensagem);
    }

}
```

<!-- ```java 

``` -->
## Diagrama de classe

<!-- <p align="center">
  <a href="https://github.com/SamuelModesto">
      <img alt="Minerva" src="https://github.com/SamuelModesto/Imagens/blob/master/Imagens%20Minerva/strategy.png" />
  </a>
</p> -->

## Créditos

## Licença

Distribuído sob a licença do MIT. Consulte `LICENSE` para obter mais informações.

## Contato
Samuel Modesto 
- [Github](https://github.com/SamuelModesto) 
- [LinkedIn](https://www.linkedin.com/in/samuelmodesto)
- Email - **samuelmodestoes@gmail.com**
