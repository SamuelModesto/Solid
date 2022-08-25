<br />
<p >
  <h1>INTERFACE SEGREGATION PRINCIPLE</h1>
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
"Uma Classe não deveria ser forçada a depender e implementar métodos que não utilizará"

## Explicação
### Cenário de aplicação
Um sistema que controla pagamento de funcionários, tem métodos que aumentam o salário dos funcionários, podendo ser por promoção ou por reajuste anual, porém apenas o aumento por promoção é passível de imposto de renda.

### Exemplo de código
Removemos o metodo de tributação dessa interface para que as classes que nao precisam implementar não sejam obrigadas a implementar.
```java 
package interfaces;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Reajuste {

    BigDecimal valor();
    LocalDate data();
}

```

O metodo de tributação foi extraído para uma interface separada.
```java 
package interfaces;

import java.math.BigDecimal;

public interface ReajusteTributavel extends  Reajuste {

    BigDecimal valorImpostoDeRenda();
}

```
A classe ReajusteAnual neste exemplo, não sofre a tributação, portanto ela só precisa implementar a interface de reajuste.
```java 
package tributacao;

import interfaces.Reajuste;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteAnual implements Reajuste {

    private BigDecimal valor;
    private LocalDate data;

    public ReajusteAnual(BigDecimal valor, LocalDate data) {
        this.valor = valor;
        this.data = data;
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

```
Já a classe ReajustePromocao, é preciso conter tudo que tem na interface de reajuste e adicionar a tributação, dessa forma basta implementar de ReajusteTributavel pois a mesma herda de Reajuste.
```java 
package tributacao;

import interfaces.ReajusteTributavel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajustePromocao implements ReajusteTributavel{

    private BigDecimal valor;
    private LocalDate data;

    public ReajustePromocao(BigDecimal valor, LocalDate data) {
        this.valor = valor;
        this.data = data;
    }

    @Override
    public BigDecimal valor() {
        return valor;
    }

    @Override
    public LocalDate data() {
        return data;
    }

    @Override
    public BigDecimal valorImpostoDeRenda() {
        return valor.multiply(new BigDecimal("0.1"));
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
