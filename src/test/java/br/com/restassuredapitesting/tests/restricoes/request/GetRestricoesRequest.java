package br.com.restassuredapitesting.tests.restricoes.request;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetRestricoesRequest {
    @Step("Consultar CPF SEM restrição.")
    public Response semRestricoes() {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("restricoes/93487207087");
    }

    @Step("Consultar CPF COM restrição.")
    public Response comRestricoes() {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("restricoes/84809766080");
    }
}
