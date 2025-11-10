package br.com.conversor_de_moedas.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConversorDeMoedas {

    private static final Dotenv dotenv = Dotenv.load();
    private static final String API_KEY_CONVERSOR = dotenv.get("API_KEY_CONVERSOR");

    public double converter(String moedaOrigem, String moedaDestino, double valor) {
        try {
            String url_str = "https://v6.exchangerate-api.com/v6/" + API_KEY_CONVERSOR + "/latest/" + moedaOrigem;

            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            JsonElement root = JsonParser.parseReader(new InputStreamReader(request.getInputStream()));
            JsonObject jsonobj = root.getAsJsonObject();

            // Verifica se a API respondeu com sucesso
            String resultado = jsonobj.get("result").getAsString();
            if (!resultado.equals("success")) {
                System.out.println("❌ Erro da API: " + jsonobj);
                return 0;
            }

            JsonObject taxas = jsonobj.getAsJsonObject("conversion_rates");
            if (taxas == null || !taxas.has(moedaDestino)) {
                System.out.println("❌ Moeda de destino não encontrada: " + moedaDestino);
                return 0;
            }

            double taxa = taxas.get(moedaDestino).getAsDouble();
            return valor * taxa;

        } catch (Exception e) {
            System.out.println("❌ Não foi possível realizar a conversão: " + e.getMessage());
            return 0;
        }
    }
}
