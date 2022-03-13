package br.com.restassuredapitesting.tests.simulacoes.tests;

import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.suites.Contract;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.simulacoes.request.GetSimulacoesRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import java.io.File;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;

@Feature("Simulacoes")
public class GetSimulacoesTest extends BaseTest {
    GetSimulacoesRequest getSimulacoesRequest = new GetSimulacoesRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Consultar todas a simulações cadastradas.")
    public void validarTodasSimulacoes() throws Exception {
        getSimulacoesRequest.allSimulacao().then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Consultar uma Simulação pelo CPF Existente")
    public void validarCPFSimulacaoExistente() throws Exception {
        getSimulacoesRequest.simulacaoCPFExistente().then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Consultar uma Simulação pelo CPF Inexistente.")
    public void validarCPFSimulacaoInexistente() throws Exception {
        getSimulacoesRequest.simulacaoCPFInexistente().then()
                .statusCode(404)
                .body("size()", greaterThan(0))
                .body("mensagem", containsString("CPF 55568173087 não encontrado"));
    }

    //Gerado o Schema pelo Site: https://www.jsonschema.net/home para simulacoes.json
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category(Contract.class)
    @DisplayName("Garantir o contrato do retorno Consultar uma Simulação pelo CPF Inexistente.")
    public void garantirContratoCPFCOMRestricao() throws Exception {
        getSimulacoesRequest.simulacaoCPFInexistente().then()
                .statusCode(404)
                .assertThat()
                .body(
                        matchesJsonSchema(
                                new File(
                                        Utils.getContractsBasePath("simulacoes", "simulacoes")
                                )
                        )
                );
    }
}
