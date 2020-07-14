package ikas.TestNG;



import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.bcel.generic.Select;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;


public class donanimMarketUrunSatinAlma {

    protected WebDriver driver;
    public static String loginUrl = "https://app-dev.ikas.com/#/login";


    @BeforeTest
    public void setUp() {

        try {

            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            System.setProperty("webdriver.chrome.driver", "/Users/nesli/ikasTestNG/Driver/chromedriver 3");
            driver = new ChromeDriver(capabilities);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            //dynamic wait
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test (priority=2)
    public void marketurunsatinal() {

        try {

            //login
            driver.get(loginUrl);
            driver.findElement(name("email")).sendKeys("nesli.necipoglu+1@ikas.com");
            Thread.sleep(1000);
            driver.findElement(name("password")).sendKeys("123=ilsen");
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/form/div[3]/button")).click();
            Thread.sleep(5000);
            //terminale git
            driver.findElement(xpath("/html/body/div[1]/div/div[2]/div/div/button")).click(); // yönetici
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[1]/div/div[2]/div/ul/li[2]/a")).click(); //ayarlar
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[1]/main/div/div[1]/div/a[3]")).click(); // lisanslar
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[1]/main/div/div[1]/div/a[4]")).click(); // Donanım Market
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[1]/main/div/div[2]/div/div[2]/div[1]/div[1]/div[2]/div")).click(); //ürün satın al
            driver.findElement(xpath("/html/body/div[1]/main/div/div[2]/div/div[1]/div")).click(); // alışverişi tamamla
            Thread.sleep(5000);
            driver.findElement(xpath("/html/body/div[1]/main/div/div[2]/div/div[1]/div/div[3]/div/div[2]")).click(); //devam et

            Thread.sleep(5000);
            driver.findElement(xpath("/html/body/div[1]/main/div/div[2]/div/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]/div")).click(); //başka bir kart kullan
            Thread.sleep(2000);


            // Hatalı kart kodları

            //HATALI KART GİRİŞİ-1
            //kart numarası gir

            String hataliKartNumaralari[]= {"5406670000000009","4111111111111129","4129111111111111","4151111111111112","4127111111111113","4126111111111114","4125111111111115","4124111111111116","4123111111111117","4130111111111118","4121111111111119","4120111111111110","4130111111111118","4131111111111117","4141111111111115","4128111111111112","4111111111111129","4151111111111393","5406670000000009"};
            Random hatalikartrand = new Random();
            int num = hatalikartrand.nextInt(hataliKartNumaralari.length);

            String hataliKart = hataliKartNumaralari[num];

            System.out.println("Birinci Hatalı Kart Numarası= " + hataliKart);

            driver.findElement(xpath("//*[@id=\"credit_card_number\"]")).sendKeys(hataliKart);
            Thread.sleep(1000);

            //kart üzerindeki isim


            driver.findElement(xpath("//*[@id=\"card_holder\"]")).sendKeys("Ahmet Yıldırım");
            //son kullanma tarihi
            Thread.sleep(1000);

            driver.findElement(xpath("//*[@id=\"card_expire_date\"]")).sendKeys("0525");

            //cvv
            Thread.sleep(1000);
            driver.findElement(xpath("//*[@id=\"card_cvv\"]")).sendKeys("123");
            //ödemeyi tamamla
            Thread.sleep(3000);

            driver.findElement(xpath("/html/body/div[1]/main/div/div[2]/div/div[1]/div/div[3]/div/div[2]/div[2]/span")).click();  //ödemeyi tamamla

            //HATALI KART GİRİŞİ-2
            Thread.sleep(3000);
            driver.findElement(xpath("//*[@id=\"credit_card_number\"]")).clear();
            Thread.sleep(1000);

            String hataliKartNumaralari2[]= {"5406670000000009","4111111111111129","4129111111111111","4151111111111112","4127111111111113","4126111111111114","4125111111111115","4124111111111116","4123111111111117","4130111111111118","4121111111111119","4120111111111110","4130111111111118","4131111111111117","4141111111111115","4128111111111112","4111111111111129","4151111111111393","5406670000000009"};
            Random hatalikartrand2 = new Random();
            int number = hatalikartrand2.nextInt(hataliKartNumaralari2.length);

            String hataliKart2 = hataliKartNumaralari2[number];
            System.out.println("İkinci Hatalı Kart Numarası = "+ hataliKart2);
            driver.findElement(xpath("//*[@id=\"credit_card_number\"]")).sendKeys(hataliKart2);
            Thread.sleep(3000);

            driver.findElement(xpath("/html/body/div[1]/main/div/div[2]/div/div[1]/div/div[3]/div/div[2]/div[2]/span")).click();  //ödemeyi tamamla

            //DOĞRU KART GİRİŞİ

            Thread.sleep(3000);
            driver.findElement(xpath("//*[@id=\"credit_card_number\"]")).clear();
            Thread.sleep(3000);

            String dogruKartNumaralari[]= {"5890040000000016","4766620000000001","4987490000000002","5170410000000004","4475050000000003","5504720000000003","4543590000000006","4157920000000002","5168880000000002"};
            Random dogrukartrand = new Random();
            int n = dogrukartrand.nextInt(dogruKartNumaralari.length);
            Thread.sleep(3000);
            String dogruKart = dogruKartNumaralari[n];
            System.out.println("Doğru Kart Numarası = "+ dogruKart);
            driver.findElement(xpath("//*[@id=\"credit_card_number\"]")).sendKeys(dogruKart);
            Thread.sleep(3000);

            driver.findElement(xpath("/html/body/div[1]/main/div/div[2]/div/div[1]/div/div[3]/div/div[2]/div[2]/span")).click();  // ödeme yap
            Thread.sleep(3000);
            //driver.findElement(xpath("/html/body/div[1]/main/div/div[1]/div/a[5]")).click(); // ödemeler



        }



        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AfterTest
    public void tearDown() throws Exception {

    }
}

