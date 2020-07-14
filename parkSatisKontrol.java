package ikas.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;



public class parkSatisKontrol {

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

    @Test (priority=12)
    public void parkKontrol() {

        try {
            driver.get(loginUrl);
            driver.findElement(name("email")).sendKeys("nesli.necipoglu+1@ikas.com");
            Thread.sleep(1000);
            driver.findElement(name("password")).sendKeys("123=ilsen");
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/form/div[3]/button")).click();
            Thread.sleep(5000);
            driver.findElement(xpath("//button[@class='toggle']")).click(); // Yönetici
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[1]/div/div[2]/div/ul/li[2]/a")).click(); // Ayarlar
            Thread.sleep(1000);
            driver.findElement(xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[2]/div[2]/label[5]/span[1]")).click(); // Park Buton Göster
            Thread.sleep(1000);
            driver.findElement(xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]")).click(); // Değişiklikleri Kaydet
            Thread.sleep(1000);
            driver.findElement(xpath("//a[@class='web btn btn-primary']")).click(); // Pos Ekranına Git
            Thread.sleep(3000);

            driver.findElement(xpath("/html/body/div[2]/div/div/div[3]/div/button[2]")).click(); // çayyolu
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div[3]/div/button[1]")).click(); //yeni kasa
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div[4]/div/div[3]/button[2]")).click(); // evet
            Thread.sleep(1000);

            driver.findElement(xpath("/html/body/div[2]/div[2]/div/div[3]/div/div[1]/div")).click();
            // pin gir
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div[2]/div/div[5]/div[1]")).click();
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div[2]/div/div[5]/div[2]")).click();
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div[2]/div/div[5]/div[3]")).click();
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div[2]/div/div[5]/div[4]")).click();
            Thread.sleep(1000);

            // 2. park

            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[1]/div[2]/div/div[3]")).click(); // Aydınlatma
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/button[2]")).click(); //ürün1
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div[1]/div/div[2]/div/button[2]")).click();  // ürün2
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div[1]/div/div[3]/div/button[2]")).click();  // ürün3
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div[1]/div/div[4]/div/button[2]")).click();  // ürün4
            Thread.sleep(2000);
            driver.findElement(xpath(" /html/body/div[2]/div/div/div/div[2]/div/div[1]/button")).click(); // müşteri ekle
            Thread.sleep(2000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[2]/div/div[1]/ul/li[4]")).click();  // müşteri adı
            Thread.sleep(2000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[2]/div/div[1]/div[2]")).click(); // üç nokta
            Thread.sleep(2000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[2]/div/div[1]/ul/li[1]")).click(); //satışı park et
            Thread.sleep(1000);
            driver.findElement(xpath("//*[@id=\"park_note\"]")).sendKeys("Park-1");
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[2]/div/div[1]/div[4]/div/div[3]/button[2]")).click(); //park et
            Thread.sleep(3000);

            //Kullanıcı Değiştir

            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/button")).click(); //üç nokta
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div[3]")).click(); // kilitle
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div[2]/div/div[4]/div[2]/div[1]/div")).click(); // yeni kullanıcı
            Thread.sleep(1000);
            // pin gir
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div[2]/div/div[5]/div[1]")).click();
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div[2]/div/div[5]/div[2]")).click();
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div[2]/div/div[5]/div[3]")).click();
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div[2]/div/div[5]/div[4]")).click();



            // Parka Git
            Thread.sleep(3000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[2]/div/div[1]/button[2]")).click(); // park
            Thread.sleep(2000);
            driver.findElement(xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]")).click(); // park-1 seçme
            Thread.sleep(1000);

            // park-1 ürün ekleme

            Thread.sleep(3000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[1]/div[2]/div/div[2]")).click(); // ev dekorasyon
            Thread.sleep(2000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/button[2]")).click(); // ürün 1
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[1]/div[2]/div/div[5]")).click(); // erkek
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div[1]/div/div/div/button[2]")).click(); // gözlük
            Thread.sleep(1000);

            //parkı öde
            Thread.sleep(1000);
            driver.findElement(xpath("//button[@class='paid btn btn-green']")).click(); // ödeme
            Thread.sleep(1000);
            driver.findElement(xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[3]/div[1]")).click(); // nakit


            Thread.sleep(3000);

            // satış geçmişi
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/button")).click(); // 3 nokta
            Thread.sleep(1000);
            WebElement satisPersonell= driver.findElement(xpath("/html/body/div[2]/div/div/div[4]/div/div[1]/div[1]"));
            String SistendekiSatisPersonelAd=  satisPersonell.getText();
            System.out.println(SistendekiSatisPersonelAd);
            Thread.sleep(1000);




            driver.findElement(xpath("/html/body/div[2]/div/div/div[1]/ul[1]/li[3]/a")).click(); // satış geçmişi
            Thread.sleep(2000);
            WebElement satisPersonel= driver.findElement(xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[7]"));
            String satisPersonelAd=  satisPersonel.getText();
            String satisPersonelAdString= satisPersonelAd.toUpperCase();
            System.out.println(satisPersonelAdString);



            //check result

            if(satisPersonelAdString.equals(SistendekiSatisPersonelAd))
            {
                System.out.println("Satışı yapan ile Sistemdeki Satış Görevlisi Aynı");

            }
            else
                System.out.println("Satışı yapan ile Sistemdeki Satış Görevlisi Aynı Değil");



        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AfterTest
    public void tearDown() throws Exception {

    }
}

