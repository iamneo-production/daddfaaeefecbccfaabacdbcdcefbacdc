package stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UserLoginSteps {
    private WebDriver driver;
    @Given("the user is on the home page")
    public void userIsOnHomePage() {
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        driver = new ChromeDriver();
        driver.get("URL_of_home_page");
    }

    @When("the user navigates to the login page")
    public void userNavigatesToLoginPage() {
        WebElement loginLink = driver.findElement(By.linkText("Login"));
        loginLink.click();
    }

    @When("enters the username {string}")
    public void entersUsername(String username) {
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);
    }

    @When("enters the password {string}")
    public void entersPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
    }

    @When("clicks the \"Login\" button")
    public void clicksLoginButton() {
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }

    @Then("the user should be logged in")
    public void userShouldBeLoggedIn() {
        WebElement dashboard = driver.findElement(By.id("dashboard"));
        Assert.assertTrue(dashboard.isDisplayed());
    }

    @Then("a welcome message is displayed")
    public void welcomeMessageIsDisplayed() {
        WebElement welcomeMessage = driver.findElement(By.id("welcomeMessage"));
        Assert.assertTrue(welcomeMessage.isDisplayed());
    }

    // Close the browser after the scenario
    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}

