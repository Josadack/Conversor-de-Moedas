# Conversor de Moedas e Cotação de Criptomoedas 💱💰

## Descrição
Projeto em **Java** que permite:
- **Converter moedas tradicionais** (USD, BRL, EUR, GBP, ARS, CLP)  
- **Consultar cotações de criptomoedas** em tempo real (BTC, ETH, LTC, XRP, ADA)  

O usuário interage via **menu no console**, escolhendo a operação desejada de forma simples.

---

## Tecnologias Utilizadas
- **Java 17+**
- **Gson** – Para fazer parsing de JSON das respostas das APIs
- **Dotenv** – Para armazenar com segurança as chaves das APIs em arquivo `.env`
- **API CoinGecko** – Para cotações de criptomoedas
- **API ExchangeRate-API** – Para taxas de câmbio de moedas

---

## Funcionalidades

### 1. Conversor de Moedas
- Converte entre diferentes moedas tradicionais
- Utiliza a **ExchangeRate-API** para buscar taxas de câmbio atualizadas

### 2. Cotação de Criptomoedas
- Consulta valores em **USD** (e opcionalmente BRL) para:
  - Bitcoin (BTC)
  - Ethereum (ETH)
  - Litecoin (LTC)
  - Ripple (XRP)
  - Cardano (ADA)
- Usa a **CoinGecko API** para obter dados em tempo real

---

## Como Usar
1. Clone o repositório:
```bash
git clone <url-do-repositório>
```

2. Crie um arquivo `.env` na raiz do projeto com suas chaves de API:
```env
API_KEY_CONVERSOR=sua_chave_exchange
API_KEY_COTACAO=sua_chave_coingecko
```

3. Compile e execute o projeto:
```bash
javac -d out src/br/com/conversor_de_moedas/principal/Principal.java
java -cp out br.com.conversor_de_moedas.principal.Principal
```

4. Siga o menu no console para:
- Converter moedas
- Consultar cotação de criptomoedas

---

## Exemplo de Uso

```
💱 Seja bem-vindo(a) a COTAÇÃO DE CRIPTOMOEDAS 💱

1. BITCOIN(BTC)
2. ETHEREUM(ETH)
0. Sair

> 1
💰 Cotação do bitcoin: US$ 105983.00
Conversão encerrada!
```

```
💱 Seja bem-vindo(a) ao CONVERSOR DE MOEDAS 💱

Digite o valor: 100
O valor 100 [USD] corresponde ao valor de: 520 [BRL]
Conversão encerrada!
```

---

## Observações
- As moedas e criptomoedas devem ser passadas com **nomes corretos** (minúsculas) para evitar erro na API
- Projeto educacional desenvolvido em Java, usando **Gson** para JSON e **Dotenv** para gerenciamento seguro das chaves

---

## Créditos
Parabéns **Alura** pelo conteúdo.  
**Jaque e Paulo** — os melhores instrutores de Java que já vi! 👏

