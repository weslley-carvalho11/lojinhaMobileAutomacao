package telas;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioAdicionarProdutoTela {
    private WebDriver app;

    public FormularioAdicionarProdutoTela(WebDriver app) {
        this.app = app;
    }

    public FormularioAdicionarProdutoTela preencherNome(String produtoNome) {
        app.findElement(By.id("com.lojinha:id/productName")).click();
        app.findElement(By.id("com.lojinha:id/productName")).findElement(By.id("com.lojinha:id/editText")).sendKeys(produtoNome);
        return this;
    }

    public FormularioAdicionarProdutoTela preencherValor(String produtoValor) {
        app.findElement(By.id("com.lojinha:id/productValue")).click();
        app.findElement(By.id("com.lojinha:id/productValue")).findElement(By.id("com.lojinha:id/editText")).sendKeys(produtoValor);
        return this;
    }

    public FormularioAdicionarProdutoTela preencherCor(String produtoCor) {
        app.findElement(By.id("com.lojinha:id/productColors")).click();
        app.findElement(By.id("com.lojinha:id/productColors")).findElement(By.id("com.lojinha:id/editText")).sendKeys(produtoCor);
        return this;
    }

    public FormularioAdicionarProdutoTela clicarNoBotadoAdicionarProduto() {
        app.findElement(By.id("com.lojinha:id/saveButton")).click();
        return this;
    }
    
    public FormularioAdicionarProdutoTela validarMensagemDeValorInvalido(){
        String mensagemApresentada = app.findElement(By.xpath("//android.widget.Toast")).getText();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
        return this;
    }
}
