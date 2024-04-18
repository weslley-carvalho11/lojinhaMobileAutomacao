package modulos.produto;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@DisplayName("Testes Mobile do Módulo de Produto")
public class ProdutoTest {
    @DisplayName("Validação do Valor de Produto Não Permitido")
    @Test
    public void testValidacaoDoValorProdutoNaoPermitido() throws MalformedURLException {
        //Abrir o app
        DesiredCapabilities capacidades = new DesiredCapabilities();
        capacidades.setCapability("deviceName", "Google Pixel");
        capacidades.setCapability("platformName", "Android");
        capacidades.setCapability("udid", "192.168.56.108:5555");
        capacidades.setCapability("appPackage", "com.lojinha");
        capacidades.setCapability("appActivity", "com.lojinha.ui.MainActivity");
        capacidades.setCapability("app", "C:\\Users\\Wesll\\Desktop\\CursoMentoria\\Módulo 11 - Testes Mobile com Android\\Lojinha+Android+Nativa\\lojinha-nativa.apk");

        WebDriver app = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidades);
        app.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        //Fazer login
        app.findElement(By.id("com.lojinha:id/user")).click();
        app.findElement(By.id("com.lojinha:id/user")).findElement(By.id("com.lojinha:id/editText")).sendKeys("weslleyNovo");

        app.findElement(By.id("com.lojinha:id/password")).click();
        app.findElement(By.id("com.lojinha:id/password")).findElement(By.id("com.lojinha:id/editText")).sendKeys("cebolinhaemonica");

        app.findElement(By.id("com.lojinha:id/loginButton")).click();

        //Abrir o formulário de novo produto
        app.findElement(By.id("com.lojinha:id/floatingActionButton")).click();

        //Cadastrar um produto com valor inválido
        app.findElement(By.id("com.lojinha:id/productName")).click();
        app.findElement(By.id("com.lojinha:id/productName")).findElement(By.id("com.lojinha:id/editText")).sendKeys("Samsung Book E30");

        app.findElement(By.id("com.lojinha:id/productValue")).click();
        app.findElement(By.id("com.lojinha:id/productValue")).findElement(By.id("com.lojinha:id/editText")).sendKeys("700001");

        app.findElement(By.id("com.lojinha:id/productColors")).click();
        app.findElement(By.id("com.lojinha:id/productColors")).findElement(By.id("com.lojinha:id/editText")).sendKeys("Prata, Preto");

        app.findElement(By.id("com.lojinha:id/saveButton")).click();

        //Validar que a mensagem de valor inválido foi apresentada
        String mensagemApresentada = app.findElement(By.xpath("//android.widget.Toast")).getText();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }
}
