package br.com.restassuredapitesting.tests.simulacoes.tests;

import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.simulacoes.request.DeleteSimulacoesRequest;
import br.com.restassuredapitesting.tests.simulacoes.request.GetSimulacoesRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Feature("Simulacoes")
public class DeleteSimulacoesTest extends BaseTest {
    DeleteSimulacoesRequest deleteSimulacoesRequest = new DeleteSimulacoesRequest();
    GetSimulacoesRequest getSimulacoesRequest = new GetSimulacoesRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Remove uma simulação existente através do CPF.")
    public void validarexcluirUmaSimulacao() throws Exception {
        //Do retorno getSimulacoesRequest.allSimulacao,
        //pegar a posição "2" do array[0,1,2] a Simulação que eu cadastrei
        //as primeiras são default do Sicredi
        int primeiroId = getSimulacoesRequest.allSimulacao().then().statusCode(200).extract().path("[2].id");

        deleteSimulacoesRequest.excluirUmaSimulacao(primeiroId, Utils.validPayloadSimulacoes()).then()
              .statusCode(200);
    }
}
