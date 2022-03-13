package br.com.restassuredapitesting.utils;
import org.json.simple.JSONObject;

public class Utils {

    public static JSONObject validPayloadSimulacoes() {
        JSONObject payload = new JSONObject();
        payload.put("nome", "Regina Becker");
        payload.put("cpf", "93487207087");
        payload.put("email", "regina.becker@cwi.com.br");
        payload.put("valor", 10.000);
        payload.put("parcelas", 2);
        payload.put("seguro", "true");

        return payload;
    }

    public static JSONObject validPayloadAlterarSimulacoes() {
        JSONObject payloadAlterar = new JSONObject();
        payloadAlterar.put("nome", "Regina Becker");
        payloadAlterar.put("cpf", "93487207087");
        payloadAlterar.put("email", "regina.becker@cwi.com.br");
        payloadAlterar.put("valor", 10.000);
        payloadAlterar.put("parcelas", 25);
        payloadAlterar.put("seguro", "false");

        return payloadAlterar;
    }

    public static JSONObject validPayloadMalFormatadoSimulacoes() {
        JSONObject payloadBad = new JSONObject();
        payloadBad.put("nome", "Regina Becker");
        payloadBad.put("cpf", "93487207087");
        payloadBad.put("email", "regina.becker@cwi.com.br");
        payloadBad.put("parcelas", 2);
        payloadBad.put("seguro", "true");

        return payloadBad;
    }

    public static JSONObject validPayloadRegraParcelasSimulacoes() {
        JSONObject payloadParcelas = new JSONObject();
        payloadParcelas.put("nome", "Regina Becker");
        payloadParcelas.put("cpf", "93487207087");
        payloadParcelas.put("email", "regina.becker@cwi.com.br");
        payloadParcelas.put("valor", 10.000);
        payloadParcelas.put("parcelas", 1);
        payloadParcelas.put("seguro", "true");

        return payloadParcelas;
    }

    public static JSONObject validPayloadRegraValorSimulacoes() {
        JSONObject payloadValor = new JSONObject();
        payloadValor.put("nome", "Regina Becker");
        payloadValor.put("cpf", "93487207087");
        payloadValor.put("email", "regina.becker@cwi.com.br");
        payloadValor.put("valor", 100.000);
        payloadValor.put("parcelas", 12);
        payloadValor.put("seguro", "true");

        return payloadValor;
    }

    public static  String getContractsBasePath(String pack, String contract) {
        return System.getProperty("user.dir")
                + "/src/test/java/br/com/restassuredapitesting/tests/"
                + pack
                + "/contracts/"
                + contract
                + ".json";
    }
}
