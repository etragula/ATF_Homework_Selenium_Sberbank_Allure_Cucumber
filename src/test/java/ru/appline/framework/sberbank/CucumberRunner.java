package ru.appline.framework.sberbank;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm",
                "progress",
                "summary"},
        glue = {"ru/appline/framework/sberbank/steps"},
        features = {"src/test/resources/"},
        tags = {"@checkWrongMortgageInterestRate"}
)
public class CucumberRunner {
}