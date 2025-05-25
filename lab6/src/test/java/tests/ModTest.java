package tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import pages.ModPage;

public class ModTest extends TestBase {
    @Test
    public void testShowRequirements266() {
        driver.get("https://www.nexusmods.com/skyrimspecialedition/mods/266");
        var modPage = new ModPage(driver); // page object
        modPage.showRequirements();
    }

    @Test
    public void testDownloadMod266() {
        driver.get("https://www.nexusmods.com/skyrimspecialedition/mods/266");
        var modPage = new ModPage(driver); // page object
        String downloadModTitle = modPage.downloadMod();
        Assert.assertEquals(downloadModTitle, "Choose download type");
    }
    
    @Test
    public void testShowImages266() {
        driver.get("https://www.nexusmods.com/skyrimspecialedition/mods/266");
        var modPage = new ModPage(driver); // page object
        modPage.showImages();
    }

    @Test
    public void testShowRequirements11811() {
        driver.get("https://www.nexusmods.com/skyrim/mods/11811");
        var modPage = new ModPage(driver); // page object
        modPage.showRequirements();
    }

    @Test
    public void testDownloadMod11811() {
        driver.get("https://www.nexusmods.com/skyrim/mods/11811");
        var modPage = new ModPage(driver); // page object
        String downloadModTitle = modPage.downloadMod();
        Assert.assertEquals(downloadModTitle, "Choose download type");
    }
    
    @Test
    public void testShowImages11811() {
        driver.get("https://www.nexusmods.com/skyrim/mods/11811");
        var modPage = new ModPage(driver); // page object
        modPage.showImages();
    }

    @Test
    public void testDownloadMod607() {
        driver.get("https://www.nexusmods.com/skyrim/mods/607");
        var modPage = new ModPage(driver); // page object
        String downloadModTitle = modPage.downloadMod();
        Assert.assertEquals(downloadModTitle, "Choose download type");
    }
    
    @Test
    public void testShowImages607() {
        driver.get("https://www.nexusmods.com/skyrim/mods/607");
        var modPage = new ModPage(driver); // page object
        modPage.showImages();
    }

}
