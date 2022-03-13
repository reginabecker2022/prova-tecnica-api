package br.com.restassuredapitesting.tests.simulacoes.tests;

import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.simulacoes.request.PostSimulacoesRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import static org.hamcrest.Matchers.*;

@Feature("Simulacoes")
public class PostSimulacoesTest extends BaseTest {
    PostSimulacoesRequest postSimulacoesRequest = new PostSimulacoesRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Insere uma nova simulação")
    public void validarInsereUmaSimulacao() throws Exception {

        postSimulacoesRequest.insereUmaSimulacao(Utils.validPayloadSimulacoes()).then()
                .statusCode(201)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Insere uma nova simulação quando o payload estiver inválido")
    public void validarInsereUmaSimulacaoMalFormatado() throws Exception {

        postSimulacoesRequest.insereUmaSimulacaoMalFormatado(Utils.validPayloadMalFormatadoSimulacoes()).then()
                .statusCode(400)
                .body("size()", greaterThan(0));
    }

    //Regra "Parcelas deve ser igual ou maior que 2"
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Insere uma nova simulação quando o múmero Parcelas é Inválido")
    public void validarInsereUmaSimulacaoNumeroParcelasInvalido() throws Exception {

        postSimulacoesRequest.insereUmaSimulacaoNumeroParcelasInvalido(Utils.validPayloadRegraParcelasSimulacoes()).then()
                .statusCode(400)
                .body("size()", greaterThan(0));
    }

    //Regra "Valor deve ser menor ou igual a R$ 40.000"
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Insere uma nova simulação quando o Valor é Inválido")
    public void validarInsereUmaSimulacaoValorInvalido() throws Exception {

        postSimulacoesRequest.insereUmaSimulacaoValorInvalido(Utils.validPayloadRegraValorSimulacoes()).then()
                .statusCode(400)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Insere uma Simulação Existente")
    public void validarInsereUmaSimulacaoExistente() throws Exception {

        postSimulacoesRequest.insereUmaSimulacao(Utils.validPayloadSimulacoes()).then()
                .statusCode(400)
                .body("size()", greaterThan(0));
    }
}
