package br.com.restassuredapitesting.runners;

import br.com.restassuredapitesting.tests.restricoes.tests.GetRestricoesTest;
import br.com.restassuredapitesting.tests.simulacoes.tests.GetSimulacoesTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(br.com.restassuredapitesting.suites.Contract.class)
@Suite.SuiteClasses({
        GetRestricoesTest.class,
        GetSimulacoesTest.class
})
public class Contract {
}