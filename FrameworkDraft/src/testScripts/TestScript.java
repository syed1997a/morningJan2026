package testScripts;

import methods.AppDependentMethods;
import methods.AppIndependentMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class TestScript {
    @Test
    public static void TS_LoginAndLogout(){
        WebDriver oBrowser = null;
        Map<String, String> objData = null;
        try{
            objData = AppIndependentMethods.getExcelData("testData.xlsx", "testData", "TestId01");
            oBrowser = AppIndependentMethods.launchBrowser(objData.get("browserName") );
            Assert.assertTrue(AppDependentMethods.navigateURL(oBrowser, objData.get("URL")), "Failed to load URL" );
            Assert.assertTrue(AppDependentMethods.loginToApplication(oBrowser, objData.get("userName"), objData.get("password")), "Invaild User Name");
            Assert.assertTrue(AppDependentMethods.logoutFromApplication(oBrowser),"Logout Failed");
        }catch(Exception e){
            System.out.println("Exception in 'TS_LoginAndLogout()' test script. "+e);
        }finally{
            oBrowser.close();
            oBrowser = null;
        }
    }

    @Test
    public static void TS_LoginCreateAndDeleteUserAndLogout() {
        WebDriver oBrowser = null;
        Map<String, String> objData = null;
        try {
            objData = AppIndependentMethods.getExcelData("testData.xlsx", "testData", "TestId02");
            oBrowser = AppIndependentMethods.launchBrowser(objData.get("browserName"));
            Assert.assertTrue(AppDependentMethods.navigateURL(oBrowser, objData.get("URL")),"Invaild URL");
            Assert.assertTrue(AppDependentMethods.loginToApplication(oBrowser, objData.get("userName"), objData.get("password")),"InvaildUN and PWD");
            String userName = AppDependentMethods.createUser(oBrowser, objData);
            AppDependentMethods.deleteUser(oBrowser, userName);
            Assert.assertTrue(AppDependentMethods.logoutFromApplication(oBrowser), "LogoutFailed");
        } catch (Exception e) {
            System.out.println("Exception in 'TS_LoginAndLogout()' test script. " + e);
        } finally {
            oBrowser.close();
            oBrowser = null;
        }

    }
}
