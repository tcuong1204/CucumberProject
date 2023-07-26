import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/Login.feature"},
        plugin = {
                "pretty", // make report readable format
                "html:target/login.html", // html report will be generated after running in target/ directory with name login.html
                "json:target/login.json"
        },
        tags = "", // Run with specific tag
        publish = true, // Public report
        name = {".with\\svalid."} // Run with scenario that match with regex

)
public class TestRunner {

}
