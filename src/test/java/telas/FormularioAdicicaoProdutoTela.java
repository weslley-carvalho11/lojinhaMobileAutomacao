package telas;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioAdicicaoProdutoTela extends BaseTela {

    public FormularioAdicicaoProdutoTela(WebDriver app) {
        super(app);
    }

    public FormularioAdicicaoProdutoTela preencherNomeProduto(String produtoNome) {
        app.findElement(By.id("com.lojinha:id/productName")).click();
        app.findElement(By.id("com.lojinha:id/productName")).findElement(By.id("com.lojinha:id/editText")).sendKeys(produtoNome);
        return this;
    }

    public FormularioAdicicaoProdutoTela preencherValorProduto(String produtoValor) {
        app.findElement(By.id("com.lojinha:id/productValue")).click();
        app.findElement(By.id("com.lojinha:id/productValue")).findElement(By.id("com.lojinha:id/editText")).sendKeys(produtoValor);
        return this;
    }

    public FormularioAdicicaoProdutoTela preencherCorProdutos(String produtoCor) {
        app.findElement(By.id("com.lojinha:id/productColors")).click();
        app.findElement(By.id("com.lojinha:id/productColors")).findElement(By.id("com.lojinha:id/editText")).sendKeys(produtoCor);
        return this;
    }

    public FormularioAdicicaoProdutoTela submeterComErro() {
        app.findElement(By.id("com.lojinha:id/saveButton")).click();
        return this;
    }

    public String obterMensagemDeErro() {
        return app.findElement(By.xpath("//android.widget.Toast")).getText();
    }
}
