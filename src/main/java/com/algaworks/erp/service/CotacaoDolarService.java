package com.algaworks.erp.service;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.enterprise.context.ApplicationScoped;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@ApplicationScoped
public class CotacaoDolarService {

    public double obterCotacaoDolar() {
        String apiUrl = "https://economia.awesomeapi.com.br/json/last/USD-BRL";
        
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parseando a resposta JSON
                JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();
                String valorDolar = jsonObject.getAsJsonObject("USDBRL").get("bid").getAsString();

                return Double.parseDouble(valorDolar);
            } else {
                throw new RuntimeException("Erro na conexão: Código de resposta " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao obter cotação do dólar: " + e.getMessage());
        }
    }
}
