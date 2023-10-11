Tests root : src/test

End to End Web App Tests : src/test/java/ui
End to End Api Tests : src/test/java/api
End to End Mobile - Web Tests : src/test/java/mobile/web
End to End Mobile - Flutter App Tests : src/test/java/mobile/app

TestNG .xml located at test-suites

Change the <suite-xml> config in pom.xml to run different tests.

Device Config can be changed at src/test/resources/boyka-config.json

To run : **mvn clean test**