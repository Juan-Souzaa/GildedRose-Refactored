# Gilded Rose Refactored

Solução em Java do kata de refatoração [Gilded Rose](https://github.com/emilybache/GildedRose-Refactoring-Kata). O exercício entrega um método único, cheio de condicionais aninhadas, que atualiza a qualidade dos itens de uma loja. O objetivo é deixá-lo legível sem mudar o comportamento e, depois, incluir um novo tipo de item.

<p>
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/JUnit_5-25A162?style=for-the-badge&logo=junit5&logoColor=white" alt="JUnit 5">
  <img src="https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white" alt="Gradle">
</p>

## O que foi feito

- Nomes de itens e limites de qualidade viraram constantes
- Cada regra ganhou um método próprio: Aged Brie, Backstage passes, Sulfuras, item comum e item vencido
- Inclusão dos itens **Conjured**, que perdem qualidade duas vezes mais rápido
- Testes com JUnit 5 cobrindo cada tipo de item, antes e depois do vencimento

## Regras do kata

| Item | Comportamento |
|---|---|
| Comum | Perde 1 de qualidade por dia, e 2 depois de vencido |
| Aged Brie | Ganha qualidade com o tempo |
| Backstage passes | Ganha 1, 2 ou 3 conforme o show se aproxima, e zera depois dele |
| Sulfuras | Nunca muda |
| Conjured | Perde qualidade em dobro |

A qualidade nunca fica abaixo de 0 e, fora o Sulfuras, nunca passa de 50.

## Como rodar

Pré-requisito: JDK 8 ou superior. O repositório traz o wrapper do Gradle para Windows:

```bash
gradlew.bat test
gradlew.bat texttest
```

O segundo comando imprime a evolução dos itens ao longo de 30 dias. Em Linux ou macOS, use um Gradle instalado: `gradle test`.
