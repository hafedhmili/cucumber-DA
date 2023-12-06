# Cucumber-Java Skeleton

This is a simple build script setup for Cucumber using Java.
There is nothing fancy like a webapp or browser testing. All this does is to show
you how to install and run Cucumber!

There are two feature files, inscription.feature with one scenario, and evaluation_academique.feature, with two scenarios, and one common background section.

You can use the existing features and scenarios as a model to:
1.  propose your own features and scenarios, in a file with extension .feature, to be included in the directory ./src/test/resources/ca/uqam/info/mgl7460
2.  Define your own classes to supply the Java code for the various Given's, When's, and Then's. These classes should go into the directory ./src/test/java/ca/uqam/info/mgl7460. Note that:
    a.  if you don't supply the Java classes, Cucumber will tell you which steps are missing, and will propose a code template for you
    b.  (For the time being) You should group all the methods corresponding to a feature in the same Java class. If you spread the code in separate Java classes, you don't know which order the classes will be loaded, instantiated, and executed.

## Get the code

Git:

    git clone https://github.com/hafedhmili/cucumber-DA.git
    cd cucumber-DA

## Use Maven

Open a command window and run:

    cd maven
    ./mvnw test

This runs Cucumber features using Cucumber's JUnit Platform Engine. The `Suite`
annotation on the `RunCucumberTest` class tells JUnit to kick off Cucumber.


## Overriding options

The Cucumber runtime uses configuration parameters to know what features to run,
where the glue code lives, what plugins to use etc. When using JUnit, these
configuration parameters are provided through the `@ConfigurationParameter`
annotation on your test.

For available parameters see: `io.cucumber.junit.platform.engine.Constants`

Note: Add `-Dcucumber.plugin=pretty` to get test reports. Maven does not report
tests without a class.
