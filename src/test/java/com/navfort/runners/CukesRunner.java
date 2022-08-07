package com.navfort.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                //"pretty",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/cucumber/cucumber.json"
        },
        features = "src/test/resources/features",
        glue = "com/navfort/step_definitions",
        dryRun = false,
        tags = "@PERF-1648",
        publish = false

)
public class CukesRunner {
}
