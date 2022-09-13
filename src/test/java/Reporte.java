import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;


public class Reporte {
    private WebDriver chromeDriver;
    String url = "https://www.grupobancolombia.com/";
    String pdfUrl;

    @Before
    public void abrirDriver() {

        //encontrar archivo exe de chronium
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\chromedriver.exe");

        //creamos opciones sobre nuestro driver
        ChromeOptions options = new ChromeOptions();
        options.setCapability("marionette", false);

        //nueva instancia de ChromeDriver
        chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().window().maximize();

        //definimos tiempo de espera hasta que aceptemos un timeout
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void generar_reporte() throws InterruptedException {
        //Abrimos una URL
        chromeDriver.get(url);
        Thread.sleep(2000);

        //Ingresamos a Información Corporativa
        chromeDriver.findElement(By.xpath("//a[@class='items-level-two'][contains(.,'Información Corporativa')]")).click();
        Thread.sleep(3000);

        //Cargamos el campo de email
        chromeDriver.findElement(By.xpath("(//a[contains(.,'Documentos de Interés')])[1]")).click();
        Thread.sleep(3000);

        //Cargamos el campo de contraseña
        chromeDriver.findElement(By.xpath("//a[contains(.,'2022')]")).click();
        Thread.sleep(5000);
        System.out.println("Test completed");

    }

    @After
    public void cerrarDriver() {
        //Cerrar ventana, apagar driver
        chromeDriver.quit();
    }
}