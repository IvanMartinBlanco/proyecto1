package com.proyecto.test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
//@SelectClasses({Nested.class, ConditionalTest.class})//Filtro por clase
//@SelectPackages({"com.example", "com.example2"})//Filtro paquete
//@IncludTags("calculations")//Filtro por etiquetas
//@SelectPackages({"com.example", "com.example2"})
@SelectPackages({"com.proyecto.test.controllers", "com.proyecto.test.service", "com.proyecto.test.service.patterns"})
public class AllTests {

}
