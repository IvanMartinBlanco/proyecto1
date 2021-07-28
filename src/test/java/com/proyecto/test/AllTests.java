package com.proyecto.test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({"com.proyecto.test.controllers", "com.proyecto.test.service", "com.proyecto.test.service.patterns"})
public class AllTests {

}
