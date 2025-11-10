package br.com.conversor_de_moedas.principal;

import br.com.conversor_de_moedas.service.ConversorDeMoedas;
import br.com.conversor_de_moedas.service.CotacaoCriptoMoedas;
import com.google.gson.*;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException {
        Scanner leitura  = new Scanner(System.in);
        ConversorDeMoedas converso = new ConversorDeMoedas();
        CotacaoCriptoMoedas cotacao = new CotacaoCriptoMoedas();

        int escola = -1;
        while (true){
          System.out.println(""" 
                   ⏹️  ESCOLHA UMA OPÇÃO:  ⏹️
                    
                    1. CONVERSOR DE MOEDAS
                    2. COATAÇÃO DE CRIPTOMOEDAS
                    0. SAIR
                """);

          escola = leitura.nextInt();
          if(escola == 1){

              int opcoa;
              do{
                  System.out.println("""
                    **********************************************************
                    💱 Seja bem-vindo(a) ao CONVERSOR DE MOEDAS 💱
                    
                    1. Dólar (USD) → Real (BRL) 💴
                    2. Real (BRL) → Dólar (USD) 💵
                    3. Real (BRL) → Euro (EUR) 💶
                    4. Real (BRL) → Libra (GBP) 💷
                    5. Real (BRL) → Peso Argentino (ARS) 💵
                    6. Real (BRL) → Peso Chileno (CLP) 💶
                    7. Euro (EUR) → Real (BRL)
                    0. Sair
                    """);
                  opcoa = leitura.nextInt();

                  if(opcoa == 0) break;

                  System.out.print("Digite o valor: ");
                  String valorStr = leitura.next().replace(",", ".");
                  double valor = Double.parseDouble(valorStr);

                  double resultado = 0;

                  switch (opcoa){
                      case 1:
                          resultado = converso.converter("USD", "BRL", valor);
                          System.out.println("O valor " + valor + "[USD] corresponde ao valor de: " + resultado + "[BRL]"   );
                          break;
                      case 2:
                          resultado = converso.converter("BRL", "USD", valor);
                          System.out.println("O valor " + valor + "[BRL] corresponde ao valor de: " + resultado + "[USD]");
                          break;
                      case 3:
                          resultado = converso.converter("BRL", "EUR", valor);
                          System.out.println("O valor " + valor + "[BRL] corresponde ao valor de: " + resultado + "[EUR]");
                          break;
                      case 4:
                          resultado = converso.converter("BRL", "GBP", valor);
                          System.out.println("O valor " + valor + "[BRL] corresponde ao valor de: " + resultado + "[GBP]");
                          break;
                      case 5:
                          resultado = converso.converter("BRL", "ARS", valor);
                          System.out.println("O valor " + valor + "[BRL] corresponde ao valor de: " + resultado + "[ARS]");
                          break;
                      case 6:
                          resultado = converso.converter("BRL", "CLP", valor);
                          System.out.println("O valor " + valor + "[BRL] corresponde ao valor de: " + resultado + "[CLP]");
                          break;
                      case 7:
                          resultado = converso.converter("EUR", "BRL", valor);
                          System.out.println("O valor " + valor + "[EUR] corresponde ao valor de: " + resultado + "[BRL]");
                          break;
                      default:
                          System.out.println("Opção inválida!");
                          continue;
                  }

              }while(opcoa != 0);

              System.out.println("Conversão encerrada!");
              //leitura.close();

          }else if(escola == 2){

              int opcoa;
              do{
                  System.out.println("""
                    **********************************************************
                    💱 Seja bem-vindo(a) a COTAÇÃO DE CRIPTOMOEDAS 💱
                    
                    1. BITCOIN(BTN)
                    2. ETHEREUM(ETH)
                    3. LITECOIN(LTC)
                    4. RIPPLE(XRP)
                    5. CARDANO(ADA)
                    0. Sair
                    """);
                  opcoa = leitura.nextInt();

                  if(opcoa == 0) break;


                  double resultado = 0;

                  switch (opcoa){
                      case 1:
                          cotacao.buscarCotacao("BITCOIN");
                          break;
                      case 2:
                          cotacao.buscarCotacao("ETHEREUM");
                          break;
                      case 3:
                          cotacao.buscarCotacao("LITECOIN");
                          break;
                      case 4:
                          cotacao.buscarCotacao("RIPPLE");
                          break;
                      case 5:
                          cotacao.buscarCotacao("CARDANO");
                          break;
                      default:
                          System.out.println("Opção inválida!");
                          continue;
                  }

              }while(opcoa != 0);

              System.out.println("Conversão encerrada!");

          }else if(escola == 0){
              System.out.println("Programa encerrado!");
              break;
          }else {
              System.out.println("Opção inválida!");
          }

      }



    }
}
