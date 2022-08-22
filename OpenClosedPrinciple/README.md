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

<!-- ```java 

``` -->

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
