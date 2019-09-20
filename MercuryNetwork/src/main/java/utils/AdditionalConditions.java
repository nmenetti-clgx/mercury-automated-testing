package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.Listeners;

import setup.TestSetup;

/**
 * <h1>Additional Conditions</h1>
 * 
 * <p>.
 *
 * @author  Dustin Norman
 * @since   09-20-2018
 */

@Listeners(utils.Listener.class)
public class AdditionalConditions extends TestSetup {
	
	/**
	 * <p>
	 * STEPS:
	 * <ul>
	 * 	<li>Wait for Angular pages to load</li>
	 * </ul>
	 * @return return true when the angular page has finished loading
	 *
	 */
	public static ExpectedCondition<Boolean> angularHasFinishedProcessing() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return (window.angular !== undefined) && (angular.element(document).injector() !== undefined) && (angular.element(document).injector().get('$http').pendingRequests.length === 0)").toString());
            } // end apply
        }; // end return ExpectedConditions
    } // end angularHasFinishedProcessing
	
} // end AdditionalConditions class
