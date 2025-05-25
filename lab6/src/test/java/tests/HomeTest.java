package tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import pages.HomePage;

public class HomeTest extends TestBase {

    @Test
    public void testPageTitle() {
        driver.get("https://www.nexusmods.com/");
        var homePage = new HomePage(driver); // page object
        String actualTitle = homePage.getTitleText();
        Assert.assertEquals(actualTitle, "Nexus Mods"); // expected, actual
    }

    @Test
    public void testFindModSkyrim() {
        final String expectedMods = "skyrim";
        driver.get("https://www.nexusmods.com/");
        var homePage = new HomePage(driver); // page object
        String actualMods = homePage.findMod(expectedMods);
        Assert.assertTrue(actualMods.contains(expectedMods));
    }

    @Test
    public void testFindModValheim() {
        final String expectedMods = "valheim";
        driver.get("https://www.nexusmods.com/");
        var homePage = new HomePage(driver); // page object
        String actualMods = homePage.findMod(expectedMods);
        Assert.assertTrue(actualMods.contains(expectedMods));
    }

    @Test
    public void testFindModLC() {
        final String expectedMods = "lethal company";
        driver.get("https://www.nexusmods.com/");
        var homePage = new HomePage(driver); // page object
        String actualMods = homePage.findMod(expectedMods);
        Assert.assertTrue(actualMods.contains(expectedMods));
    }
    
    @Test
    public void testFindModASC() {
        final String expectedMods = "assassin's creed";
        driver.get("https://www.nexusmods.com/");
        var homePage = new HomePage(driver); // page object
        String actualMods = homePage.findMod(expectedMods);
        Assert.assertTrue(actualMods.contains(expectedMods));
    }
}
