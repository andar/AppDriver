package com.prototest.appdriver;

/**
 * Created by Brian on 7/7/2014.
 */

import com.google.inject.Inject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Guice;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Dictionary;
import java.util.Enumeration;

@Listeners({TimestampedHTMLReporter.class,
        TimestamppedXMLReporter.class,
        org.uncommons.reportng.JUnitXMLReporter.class,
        VerificationsListener.class, /*ScreenshotListener.class*/})
public class TestSuite {

    @Inject
    Config.Settings.RuntimeSettings config;

    @Inject
    Logger logger;

    @Inject
    PageObjectFactory pageObjectFactory;


    private static final ThreadLocal<TestContainer> tests = new ThreadLocal<TestContainer>();

    void testSuiteBeforeMethod(Method method) {
        logger.info("Starting test " + method.getName());
        Verifications.clearVerifications();
        tests.set(new TestContainer(method.getName()));
    }

    void testSuiteAfterMethod(Method method) {
        logger.info("Ending test " + method.getName());
        tests.remove();
    }

    void testSuiteBeforeTest() {
        createReportDirectory();
    }

    void createReportDirectory() {
        String testDir = "test-output";
        File report = new File(testDir);
        report.mkdir();
    }
}
