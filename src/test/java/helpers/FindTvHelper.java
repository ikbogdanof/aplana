package helpers;

import forms.YandexPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FindTvHelper {
    private WebDriver driver = new ChromeDriver();
    private YandexPage yandexPage = PageFactory.initElements(driver, YandexPage.class);

    public void startBrowser(String url) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\job\\test\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    public void goToMarket() throws Exception {
        yandexPage.market.click();
    }

    public void closeBrowser() throws Exception {
        driver.quit();
    }

    public void chooseTv() {
        Actions actions = new Actions(driver);
        actions.moveToElement(yandexPage.electronics).build().perform();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOf(yandexPage.tv));
        yandexPage.tv.click();
    }

    public void chooseHeadPhone() {
        Actions actions = new Actions(driver);
        actions.moveToElement(yandexPage.electronics).build().perform();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOf(yandexPage.headPhone));
        yandexPage.headPhone.click();
    }

    public void showBy12() {
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOf(yandexPage.showBy));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        yandexPage.showBy.click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOf(yandexPage.showBy12));
        yandexPage.showBy12.click();
    }

    public void setPrice(String value) {
        yandexPage.price.sendKeys(value);
    }

    public void chooseProducer(String value) {
        String listXpath = String.format("//span[text()='%s']", value);
        driver.findElement(By.xpath(listXpath)).click();
    }

    public String productCount(){
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOf(yandexPage.productCount));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String text = yandexPage.productCount.getAttribute("data-bem");
        System.out.println(text);
        return text;
    }
    public String getNameProductFromCard(int number){
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOf(yandexPage.firstCard));

        String listXpath = String.format("(//div[@class='n-snippet-card2__title'])['%s']/a", number);
        String text =driver.findElement(By.xpath(listXpath)).getText();
        System.out.println(text);
        return text;
    }

    public String getNameProductFromCardTv(int number){
        String listXpath = String.format("(//div[@class='n-snippet-card2__title'])['%s']/a", number);
        String text =driver.findElement(By.xpath(listXpath)).getText();
        System.out.println(text);
        return text;
    }
    public void findProduct(String value) {
        yandexPage.searchLine.sendKeys(value);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        yandexPage.searchButton.click();
    }
    public String getNameProductTv(){
        String text = yandexPage.productNameTv.getText();
        return text;
    }

    public String getNameProductHeadPhone(){
        String text = yandexPage.productNameHeadPhone.getText();
        return text;
    }
    public void regionOkButtonClick(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        yandexPage.regionOkButton.click();
    }
    public void viewListButtonClick(){
        yandexPage.viewListButton.click();
    }
}
