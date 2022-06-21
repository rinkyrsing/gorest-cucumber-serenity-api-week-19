package in.co.gorest.runner;


import cucumber.api.CucumberOptions;
import in.co.gorest.testbase.TestBase;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/java/resources/feature",
        glue = "in/co/gorest",
        tags = "@Users"
)
public class UsersRunner extends TestBase {

}
