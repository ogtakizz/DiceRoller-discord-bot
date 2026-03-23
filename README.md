# 🎲 Dice Roller Bot

Um bot de Discord focado em rolagens de dados para RPG, com sistema de "escuta passiva" e processamento via Regex. Desenvolvido como projeto de estudo.

## 🚀 Funcionalidades

- **Escuta Passiva:** O bot escuta o chat e detecta rolagens no meio de frases naturais (ex: "Vou atacar com d20 + 5").
- **Parser de Dados Inteligente:** - Suporta formatos como `d20`, `2d10`, `1d100 + 10`.
  - Aceita espaços opcionais entre o dado e o modificador (`1d20+5` ou `1d20 + 5`).
  - Assume automaticamente 1 dado caso a quantidade seja omitida (`d20` = `1d20`).
- **Visual com Embeds:** Respostas organizadas em mensagens com bordas coloridas.
- **Destaque de Críticos:** - **Sucesso Crítico:** Borda verde e texto em negrito para o valor máximo do dado.
  - **Falha Crítica:** Borda vermelha e texto em negrito para o valor 1.
- **Ordenação Automática:** Os resultados individuais dos dados são exibidos em ordem decrescente.

## 🛠️ Tecnologias e Conceitos

- **Java 17+**: Linguagem base do projeto.
- **JDA (Java Discord API)**: Biblioteca para integração com a API do Discord.
- **Regex (Expressões Regulares)**: Utilizado para o parsing e extração de dados das mensagens.
- **Maven**: Gerenciamento de dependências.
- **Dotenv**: Gerenciamento de variáveis de ambiente para proteção do Token.
- **Princípios SOLID**: Aplicação do Princípio de Responsabilidade Única (SRP), separando a lógica de cálculo da lógica de interface do bot.

## 📂 Estrutura do Projeto

O código foi organizado seguindo boas práticas de modularização:
- `BotListener`: Responsável por capturar eventos do Discord e gerenciar a interface (Embeds).
- `CalculaDados`: Motor de cálculo isolado, responsável pela geração de números aleatórios e processamento da rolagem.

## 📦 Como rodar localmente

### 1. Clonar o repositório
```bash
git clone [https://github.com/ogtakizz/DiceRoller-discord-bot](https://github.com/ogtakizz/DiceRoller-discord-bot)
cd DiceRoller-discord-bot
