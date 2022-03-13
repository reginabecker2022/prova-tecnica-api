package br.com.restassuredapitesting.tests.healthcheck.tests;
import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.healthcheck.requests.GetHealthCheckRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

@Feature("Simulacoes - HealthCheck")
public class GetHealthCheckTest extends BaseTest {
    GetHealthCheckRequest getHealthCheckRequest = new GetHealthCheckRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Verificar se API de Simulacoes está online")
    public void validarAPISimulacoesOnline() throws Exception {
        getHealthCheckRequest.healthCheck().then()
                .statusCode(200);
    }
}


