package br.com.restassuredapitesting.tests.restricoes.tests;

import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.suites.Contract;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.restricoes.request.GetRestricoesRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import java.io.File;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;

@Feature("Restricoes")
public class GetRestricoesTest extends BaseTest {
    GetRestricoesRequest getRestricoesRequest = new GetRestricoesRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Consultar CPF SEM Restrição")
    public void validarCPFSEMRestricao() throws Exception {
        getRestricoesRequest.semRestricoes().then()
                .statusCode(204);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Consultar CPF COM Restrição")
    public void validarCPFCOMRestricao() throws Exception {
        getRestricoesRequest.comRestricoes().then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("mensagem", containsString("O CPF 84809766080 tem problema"));
    }

    //Gerado o Schema pelo Site: https://www.jsonschema.net/home para restricoes.json
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category(Contract.class)
    @DisplayName("Garantir o contrato do retorno Consultar CPF COM Restrição")
    public void garantirContratoCPFCOMRestricao() throws Exception {
        getRestricoesRequest.comRestricoes().then()
                .statusCode(200)
                .assertThat()
                .body(
                        matchesJsonSchema(
                                new File(
                                        Utils.getContractsBasePath("restricoes", "restricoes")
                                )
                        )
                );
    }
}
