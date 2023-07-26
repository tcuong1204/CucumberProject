package tma.sharing.Utils;

import io.cucumber.java.*;

public class ScenarioHooks {

    BrowserHandler browserHandler = new BrowserHandler();

    @Before
    public void setup() {
        browserHandler.initBrowser();
    }

    @After
    public void cleanup() {
        browserHandler.closeBrowser();
    }

    @AfterAll
    public static void generateReport() {

        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new Thread(ReportHandler::customReport));
        System.out.println("Generating report");
    }

}
