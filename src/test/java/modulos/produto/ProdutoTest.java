package modulos.produto;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import telas.LoginTela;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@DisplayName("Testes Mobile do Módulo de Produto")
public class ProdutoTest {
    private WebDriver app;

    @BeforeEach
    public void beforeEach() throws MalformedURLException {
        DesiredCapabilities capacidades = new DesiredCapabilities();
        capacidades.setCapability("deviceName", "Google Pixel");
        capacidades.setCapability("platformName", "Android");
        capacidades.setCapability("udid", "192.168.56.108:5555");
        capacidades.setCapability("appPackage", "com.lojinha");
        capacidades.setCapability("appActivity", "com.lojinha.ui.MainActivity");
        capacidades.setCapability("app", "C:\\Users\\Wesll\\Desktop\\CursoMentoria\\Módulo 11 - Testes Mobile com Android\\Lojinha+Android+Nativa\\lojinha-nativa.apk");

        this.app = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidades);
        this.app.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    @DisplayName("Validação do Valor de Produto Não Permitido")
    @Test
    public void testValidacaoDoValorProdutoNaoPermitido() {

        //Fazer login
        String mensagemApresentada = new LoginTela(app).
                preencherUsuario("weslleyNovo").
                preencherSenha("cebolinhaemonica").
                submeterLogin()
                .abrirTelaDeAdicicaoDeProduto()
                .preencherNomeProduto("Notebook Samsung Book E30")
                .preencherValorProduto("700001")
                .preencherCorProdutos("Prata")
                .submeterComErro()
                .obterMensagemDeErro();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }

    @AfterEach
    public void afterEach() {
        app.quit();
    }
}
