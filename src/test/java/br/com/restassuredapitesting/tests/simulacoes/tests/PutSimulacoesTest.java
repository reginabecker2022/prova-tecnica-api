package br.com.restassuredapitesting.tests.simulacoes.tests;

import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.simulacoes.request.GetSimulacoesRequest;
import br.com.restassuredapitesting.tests.simulacoes.request.PutSimulacoesRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import static org.hamcrest.Matchers.greaterThan;

@Feature("Simulacoes")
public class PutSimulacoesTest extends BaseTest {
    PutSimulacoesRequest putSimulacoesRequest = new PutSimulacoesRequest();
    GetSimulacoesRequest getSimulacoesRequest = new GetSimulacoesRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Alterar uma Simulação")
    public void validarAlterarUmaSimulacao() throws Exception {

        putSimulacoesRequest.alterarUmaSimulacao(Utils.validPayloadAlterarSimulacoes()).then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    //Regra "Parcelas deve ser igual ou maior que 2"
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Alterar uma Simulação quando o múmero Parcelas é Inválido")
    public void validarAlterarUmaSimulacaoNumeroParcelasInvalido() throws Exception {

        putSimulacoesRequest.alterarUmaSimulacaoNumeroParcelasInvalido(Utils.validPayloadRegraParcelasSimulacoes()).then()
                .statusCode(400)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Alterar uma Simulação Inexistente")
    public void validarAlterarUmaSimulacaoInexistente() throws Exception {

        putSimulacoesRequest.alterarUmaSimulacaoInexistente(Utils.validPayloadSimulacoes()).then()
                .statusCode(404)
                .body("size()", greaterThan(0));
    }
}
