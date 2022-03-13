package br.com.restassuredapitesting.tests.simulacoes.request;

import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;

public class PutSimulacoesRequest {
    @Step("Alterar uma Simulação")
    public Response alterarUmaSimulacao(JSONObject payload) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(Utils.validPayloadAlterarSimulacoes().toString())
                .put("simulacoes/93487207087");
    }

    //Regra "Parcelas deve ser igual ou maior que 2"
    @Step("Alterar uma Simulação quando o múmero Parcelas é Inválido")
    public Response alterarUmaSimulacaoNumeroParcelasInvalido(JSONObject payload)  {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(Utils.validPayloadRegraParcelasSimulacoes().toString())
                .put("simulacoes/93487207087");
    }

    @Step("Alterar uma Simulação Inexistente")
    public Response alterarUmaSimulacaoInexistente(JSONObject payload)  {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(Utils.validPayloadSimulacoes().toString())
                .put("simulacoes/55568173087");
    }
}
