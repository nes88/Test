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
        import org.openqa.selenium.interactions.Actions;
        import org.openqa.selenium.remote.DesiredCapabilities;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.mustache.Value;

import javax.management.ValueExp;
import java.io.Console;
import java.util.Date;
        import java.util.List;
        import java.util.Random;
        import java.util.concurrent.TimeUnit;

        import static org.openqa.selenium.By.name;
        import static org.openqa.selenium.By.xpath;


public class siparisEkle {

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

    @Test (priority=7)
    public void siparisOluştur() {

        try {
            driver.get(loginUrl);
            driver.findElement(name("email")).sendKeys("nesli.necipoglu+1@ikas.com");
            Thread.sleep(1000);
            driver.findElement(name("password")).sendKeys("123=ilsen");
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/form/div[3]/button")).click();
            Thread.sleep(5000);


            //Ürün


            driver.findElement(xpath("/html/body/div[1]/div[1]/nav/ul[1]/li[2]")).click(); //Ürün Label
            Thread.sleep(1000);
            driver.findElement(xpath("/html[1]/body[1]/div[1]/div[1]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]")).click(); //Ürün Listeleme
            Thread.sleep(1000);


            String searchProductNames[] = {"Masa Lambası", "Kürk"};

            Random rand = new Random();

            int n = rand.nextInt(searchProductNames.length);

            String productName = searchProductNames[n];

            System.out.println("Ürün adı=" + searchProductNames[n]);

            driver.findElement(xpath("/html/body/div[1]/main/div/div/div[1]/div[1]/div[1]/input")).sendKeys(productName);
            Thread.sleep(5000);
            driver.findElement(xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")).click();


            // ilk stok miktarı

            Thread.sleep(5000);
            WebElement firstStockQuantity = driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div[3]/div/div/div[2]/div[2]/div/div[2]/div[2]"));

            String firstStockQuantityAttribute = firstStockQuantity.getText();
            int firstStockQuantityAttributeInt =  Integer.parseInt(firstStockQuantityAttribute);
            System.out.println("ilk ürün Stok Miktarı =" + firstStockQuantityAttributeInt);

            // sol İçerik sekme

            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[1]/div/nav/ul[1]/li[2]/ul/li[3]/a")).click(); // İçerik Listeleme
            Thread.sleep(1000);


            String searchIngredientNames[] = {"Nane", "Süt", "Tarçın"};

            Random randomIngredient = new Random();

            int y = randomIngredient.nextInt(searchIngredientNames.length);

            String IngredientName = searchIngredientNames[y];

            System.out.println("İçerik Adı=" + searchIngredientNames[y]);
            Thread.sleep(3000);
            driver.findElement(xpath("/html/body/div[1]/main/div/div/div[1]/div[1]/div/input")).sendKeys(IngredientName);

            driver.findElement(xpath("/html/body/div[1]/main/div/div/div[2]/div[1]/div/div/div/div/div[1]/div[2]/div/div")).click();


            // ilk içerik miktarı******************************


             //1.yol
/*
            Thread.sleep(5000);
            WebElement firstIngredientQuantity = driver.findElement(xpath("/html/body/div[1]/main/div/div[1]/div/div[2]/div/div[5]/div/table/tbody/tr[2]/td[2]"));

            String firstStockIngredientQuantityAttribute = firstIngredientQuantity.getAttribute("value");

            System.out.println("İçerik Stok Sayısı =" + firstStockIngredientQuantityAttribute);

            Thread.sleep(1000);

*/
            Thread.sleep(8000);

            //kaydet
            driver.findElement(xpath("/html/body/div[1]/main/div/div[1]/div/div[3]/button[2]/span")).click();


            //2.yol ilk içerik miktarı
            Thread.sleep(3000);
            driver.findElement(xpath("//li[@class='NavigationLink report']//button[@class='toggle btn btn-small btn-icon']")).click();
            Thread.sleep(3000);
            driver.findElement(xpath("/html/body/div[1]/div/nav/ul[1]/li[6]/ul/li[6]/a")).click();


            WebElement firstIngredientQuantitySearch= driver.findElement(xpath("/html/body/div[1]/main/div/div[3]/div/div[1]/div[1]/div/input"));
            firstIngredientQuantitySearch.sendKeys(IngredientName);
            WebElement firstIngredientQuantitySearchClick= driver.findElement(xpath("/html/body/div[1]/main/div/div[3]/div/div[2]/div[1]/div/div/div/div/div[3]/div[2]/div/div"));
            String firstStockIngredientQuantityAttribute =  firstIngredientQuantitySearchClick.getText();

            System.out.println("İlk içerik Stok Miktarı =" + firstStockIngredientQuantityAttribute);


            //Envanter
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[1]/div/nav/ul[1]/li[5]/div/div")).click(); // Envanter
            Thread.sleep(3000);
            driver.findElement(xpath("/html/body/div[1]/div/nav/ul[1]/li[5]/ul/li[2]/a")).click(); // Siparişler
            Thread.sleep(3000);
            driver.findElement(xpath("//button[@class='btn btn-primary']")).click(); // Sipariş  Ekle
            Thread.sleep(3000);

            //irsaliye no

            // driver.findElement(xpath(" //*[@id=\"order_number\"] ")).sendKeys("0000");
            //  Thread.sleep(1000);


            Random ir = new Random();
            int irsaliye = ir.nextInt(100);
            String newirsaliye = Integer.toString(irsaliye);
            System.out.println("İrsaliye no=" + newirsaliye);
            driver.findElement(xpath("//*[@id=\"order_number\"]")).click();
            driver.findElement(xpath("//*[@id=\"order_number\"]")).sendKeys(newirsaliye);


            // Tedarikçi

            WebElement vendor = driver.findElement(xpath("/html/body/div[1]/main/div/div[2]/div/div[1]/div[2]/div[1]/div/div/div[1]/div[2]"));
            WebElement vendorinput = driver.findElement(xpath("//input[@id='vendor_id']"));
            vendor.click();
            Thread.sleep(1000);
            vendorinput.sendKeys("Pembe Giyim");
            Thread.sleep(1000);
            vendorinput.click();
            vendorinput.sendKeys(Keys.ENTER);
            Thread.sleep(1000);


            //sevk edilecek şube


            WebElement branch = driver.findElement(xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]"));
            WebElement branchinput = driver.findElement(xpath("//input[@id='branch_id']"));
            branch.click();
            Thread.sleep(1000);
            branchinput.sendKeys("Tunalı");
            Thread.sleep(1000);
            branchinput.click();
            branchinput.sendKeys(Keys.ENTER);
            Thread.sleep(1000);


            //Beklenen Sevk Tarihi

            WebElement arrival = driver.findElement(xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[2]"));
            arrival.click();
            Thread.sleep(1000);
            WebElement arrivaldate = driver.findElement(xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[31]"));
            arrivaldate.click();
            Thread.sleep(1000);

            //ürünler - alt sekme

            driver.findElement(xpath("/html/body/div[1]/main/div/div[2]/div/div[2]/div[2]")).click();

            //ürün search

            //  WebElement search=driver.findElement(xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
            // search.sendKeys("Kürk");
            //  driver.findElement(xpath("/html/body/div[1]/main/div/div[2]/div/div[3]/div[2]/div/div[1]/div[3]/div/div")).click();


            driver.findElement(xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys(productName);

            driver.findElement(xpath("/html/body/div[1]/main/div/div[2]/div/div[3]/div[2]/div/div[1]/div[3]/div/div")).click();

            //sipariş ürün miktar

            Random order = new Random();
            int orderQuantityAttribute = order.nextInt(10) + 1;

            String orderQuantity = Integer.toString(orderQuantityAttribute);
            System.out.println("Ürün Sipariş Miktarı=" + orderQuantity);

            driver.findElement(xpath("//input[@id='quantity']")).clear();
            driver.findElement(xpath("//input[@id='quantity']")).sendKeys(orderQuantity);


            Thread.sleep(3000);

            //ürün fiyat

            // driver.findElement(xpath("//input[@name='buy_price']")).click();
            // driver.findElement(xpath("//input[@name='buy_price']")).sendKeys("300");
            // Thread.sleep(1000);

            Random r = new Random();
            int number = r.nextInt(100) + 1;
            String newstr = Integer.toString(number);
            System.out.println("Ürün Fiyat=" + newstr);
            driver.findElement(xpath("//input[@name='buy_price']")).click();
            driver.findElement(xpath("//input[@name='buy_price']")).sendKeys(newstr);

            Thread.sleep(3000);


            //alt sekme içerik ekleme

            driver.findElement(xpath("/html/body/div[1]/main/div/div[2]/div/div[2]/div[3]")).click();


            //içerik search

            driver.findElement(xpath("//div[@class='IngredientOrders']//input[@id='order_number']")).sendKeys(IngredientName);
            Thread.sleep(3000);

            driver.findElement(xpath("/html/body/div[1]/main/div/div[2]/div/div[3]/div[3]/div/div[1]/div[2]/div/div")).click();

            Thread.sleep(3000);

            //sipariş içerik miktar

            Random ingredientRandom = new Random();
            int ingredientQuantity = ingredientRandom.nextInt(100) + 1;

            String ingredient = Integer.toString(ingredientQuantity);
            System.out.println("içerik Sipariş Miktarı =" + ingredient);


            WebElement element = driver.findElement(xpath("(/html/body/div[1]/main/div/div[2]/div/div[3]/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div)"));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).click().sendKeys(ingredient).build().perform();


            // içerik fiyat


            Random newrandom = new Random();
            int num = newrandom.nextInt(100) + 1;
            String newcost = Integer.toString(num);
            System.out.println("İçerik Fiyat=" + newcost);
            driver.findElement(xpath("//input[@id='buy_price']")).click();
            driver.findElement(xpath("//input[@id='buy_price']")).sendKeys(newcost);

            Thread.sleep(3000);


            //kaydet ve onayla

            driver.findElement(xpath("/html/body/div[1]/main/div/div[1]/div[2]/template/div/button[2]/span")).click();
            Thread.sleep(3000);

            // siparişe tıkla
            driver.findElement(xpath("/html/body/div[1]/main/div/div/div[2]/div[2]/div[1]/div/div/div/div[1]/div[2]/div/div/div")).click();
            Thread.sleep(3000);

            //ürünler

            driver.findElement(xpath("/html/body/div[1]/main/div/div[2]/div/div[2]/div[2]")).click(); //ürünler sekmesi
            Thread.sleep(1000);

            //alındı

            driver.findElement(xpath("/html/body/div[1]/main/div/div[2]/div/div[3]/div[2]/div/div/div[1]/div/div[7]")).click(); //üç nokta
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[1]/main/div/div[2]/div/div[3]/div[2]/div/div/div[1]/div/div[8]/button[1]")).click(); //alındı
            Thread.sleep(1000);

            //içerik sekmesi

            driver.findElement(xpath("/html/body/div[1]/main/div/div[2]/div/div[2]/div[3]")).click();
            Thread.sleep(3000);

            //alındı

            driver.findElement(xpath("/html/body/div[1]/main/div/div[2]/div/div[3]/div[3]/div/div/div[1]/div/div[6]")).click(); //üç nokta
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[1]/main/div/div[2]/div/div[3]/div[3]/div/div/div[1]/div/div[7]/button[1]")).click(); //alındı
            Thread.sleep(1000);


            //kaydet ve tamamla

            driver.findElement(xpath("/html/body/div[1]/main/div/div[1]/div[2]/template/div/button[3]/span")).click();
            Thread.sleep(4000);


            //ürünler

            //  driver.findElement(xpath("/html/body/div[1]/div[1]/nav/ul[1]/li[2]")).click(); //Ürün Label
            Thread.sleep(1000);
            driver.findElement(xpath("/html[1]/body[1]/div[1]/div[1]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]")).click(); //Ürün Listeleme
            Thread.sleep(1000);

            //ürün search
            driver.findElement(xpath("/html/body/div[1]/main/div/div/div[1]/div[1]/div[1]/input")).clear();
            driver.findElement(xpath("/html/body/div[1]/main/div/div/div[1]/div[1]/div[1]/input")).sendKeys(productName);
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[1]/main/div/div/div[2]/div[2]/div[1]/div/div/div/div[1]/div[2]/div/div/div")).click();
            Thread.sleep(1000);
            driver.findElement(xpath("/html/body/div[1]/main/div/div[2]/div[2]/div/div/div[1]/div/div[2]")).click();

            driver.findElement(xpath("/html/body/div[1]/main/div/div[1]/div[2]/template/div[1]")).click(); //üç nokta
            Thread.sleep(3000);

            driver.findElement(xpath("/html/body/div[1]/main/div/div[1]/div[2]/template/div[1]/div/div[3]/div[2]")).click(); //stok görüntüleme



            WebElement laststock = driver.findElement(xpath("/html/body/div[1]/main/div/div[1]/div/div[2]/div[2]/table/tbody/tr[1]/td[3]/span[3]"));  //GÖRMÜYOR XPATH


            String lastStockCountString = laststock.getText();

            System.out.println("Son Ürün Stok Miktarı =" + lastStockCountString);
            Thread.sleep(7000);

            driver.findElement(xpath("/html/body/div[1]/main/div/div[2]/div[1]/button")).click(); //çıkış



            //sol  içerik sekmesi


            //  driver.findElement(xpath("/html/body/div[1]/div[1]/nav/ul[1]/li[2]")).click(); //Ürün Label
         //     Thread.sleep(3000);




            // son içerik miktarı görüntüleme


           // 1.yol

            /*
            driver.findElement(xpath("/html/body/div[1]/div/nav/ul[1]/li[2]/ul/li[3]/a")).click(); // İçerik
            Thread.sleep(3000);

            driver.findElement(xpath("/html/body/div[1]/main/div/div/div[1]/div[1]/div/input")).sendKeys(IngredientName); //içerik search
            Thread.sleep(3000);
            driver.findElement(xpath("/html/body/div[1]/main/div/div/div[2]/div[1]/div/div/div/div/div[1]/div[2]/div/div")).click();
            driver.findElement(xpath("/html/body/div[1]/main/div/div/div[1]/div[2]/div")).click();
            driver.findElement(xpath("/html/body/div[1]/main/div/div/div[1]/div[2]/div/div/div[2]")).click();
            //  driver.findElement(xpath("/html/body/div[1]/main/div/div/div[2]/div[1]/div/div/div/div/div[1]/div[2]/div/div")).click(); //içerik stok detay görüntüleme

*/

            //2.yol


          //  Thread.sleep(3000);
          //  driver.findElement(xpath("/html/body/div[1]/div/nav/ul[1]/li[6]/div/button")).click();
            Thread.sleep(3000);
            driver.findElement(xpath("/html/body/div[1]/div/nav/ul[1]/li[6]/ul/li[6]/a")).click();



            WebElement firstIngredientQuantitySearchLast= driver.findElement(xpath("/html/body/div[1]/main/div/div[3]/div/div[1]/div[1]/div/input"));

            firstIngredientQuantitySearchLast.sendKeys(IngredientName);
            WebElement firstIngredientQuantitySearchClickLast= driver.findElement(xpath("/html/body/div[1]/main/div/div[3]/div/div[2]/div[1]/div/div/div/div/div[3]/div[2]/div/div"));
            String firstStockIngredientQuantityAttributeLast =  firstIngredientQuantitySearchClickLast.getText();

            System.out.println("Son İçerik Stok Miktarı =" + firstStockIngredientQuantityAttributeLast);



            //son stok ürün miktarı

            Thread.sleep(5000);

            //   WebDriverWait some_element = new WebDriverWait(driver,100);
            //  some_element.until(ExpectedConditions.visibilityOfElementLocated(xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[3]/span[3]")));



            //check result

            int finalValue;
            int orderQuantityInteger = Integer.parseInt(orderQuantity);
            int lastStockCountInt = Integer.parseInt(lastStockCountString);



            Thread.sleep(1000);

            finalValue = firstStockQuantityAttributeInt + orderQuantityInteger;
            System.out.println("Olması gereken Stok Son =" + finalValue);

            if (finalValue == lastStockCountInt) {

                System.out.println("Stok Miktarı Doğru");
            } else {
                System.out.println("Stok Miktarı Yanlış");
            }



            String firstStockIngredientQuantityAttributeReplace = firstStockIngredientQuantityAttribute.replaceAll("[^\\d.]", "");


            String firstStockIngredientQuantityAttributeLastReplace= firstStockIngredientQuantityAttributeLast.replaceAll("[^0-9.]", "");


            //check result içerik

            int finalIngvalue;
            int IngredientQuantityInteger = Integer.parseInt(ingredient);
            int firstStockIngredientQuantityAttributeInt = Integer.parseInt(firstStockIngredientQuantityAttributeReplace);
            int firstStockIngredientQuantityAttributeLastInt =Integer.parseInt(firstStockIngredientQuantityAttributeLastReplace);

            Thread.sleep(1000);

            finalIngvalue = firstStockIngredientQuantityAttributeInt + IngredientQuantityInteger;
            System.out.println("Olması gereken İçerik Son =" + finalIngvalue);

            if (finalIngvalue == firstStockIngredientQuantityAttributeLastInt) {

                System.out.println("İçerik Miktarı Doğru");
            } else {
                System.out.println("İçerik Miktarı Yanlış");
            }


        }


        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AfterTest
    public void tearDown() throws Exception {

    }
}
