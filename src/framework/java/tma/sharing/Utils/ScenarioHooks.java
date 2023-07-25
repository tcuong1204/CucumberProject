package tma.sharing.Utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;

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

}
