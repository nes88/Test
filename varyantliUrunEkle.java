package ikas.TestNG;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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



public class varyantliUrunEkle {

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

    @Test (priority =11 )
    public void VaryantlıUrunEkle() {

        try {

            driver.get(loginUrl);driver.findElement(name("email")).sendKeys("nesli.necipoglu+1@ikas.com");
           Thread.sleep(1000);
            driver.findElement(name("password")).sendKeys("123=ilsen");
            Thread.sleep(1000);
           driver.findElement(xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/form/div[3]/button")).click();
            Thread.sleep(10000);


            driver.findElement(xpath("/html/body/div[1]/div[1]/nav/ul[1]/li[2]")).click(); //Ürün Label
            Thread.sleep(3000);
            driver.findElement(xpath("/html[1]/body[1]/div[1]/div[1]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]")).click(); //Ürün Listeleme
            Thread.sleep(3000);
            driver.findElement(xpath("//button[@class='u-margin-left-10 btn btn-primary']")).click(); // Ürün Ekle
            Thread.sleep(3000);
            driver.findElement(xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[2]")).click(); // Varyantlı Ürün Ekle
            Thread.sleep(3000);
            driver.findElement(xpath("//input[@id='name']")).sendKeys("Prada 123"); // Basit Ürün isim
            Thread.sleep(3000);


            //ETİKET OLUŞTURMA

            WebElement Etiket =driver.findElement(xpath("//div[@class='tag']//div[@class='multiselect__tags']"));
            WebElement etiketInput = driver.findElement(xpath("//input[@id='tag_ids']"));
            Etiket.click();
            Thread.sleep(3000);
            etiketInput.sendKeys("Trend Gözlükler");
            etiketInput.sendKeys(Keys.ENTER);


            WebElement x= driver.findElement(xpath("//div[@class='tag']//div[@class='multiselect__tags']"));
            String TagInnerText = x.getText();
            System.out.println("Etiket Adı :"+TagInnerText);



            //TAX OLUŞTURMA
            WebElement tax= driver.findElement(xpath("//div[@class='Form-item required']//div[@class='multiselect__tags']"));
            WebElement taxinput= driver.findElement(xpath("//input[@id='tax_id']"));
            tax.click();
            Thread.sleep(1000);
            taxinput.sendKeys("%18");
            Thread.sleep(1000);
            taxinput.click();
            taxinput.sendKeys(Keys.ENTER);
            Thread.sleep(1000);


            // Varyant Ekleme

            driver.findElement(xpath("/html/body/div[1]/main/div/div[2]/div/div[2]/div/div[3]")).click();

            WebElement varyant= driver.findElement(xpath("//div[@class='variation']//div[@class='multiselect__tags']"));
            WebElement varyantinput= driver.findElement(xpath("//input[@id='variation_type']"));
            varyant.click();
            Thread.sleep(1000);
            varyantinput.sendKeys("Cam Rengi");
            Thread.sleep(1000);
            varyantinput.click();
            varyantinput.sendKeys(Keys.ENTER);
            Thread.sleep(1000);

            // Varyasyon Değeri Ekleme

            WebElement varyantdegeri= driver.findElement(xpath("//div[@class='multiselect tag is-danger']//div[@class='multiselect__tags']"));
            WebElement varyantdegeriinput= driver.findElement(xpath("//input[@id='variation_values']"));
            varyantdegeri.click();
            Thread.sleep(1000);
            varyantdegeriinput.sendKeys("FÜME");
            varyantdegeriinput.sendKeys(Keys.ENTER);


            varyantdegeriinput.sendKeys("GRİ");
            varyantdegeriinput.sendKeys(Keys.ENTER);

            varyantdegeriinput.sendKeys("COPPER FLASH");
            varyantdegeriinput.sendKeys(Keys.ENTER);

            Thread.sleep(1000);

            // SATIŞ FİYATI


            driver.findElement(xpath("/html/body/div[1]/main/div/div[2]/div/div[2]/div/div[5]")).click();


            driver.findElement(xpath("//div[@class='Price tab']//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//input[1]")).sendKeys("1200");
            Thread.sleep(1000);
            driver.findElement(xpath("//div[@class='Price tab']//div[@class='drag-container']//div[2]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//input[1]")).sendKeys("1200");
            Thread.sleep(1000);
            driver.findElement(xpath("//div[@class='Price tab']//div[@class='AccordionTable']//div[3]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//input[1]")).sendKeys("1200");


            Thread.sleep(1000);

            //varyantlı ÜRÜN KAYDET

            driver.findElement(xpath("/html/body/div[1]/main/div/div[1]/div[2]/template/div/div")).click();

            Thread.sleep(5000);




            // POS EKRANINA GİT

            driver.findElement(xpath("//a[@class='web btn btn-primary']")).click(); // pos ekranına gider
            Thread.sleep(10000);



            //RANDOM ŞUBE SEÇİMİ

            WebElement BranchesTypesContainer = driver.findElement(xpath("/html/body/div[2]/div/div/div[3]/div"));
            Thread.sleep(1000);
            List<WebElement> BranchesTypes = BranchesTypesContainer.findElements(By.xpath("./*"));
            Thread.sleep(1000);
            Random BranchesTypeRandom = new Random();
            int BrunchesTypeCount = BranchesTypes.size();
            int BrunchesTypeIndex = BranchesTypeRandom.nextInt(BrunchesTypeCount);
            WebElement aa= BranchesTypes.get(BrunchesTypeIndex);
            aa.click();
            Thread.sleep(5000);




            //RANDOM KASA SEÇİMİ

            WebElement TerminalTypesContainer = driver.findElement(xpath("/html/body/div[2]/div/div/div[3]/div"));
            List<WebElement> TerminalTypes = TerminalTypesContainer.findElements(By.xpath("./*"));
            Random TerminalTypeRandom = new Random();
            int TerminalTypesTypeCount = TerminalTypes.size();
            int TerminalTypesIndex = TerminalTypeRandom.nextInt(TerminalTypesTypeCount);
            TerminalTypes.get(TerminalTypesIndex).click();
            Thread.sleep(3000);


            //kasa aç



      //      driver.findElement(xpath("//*[@id=\"open_balance\"]")).sendKeys("100");

       //     Thread.sleep(2000);

       //     driver.findElement(xpath("//button[@class='btn btn-blue btn-wide']")).click(); // kasayı aç



           driver.findElement(xpath("/html/body/div[2]/div/div/div[4]/div/div[3]/button[2]")).click(); // evet


            //ÜRÜN SEÇİMİ

            WebElement TagTypesAll = driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[1]/div[2]/div"));
            List<WebElement> TagTypes = TagTypesAll.findElements(By.xpath("./*"));

            for(WebElement tagElement : TagTypes) {
                String tagText = tagElement.getText();
                if (tagText.equals(TagInnerText)) {
                    tagElement.click();
                    break;
                }
            }


            Thread.sleep(3000);


            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/button[2]")).click();  // ürünü sepete at
            Thread.sleep(3000);





            //ÜRÜN varyant değeri seç


            WebElement variantTypesContainer = driver.findElement(xpath("//div[@class='variations']"));
            List<WebElement> variantTypes = variantTypesContainer.findElements(By.xpath("./*"));

            Random variantTypeRandom = new Random();
            int variantTypeCount = variantTypes.size();
            int variantTypeIndex = variantTypeRandom.nextInt(variantTypeCount);

            WebElement variantTypeElement = variantTypes.get(variantTypeIndex);
            variantTypeElement.click();
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div[4]/button")).click();
            Thread.sleep(5000);
            //ödeme

            driver.findElement(xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/div[2]/div[2]/button[3]")).click();  //pay
            Thread.sleep(5000);

            //RANDOM ÖDEME SEÇİMİ

            WebElement paymentTypesContainer = driver.findElement(xpath("/html/body/div[2]/div/div/div/div[2]/div/div[3]/div/div[2]"));
            List<WebElement> paymentTypes = paymentTypesContainer.findElements(By.xpath("./*"));
            Random paymentTypeRandom = new Random();
            int paymentTypeCount = paymentTypes.size();
            int paymentTypeIndex = paymentTypeRandom.nextInt(paymentTypeCount);
            WebElement paymentTypeElement = paymentTypes.get(paymentTypeIndex);
            String paymentTypeName = paymentTypeElement.getText();
            paymentTypeElement.click();
            Thread.sleep(3000);


            // Satış Geçmişi


            driver.findElement(xpath("//button[@class='btn menu']")).click(); // 3 nokta
            Thread.sleep(3000);
            driver.findElement(xpath("/html/body/div[2]/div/div/div[1]/ul[1]/li[3]/a")).click(); // satış geçmişi
            Thread.sleep(5000);

            //CHECK RESULT

            List<WebElement> paymentTyperowsize = driver.findElements(xpath("//tr[*]//td[4]"));
            System.out.println("İşlem sayısı : " + paymentTyperowsize.size());
            String foundPaymentType = driver.findElement(xpath("//tr[1]//td[4]")).getText();
            if (foundPaymentType.equals(paymentTypeName)) {
                System.out.println("Ödeme Tipi Eşit");
            }
            else {
                System.out.println("Ödeme Tipi Eşit Değil");
            }




        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AfterTest
    public void tearDown() throws Exception {

    }
}

