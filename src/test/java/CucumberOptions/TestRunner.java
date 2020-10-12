package CucumberOptions;


//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(
		features ="src/test/java/Features/Login.feature",
		glue = "StepsDefinitions")

public class TestRunner extends AbstractTestNGCucumberTests {


}
