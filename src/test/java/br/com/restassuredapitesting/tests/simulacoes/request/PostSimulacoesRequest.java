package br.com.restassuredapitesting.tests.simulacoes.request;

import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;

public class PostSimulacoesRequest {
    @Step("Insere uma nova simulação")
    public Response insereUmaSimulacao(JSONObject payload) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(Utils.validPayloadSimulacoes().toString())
                .post("simulacoes");
    }

    //Regra Atributo "Valor não pode ser vazio"
    @Step("Insere uma nova simulação quando o payload estiver inválido")
    public Response insereUmaSimulacaoMalFormatado(JSONObject payloadBad) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(payloadBad.toString())
                .post("simulacoes");
    }

    //Regra "Parcelas deve ser igual ou maior que 2"
    @Step("Insere uma nova simulação quando o múmero Parcelas é Inválido")
    public Response insereUmaSimulacaoNumeroParcelasInvalido(JSONObject payloadBad) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(Utils.validPayloadRegraParcelasSimulacoes().toString())
                .post("simulacoes");
    }

    //Regra "Valor deve ser menor ou igual a R$ 40.000"
    @Step("Insere uma nova simulação quando o Valor é Inválido")
    public Response insereUmaSimulacaoValorInvalido(JSONObject payloadBad) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(Utils.validPayloadRegraValorSimulacoes().toString())
                .post("simulacoes");
    }

    @Step("Insere uma Simulação Existente")
    public Response insereUmaSimulacaoExistente(JSONObject payload) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(Utils.validPayloadSimulacoes().toString())
                .post("simulacoes");
    }
}
