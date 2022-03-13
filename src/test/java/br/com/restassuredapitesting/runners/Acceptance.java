package br.com.restassuredapitesting.runners;

import br.com.restassuredapitesting.tests.restricoes.tests.GetRestricoesTest;
import br.com.restassuredapitesting.tests.healthcheck.tests.GetHealthCheckTest;
import br.com.restassuredapitesting.tests.simulacoes.tests.DeleteSimulacoesTest;
import br.com.restassuredapitesting.tests.simulacoes.tests.PostSimulacoesTest;
import br.com.restassuredapitesting.tests.simulacoes.tests.GetSimulacoesTest;
import br.com.restassuredapitesting.tests.simulacoes.tests.PutSimulacoesTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(br.com.restassuredapitesting.suites.Acceptance.class)
@Suite.SuiteClasses({
        GetRestricoesTest.class,
        GetHealthCheckTest.class,
        PostSimulacoesTest.class,
        GetSimulacoesTest.class,
        PutSimulacoesTest.class,
        DeleteSimulacoesTest.class
})
public class Acceptance {
}
