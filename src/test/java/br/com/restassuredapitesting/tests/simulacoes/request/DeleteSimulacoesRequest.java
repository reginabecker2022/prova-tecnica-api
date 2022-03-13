package br.com.restassuredapitesting.tests.simulacoes.request;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;

public class DeleteSimulacoesRequest {
    @Step("Remove uma simulação existente através do CPF.")
    public Response excluirUmaSimulacao(int id, JSONObject payload) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .delete("simulacoes/" +id);
    }
}
