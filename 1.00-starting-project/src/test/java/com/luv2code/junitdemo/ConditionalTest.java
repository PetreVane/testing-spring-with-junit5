package com.luv2code.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
public class ConditionalTest {

    @Test
    @Disabled
    void basicDisabledTest() {
        System.out.println("Running basic test");
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void conditionalTest() {
        System.out.println("Running test on Mac only");
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void conditionalTest2() {
        System.out.println("Running test on Linux only");
    }

    @Test
    @EnabledOnOs({OS.MAC, OS.LINUX})
    void conditionalTest3() {
        System.out.println("Running test on Mac and Linux only");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void enabledOnJRE() {
        System.out.println("This test only runs on JRE 8");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void enabledOnJRE2() {
        System.out.println("This test only runs on JRE 11");
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_17)
    void enabledOnJavaRange() {
        System.out.println("This test only runs on JRE ranging between 11 and 17");
    }

    @Test
    @EnabledIfSystemProperty(named ="SYSTEM_PROPERTY", matches = "CI_DEPLOYMENT_SECRET")
    void enabledOnSystemProperty() {
        System.out.println("Runs only if system property is enabled");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "DATABASE_PASSWORD",matches = "PASSWORD")
    void enabledOnEnvironmentProperty() {
        System.out.println("Runs only if a certain environment property is present / enabled");
    }
}

