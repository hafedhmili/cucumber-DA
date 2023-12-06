# Cucumber-Java Skeleton

This is the simplest possible build script setup for Cucumber using Java.
There is nothing fancy like a webapp or browser testing. All this does is to show
you how to install and run Cucumber!

There is a single feature file with one scenario. The scenario has three steps,
two of them pending. See if you can make them all pass!

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
