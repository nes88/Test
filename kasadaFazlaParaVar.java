package ikas.TestNG;


import org.openqa.selenium.Keys;
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


public class kasadaFazlaParaVar {



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

    @Test (priority=9)
    public void kasaFazlaPara() {

        try {

            //login
            driver.get(loginUrl);
            driver.findElement(name("email")).sendKeys("nesli.necipoglu+3@ikas.com");
            Thread.sleep(1000);
            driver.findElement(name("password")).sendKeys("1988Nes.");
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/form/div[3]/button")).click();
            Thread.sleep(5000);

            //POS


            driver.findElement(xpath("/html/body/div[2]/div/div/div[2]/div/button[2]")).click(); // çayyolu
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div[3]/div/button[1]")).click(); // kasa

            driver.findElement(xpath("/html/body/div[2]/div/div/div[4]/div/div[3]/button[2]")).click(); //evet
         //   Thread.sleep(1000);

            //kasa aç

        //    Thread.sleep(2000);

        //    driver.findElement(xpath("//*[@id=\"open_balance\"]")).sendKeys("100");

        //    Thread.sleep(1000);

        //   driver.findElement(xpath("//button[@class='btn btn-blue btn-wide']")).click(); // kasayı aç


            // 1.satış yap

            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[1]/div[2]/div/div[3]/div")).click(); //kadın
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div[1]/div/div[3]/div/button[2]")).click();
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[2]/div[2]/button[3]")).click();
            Thread.sleep(1000);

            //ÖDEME

            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[2]/div/div[3]/div/div[2]/div[3]/div")).click();


            // Satış Geçmişi
            Thread.sleep(3000);
            driver.findElement(xpath("//button[@class='btn menu']")).click(); //ÜÇ NOKTA
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div[1]/ul[1]/li[3]/a")).click(); // satış geçmişi
            Thread.sleep(4000);

            WebElement first = driver.findElement(xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[6]/span"));
            String firstSale = first.getText().substring(2);
            System.out.println("Birinci Satış Tutarı=   " + firstSale);
            Thread.sleep(1000);


            //satışa geri dön
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/button")).click(); //üç nokta
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div[1]/ul[1]/li[1]/a")).click(); // satış ekranına git

            // 2.satış yap


            Thread.sleep(5000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div[1]/div/div[2]/div/button[2]")).click();
            Thread.sleep(1000);


            //ÖDEME

            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[2]/div[2]/button[3]")).click();
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[2]/div/div[3]/div/div[2]/div[3]/div")).click();
            Thread.sleep(3000);

            // Satış Geçmişi


            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/button")).click(); // 3 nokta
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div[1]/ul[1]/li[3]/a")).click(); // satış geçmişi
            Thread.sleep(4000);

            WebElement second = driver.findElement(xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[6]/span"));
            String secondSale = second.getText().substring(2);
            System.out.println("İkinci Satış Tutarı=    " + secondSale);


            // kasadan para çıkar
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/button")).click(); //üç nokta
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div[1]/ul[2]/li[1]/a")).click(); // kasa işlemleri
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div[1]/ul/li[3]/a")).click(); // para çıkar
            Thread.sleep(3000);
            driver.findElement(xpath("//input[@id='close_balance']")).sendKeys("500");// tutar gir

            //   WebElement para = driver.findElement(xpath("//*[@id=\"close_balance\"]"));
            //   String cikanParaString = para.getText();
            //   System.out.println("Kasadan çıkarılan para=" + cikanParaString);

            driver.findElement(xpath("/html/body/div[2]/div/div/div[2]/div/div[2]/div/div[3]/button")).click(); // çıkar
            Thread.sleep(3000);

            //satışa geri dön

            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div[1]/ul[1]/li[1]/a")).click(); // satış ekranına git


            // 3.satış yap


            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[1]/div[2]/div/div[4]/div[1]")).click(); //erkek
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div[1]/div/div/div/button[2]")).click(); //ürün
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[2]/div[2]/button[3]")).click(); //ödeme
            Thread.sleep(1000);

            //ÖDEME

            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[2]/div/div[3]/div/div[2]/div[3]/div")).click();
            Thread.sleep(3000);


            // Satış Geçmişi


            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/button")).click(); // 3 nokta
            Thread.sleep(2000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div[1]/ul[1]/li[3]/a")).click(); // satış geçmişi
            Thread.sleep(4000);

            WebElement third = driver.findElement(xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[6]/span"));
            String thirdSale = third.getText().substring(2);
            System.out.println("Üçüncü Satış Tutarı=    " + thirdSale);

            //satışa geri dön
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/button")).click(); //üç nokta
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div[1]/ul[1]/li[1]/a")).click(); // satış ekranına git

            // 4.satış yap


            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[1]/div[2]/div/div[2]/div[1]")).click(); //Aydınlatma
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div[1]/div/div/div/button[2]")).click();
            Thread.sleep(1000);


            //ÖDEME

            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[2]/div[2]/button[3]")).click();
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[2]/div/div[3]/div/div[2]/div[3]/div")).click();
            Thread.sleep(3000);

            // Satış Geçmişi


            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/button")).click(); // 3 nokta
            Thread.sleep(2000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div[1]/ul[1]/li[3]/a")).click(); // satış geçmişi
            Thread.sleep(4000);

            WebElement fourth = driver.findElement(xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[6]/span"));
            String fourthSale = fourth.getText().substring(2);
            System.out.println("Dördüncü Satış Tutarı=    " + fourthSale);


            // kasaya para ekle
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/button")).click(); // 3 nokta
            Thread.sleep(2000);

            driver.findElement(xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/ul[2]/li[1]/a[1]")).click(); // kasa işlemleri
            Thread.sleep(1000);
            driver.findElement(xpath("//a[contains(text(),'Para Ekle')]")).click(); // para ekle
            Thread.sleep(1000);
            driver.findElement(xpath("//input[@id='close_balance']")).sendKeys("750");// tutar gir

            Thread.sleep(3000);

            driver.findElement(xpath("//button[@class='btn btn-blue btn-wide']")).click(); // ekle

            Thread.sleep(2000);

            //satışa geri dön

            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div[1]/ul[1]/li[1]/a")).click(); // satış ekranına git

            // 5.satış yap

            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[1]/div[2]/div/div[7]")).click(); // giyim
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div[1]/div/div/div/button[2]")).click(); //ürün
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[2]/div[2]/button[3]")).click();
            Thread.sleep(1000);

            //ÖDEME


            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[2]/div/div[3]/div/div[2]/div[3]/div")).click();
            Thread.sleep(3000);

            // Satış Geçmişi


            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/button")).click(); // 3 nokta
            Thread.sleep(2000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div[1]/ul[1]/li[3]/a")).click(); // satış geçmişi
            Thread.sleep(4000);

            WebElement fifth = driver.findElement(xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[6]/span"));
            String fifthSale = fifth.getText().substring(2);
            System.out.println("Beşinci Satış Tutarı=   " + fifthSale);


            //TOPLAM SATIŞ


            double toplam;
            double s1 = Double.parseDouble(firstSale);
            double s2 = Double.parseDouble(secondSale);
            double s3 = Double.parseDouble(thirdSale);
            double s4 = Double.parseDouble(fourthSale);
            double s5 = Double.parseDouble(fifthSale);


            toplam = s1 + s2 + s3 + s4 + s5;


            // Kasa kapat
            Thread.sleep(3000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/button")).click(); // 3 nokta
            Thread.sleep(2000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div[1]/ul[2]/li[1]/a")).click(); // kasa işlemleri
            Thread.sleep(2000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div[1]/ul/li[4]/a")).click(); // kasayı kapat

            //toplam tutarı gir


            double total = toplam + 100 - 500 + 750;


            String totalPrice = String.valueOf(total);

            totalPrice = totalPrice.replace(",", "");

            double toplam_int = Double.valueOf(totalPrice.substring(0, totalPrice.length() - 2));

            System.out.println("toplam=" + toplam_int);


            driver.findElement(xpath("//*[@id=\"close_balance\"]")).sendKeys("3500");
            Thread.sleep(8000);


            driver.findElement(xpath("/html/body/div[2]/div/div/div[2]/div/div[2]/div/div[4]/button")).click(); //kasayı kapat

            Thread.sleep(8000);

            driver.findElement(xpath("/html/body/div[2]/div/div/button")).click(); //üç nokta
            Thread.sleep(1000);



            driver.findElement(xpath("//div[@class='action']//*[@class='icon']")).click(); //hesaptan çıkış
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div[3]/div/div[3]/div/div[3]/button[2]")).click(); //eminim -çık


            //login
            driver.get(loginUrl);
            driver.findElement(name("email")).clear();
            driver.findElement(name("email")).sendKeys("nesli.necipoglu+1@ikas.com");
            Thread.sleep(1000);
            driver.findElement(name("password")).sendKeys("123=ilsen");
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/form/div[3]/button")).click();
            Thread.sleep(5000);


            //rapor

            driver.findElement(xpath("//li[@class='NavigationLink report']//div[@class='link parent']")).click();  //raporlar
            driver.findElement(xpath("//a[contains(text(),'Kasa Raporlar')]")).click(); //kasa raporları


            // Sistemde Görünen Kasa Durumu

            Thread.sleep(3000);



            driver.findElement(xpath("/html/body/div[1]/main/div/div/div[2]/div[2]/div[1]/div/div/div/div[1]/div[2]/div/div")).click();

            driver.findElement(xpath("/html/body/div[1]/main/div/div[1]/div/div[2]/div[2]/div[1]/div/button[2]")).click();



            WebElement x = driver.findElement(xpath("/html/body/div[1]/main/div/div[1]/div/div[2]/div[1]/div[3]/p/span/span"));
            String String1 = x.getText();
            System.out.println("Kasa Raporunda Görünen Kasa Durumu = " + String1);


            // Olması Gereken Kasa Durumu

            String String2 = "Kasa Fazla Verdi";

            if (toplam_int > 500) {
                System.out.println(String2);
            } else
                System.out.println("kasa tuttu ya da açık var");

            // Sistem doğru çalışıyor mu

            if(String1.equals(String2)) {
                System.out.println("Sistem Doğru");
            }
            else
                System.out.println("Sistem Yanlış");

        }


        catch(InterruptedException e){
            e.printStackTrace();
        }
    }



    @AfterTest
    public void tearDown() throws Exception {

    }
}
