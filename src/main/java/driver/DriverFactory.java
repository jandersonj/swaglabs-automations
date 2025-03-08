package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

// aqui é parte da aula de conceitos avançados. isso tudo pode ser descartado e podemos usr o driver direto no stepDefinitions
public class DriverFactory {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createtDriver());
        }
        return webDriver.get();
    }

    private static WebDriver createtDriver(){
        WebDriver driver = null;

        //String browserType = "edge";

        switch (getBrowserType()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                edgeOptions.addArguments("--remote-allow-origins=*");
                driver = new EdgeDriver(edgeOptions);
                break;

        }

        driver.manage().window().maximize();
        return driver;
    }

    /* metodo para ler o arquivo de propriedades */
    private static String getBrowserType() {
        String browserType = null;
        //vaarivel p config do jenkings ler o browser
        String browserTypeRemoteValue = System.getProperty("browserType");

        try{

            if(browserTypeRemoteValue == null || browserTypeRemoteValue.isEmpty()){
                Properties prop = new Properties();
                FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
                prop.load(file);
                browserType =  prop.getProperty("browser").toLowerCase().trim();
            }else{

                browserType = browserTypeRemoteValue;
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return browserType;
    }



    public static void clearDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }
}




































