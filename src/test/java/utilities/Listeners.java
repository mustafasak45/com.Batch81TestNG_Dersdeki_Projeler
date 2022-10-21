package utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.ITestListener;
import java.io.IOException;

public class Listeners implements ITestListener { // ilk implements ITestListener yaptık

    @Override
    public void onStart(ITestContext arg){ //ister classta 1 test çalışsın ister class çalışsın çalışır
                                            //test pass,fail,ignore olsada çalışır
                                            //class çalıştırılırken ilk testin başında çalışır
        System.out.println("onStart - Tum testlerden Once 1 sefer cagirilir => "+arg.getName());
    }
    @Override
    public void onFinish(ITestContext arg){//ister classta 1 test çalışsın ister class çalışsın çalışır
                                            //test pass,fail,ignore olsada çalışır
                                            //class çalıştırılırken son testin sonunda çalışır
        System.out.println("onFinish - Tum testlerden Sonra 1 sefer cagirilir => "+arg.getName());
    }

    @Override
    public void onTestStart(ITestResult result){//her testin basinda calisir
                                                //test pass,ignore,fail olması farketmez
        System.out.println("onTestStart - Method sayisi kadar, Her bir @Test annotation dan once bir kez calisir "+result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result){//sadece pass olan testlerde çalışır
        System.out.println("onTestSuccess - PASS edilen Method sayisi kadar ve PASS edilen methodlardan SONRA bir kez calisir => "+result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result){//sadece ignore edilen testlerde çalışır
        System.out.println("onTestSkipped - Skipped edilen Method sayisi kadar ve skipped edilen methodlardan SONRA bir kez calisir => "+result.getName());

        try { //eger test ignore edilirse diye ekran görüntüsünü almak için burada method call yaptık
            ReusableMethods.getScreenshot(result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onTestFailure(ITestResult result){//sadece fail olan testlerde çalışır
        System.out.println("onTestFailure - Failed edilen Method sayisi kadar ve Failed edilen methodlardan SONRA bir kez calisir => "+result.getName());

        try { //eger test fail edilirse diye ekran görüntüsünü almak için burada method call yaptık
            ReusableMethods.getScreenshot(result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
