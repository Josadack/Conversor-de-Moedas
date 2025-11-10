package br.com.conversor_de_moedas.service;

import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import static jdk.internal.classfile.impl.DirectCodeBuilder.build;

public class CotacaoCriptoMoedas {

    private static final Dotenv dotenv = Dotenv.load();
    private static final String API_KEY_COTACAO = dotenv.get("API_KEY_COTACAO");

    public void buscarCotacao(String criptoMoeda) {
        try {
            String key = "CG-uyYuGiw9BTzAwviHUJybDsoN";
            String endereco = "https://api.coingecko.com/api/v3/simple/price?ids=" + criptoMoeda + "&vs_currencies=usd&x_cg_demo_api_key=" + API_KEY_COTACAO;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());
        } catch (Exception e) {
            System.out.println("Erro ao buscar cotação: " + e.getMessage());
        }
    }

}
