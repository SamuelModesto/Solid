<br />
<p >
  <h1> DEPENDENCY INVERSION PRINCIPLE </h1>
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
"Abstrações não devem depender de implementações. Implementações devem depender de abstrações."
## Explicação
### Cenário de aplicação
De uma forma objetiva o princípio propõe que sempre devemos depender de abstrações e não das implementações, pois as abstrações são mais estáveis ou seja, sofrem menos mudanças e facilitam as implementações de diferentes comportamentos.
Um sistema que precisa validar regras de reajustes para funcionários, podem ter diversas validações abstraída para uma única interface e implementada de diferentes maneiras. 

### Exemplo de código
Interface que abstrai a regra de validar.
```java 
package interfaces;

import model.Funcionario;

import java.math.BigDecimal;

public interface ValidacaoReajuste {

    void validar(Funcionario funcionario, BigDecimal valorAumento);
}

```
Uma das possiveis implementações para regras de reajustes.
```java 
package services;

import exceptions.ValidacaoException;
import interfaces.ValidacaoReajuste;
import model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValidacaoPercentualReajuste implements ValidacaoReajuste {

    public void validar(Funcionario funcionario, BigDecimal valorAumento) {
        BigDecimal salarioAtual = funcionario.getDadosPessoais().getSalario();
        BigDecimal percentualReajuste = valorAumento.divide(salarioAtual, RoundingMode.HALF_UP);
        if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
        }
    }
}

```
Uma das possiveis implementações para regras de reajustes.
```java 
package services;

import exceptions.ValidacaoException;
import interfaces.ValidacaoReajuste;
import model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeriodoMinimoDeReajuste implements ValidacaoReajuste {

    public void validar(Funcionario funcionario, BigDecimal valorAumento) {
        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();
        long numMeses = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
        if (numMeses < 6) {
            throw new ValidacaoException("Intervalo entre reajustes de ser de no minimo 6 meses");
        }
    }
}

```
Chamada das validações, utilizando uma lista do mesmo tipo da abstração (interface).
```java 
package services;

import interfaces.ValidacaoReajuste;
import model.Funcionario;

import java.math.BigDecimal;
import java.util.List;

public class ReajusteService {

    private List<ValidacaoReajuste> validacoes;

    public ReajusteService(List<ValidacaoReajuste> validacoes) {
        this.validacoes = validacoes;
    }

    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento){
        this.validacoes.forEach(e -> e.validar(funcionario, aumento));
        BigDecimal salarioAtualizado = funcionario.getDadosPessoais().getSalario().add(aumento);
        funcionario.atualizarSalario(salarioAtualizado);
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
