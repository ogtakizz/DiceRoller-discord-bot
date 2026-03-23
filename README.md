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

- **Java 21+**: Linguagem base do projeto.
- **JDA (Java Discord API)**: Biblioteca para integração com a API do Discord.
- **Regex (Expressões Regulares)**: Utilizado para o parsing e extração de dados das mensagens.
- **Maven**: Gerenciamento de dependências.
- **Dotenv**: Gerenciamento de variáveis de ambiente para proteção do Token.

## 📦 Como rodar localmente

### 1. Clonar o repositório
```bash
git clone https://github.com/ogtakizz/DiceRoller-discord-bot
cd DiceRoller-discord-bot```

### 2. Criar e Configurar o Token do Discord
 - Para o bot funcionar, você precisa registrar uma aplicação no Discord:
    - 1. Acesse o [Discord Developer Portal](https://discord.com/developers/applications).
    - 2. Clique em **"New Application"** e escolha um nome.
