package Support;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "Definitions",
        plugin={"json:src/test/resources/report/cucumber_report.json"},
        //plugin = {"json:target/cucumberreport/cucumber.json","html:target/cucumberreport/cucumber-report.html"},
        tags = "@prueba"
)
public class runTest {
    @AfterClass
    public static void finish(){
        try {
            System.out.println("Generando Reporte");
            String[] cmd={"cmd.exe","/c","npm run report"};
            Runtime.getRuntime().exec(cmd);
            System.out.println("Reporte generado con Exito");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
