package tma.sharing.Utils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class ReportHandler {

    public static void customReport() {

        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/login.json");

        Properties properties = PropertiesHandler.loadApplicationProperties();

        String buildNumber = "2";
        String projectName = "Cucumber Project";
        String platform = System.getProperty("os.name");
        String browser = properties.getProperty("browser.default").toUpperCase();

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);

        // Optional configuration - check javadoc for details
        configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
        configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);

        // Do not make scenario failed when step has status SKIPPED
        configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
        configuration.setBuildNumber(buildNumber);

        // Additional metadata presented on main page
        configuration.addClassifications("Platform", platform);
        configuration.addClassifications("Browser", browser);
        configuration.addClassifications("Branch", "master");

        // optionally add metadata presented on main page via properties file
//        List<String> classificationFiles = new ArrayList<>();
//        classificationFiles.add("properties-1.properties");
//        classificationFiles.add("properties-2.properties");
//        configuration.addClassificationFiles(classificationFiles);

        // optionally specify qualifiers for each of the report json files
//        configuration.addPresentationModes(PresentationMode.PARALLEL_TESTING);
//        configuration.setQualifier("cucumber-report-1","First report");
//        configuration.setQualifier("cucumber-report-2","Second report");

        ReportBuilder reportBuilder= new ReportBuilder(jsonFiles,configuration);
        Reportable result= reportBuilder.generateReports();

        // and here validate 'result' to decide what to do if report has failed
        System.out.println("Passed scenarios: " + result.getPassedScenarios());
        System.out.println("Report generated");

    }

}
