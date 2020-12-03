package utilities;


import com.cucumber.listener.Reporter;
import org.testng.*;


public class TestNGListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Reporter.setTestRunnerOutput("<b>Test failure</b>");
        Reporter.setTestRunnerOutput("<br>Name : " + iTestResult.getName());
        Reporter.setTestRunnerOutput("<br>Status : " + iTestResult.getStatus());
        Reporter.setTestRunnerOutput("<br>Method : " + iTestResult.getMethod());
        Reporter.setTestRunnerOutput("<br>TestClass : " + iTestResult.getTestClass());
        Reporter.setTestRunnerOutput("<br>TestContext : " + iTestResult.getTestContext());
        Reporter.setTestRunnerOutput("<br>");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

        Reporter.setTestRunnerOutput("<b>Test Skipped</b>");
        Reporter.setTestRunnerOutput("<br>Name : " + iTestResult.getName());
        Reporter.setTestRunnerOutput("<br>Status : " + iTestResult.getStatus());
        Reporter.setTestRunnerOutput("<br>Method : " + iTestResult.getMethod());
        Reporter.setTestRunnerOutput("<br>TestClass : " + iTestResult.getTestClass());
        Reporter.setTestRunnerOutput("<br>TestContext : " + iTestResult.getTestContext());
        Reporter.setTestRunnerOutput("<br>");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
