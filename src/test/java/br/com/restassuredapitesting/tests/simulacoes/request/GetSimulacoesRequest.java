package br.com.restassuredapitesting.tests.simulacoes.request;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetSimulacoesRequest {
    @Step("Consultar todas a simulações cadastradas.")
    public Response allSimulacao() {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("simulacoes");
    }

    @Step("Consultar uma Simulação pelo CPF Existente.")
    public Response simulacaoCPFExistente() {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("simulacoes/93487207087");
    }

    @Step("Consultar uma Simulação pelo CPF Inexistente.")
    public Response simulacaoCPFInexistente() {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("simulacoes/55568173087");
    }
}
