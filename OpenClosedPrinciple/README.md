<br />
<p >
  <h1> OPEN CLOSED PRINCIPLE</h1>
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
“Classes devem estar abertas para extensão, mas fechadas para modificação.”
## Explicação
### Cenário de aplicação
Um sistema de controle de funcionário, tem regras de negócio para ajustes salariais, e foi solicitado para que uma nova regra fosse adicionada ao projeto, a regra diz que cada funcionário deve esperar um mínimo de 6 meses para receber um novo aumento. Para que o requisito fosse atingido, foi criada uma nova regra na classe ReajusteService.java que verifica se o funcionario ja obteve aumento nos últimos 6 meses. Porém, a cada nova regra exigida para o reajuste salarial, a classe ReajusteService.java precisa ser alterada e acrescentada com mais uma validação. OPEN CLOSED PRINCIPLE resolve este problema.


### Exemplo de código

Primeiramente foi criada uma interface, para abstrair a logica de validar.

```java
package interfaces;

import model.Funcionario;

import java.math.BigDecimal;

public interface ValidacaoReajuste {

    void validar(Funcionario funcionario, BigDecimal valorAumento);
}
```

Em seguida para cada regra de negócio existente deverá ser criada uma classe separada para aquela validação e a classe deve implementar a interface.
```java
package services;

import exceptions.ValidacaoException;
import interfaces.ValidacaoReajuste;
import model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValidacaoPercentualReajuste implements ValidacaoReajuste {

    public void validar(Funcionario funcionario, BigDecimal valorAumento) {
        BigDecimal salarioAtual = funcionario.getSalario();
        BigDecimal percentualReajuste = valorAumento.divide(salarioAtual, RoundingMode.HALF_UP);
        if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
        }
    }
}
```

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

Na classe ReajusteService, deve ser removido as regras de negócio que foram abstraídas para as classes anteriores. Além disso, uma abordagem que pode ser seguida é de criar uma lista de validações e percorre-la de forma que se alguma validação não for concluída com sucesso o sistema lançará uma exceção, pois cada implementação de validação, tem a sua execeção.
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
        BigDecimal salarioAtualizado = funcionario.getSalario().add(aumento);
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
- https://agilemanifesto.org/
- https://bityli.com/AqvfEN

## Licença

Distribuído sob a licença do MIT. Consulte `LICENSE` para obter mais informações.

## Contato
Samuel Modesto 
- [Github](https://github.com/SamuelModesto) 
- [LinkedIn](https://www.linkedin.com/in/samuelmodesto)
- **samuelmodestoes@gmail.com**
