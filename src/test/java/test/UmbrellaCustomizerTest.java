package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class UmbrellaCustomizerTest extends BaseTest {

    @Test
    public void testUploadValidLogoFile() {
        WebElement uploadButton = driver.findElement(By.className("upload-btn-title"));
        uploadButton.sendKeys("C:\\Users\\HP\\Downloads\\vecteezy_star-logo-review-png_28837135.jpg");
        WebElement logoPreview = driver.findElement(By.id("umbrella-preview-img"));
        assertTrue(logoPreview.isDisplayed());
    }

    @Test
    public void testChangeUmbrellaColorToPink() {
        WebElement pinkColorButton = driver.findElement(By.xpath("(//button[@name='color-option-button'])[2]"));
        pinkColorButton.click();
        WebElement umbrella = driver.findElement(By.id("umbrella-preview-img"));
        String color = umbrella.getCssValue("background-color");
        assertTrue(color.contains("pink"));
    }

    @Test
    public void testChangeUmbrellaColorToBlue() {
        WebElement blueColorButton = driver.findElement(By.xpath("(//button[@name='color-option-button'])[1]"));
        blueColorButton.click();
        WebElement umbrella = driver.findElement(By.id("umbrella-preview-img"));
        String color = umbrella.getCssValue("background-color");
        assertTrue(color.contains("blue"));
    }

    @Test
    public void testChangeUmbrellaColorToYellow() {
        WebElement yellowColorButton = driver.findElement(By.xpath("(//button[@name='color-option-button'])[3]"));
        yellowColorButton.click();
        WebElement umbrella = driver.findElement(By.id("umbrella-preview-img"));
        String color = umbrella.getCssValue("background-color");
        assertTrue(color.contains("yellow"));
    }

    @Test
    public void testPreviewLogoOnPinkUmbrella() {
        WebElement uploadButton = driver.findElement(By.className("upload-btn-title"));
        uploadButton.sendKeys("C:\\Users\\HP\\Downloads\\vecteezy_star-logo-review-png_28837135.png");
        WebElement pinkColorButton = driver.findElement(By.xpath("//button[@value='pink']"));
        pinkColorButton.click();
        WebElement logoPreview = driver.findElement(By.id("logoPreview"));
        assertTrue(logoPreview.isDisplayed());
        WebElement umbrella = driver.findElement(By.id("umbrella-preview-img"));
        String color = umbrella.getCssValue("background-color");
        assertTrue(color.contains("pink"));
    }

    @Test
    public void testUploadInvalidLogoFileFormat() {
        WebElement uploadButton = driver.findElement(By.className("upload-btn-title"));
        uploadButton.sendKeys("C:\\Users\\HP\\Downloads\\vecteezy_star-logo-review-png_28837135.doc");
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void testUploadOversizedLogoFile() {
        WebElement uploadButton = driver.findElement(By.className("upload-btn-title"));
        uploadButton.sendKeys("C:\\Users\\HP\\Downloads\\vecteezy_star-logo-review-png_28837135_1_optimized.png");
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void testNoLogoUpload() {
        WebElement previewButton = driver.findElement(By.id("previewButton"));
        previewButton.click();
        WebElement logoPreview = driver.findElement(By.id("logoPreview"));
        assertTrue(!logoPreview.isDisplayed());
    }

    @Test
    public void testIncompleteColorChange() {
        WebElement blueColorButton = driver.findElement(By.xpath("(//button[@name='color-option-button'])[1]"));
        blueColorButton.click();
        driver.navigate().refresh();
        WebElement umbrella = driver.findElement(By.id("umbrella-preview-img"));
        String color = umbrella.getCssValue("background-color");
        assertTrue(!color.contains("blue"));
    }

    @Test
    public void testConcurrentLogoUploads() {
        WebElement uploadButton1 = driver.findElement(By.className("upload-btn-title"));
        WebElement uploadButton2 = driver.findElement(By.className("upload-btn-title"));
        uploadButton1.sendKeys("C:\\Users\\HP\\Downloads\\vecteezy_star-logo-review-png_28837135.jpg");
        uploadButton2.sendKeys("C:\\Users\\HP\\Downloads\\vecteezy_star-logo-review-png_28837135.png");
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertTrue(errorMessage.isDisplayed());
    }
}