package utils;

import java.util.List;

import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;

import setup.TestSetup;
 
/**
* <h1>Alter Group</h1>
* Updates the Include Group in the testng.xml to create a custom run
* <p>
* 
* @author  Dustin Norman
* @since   02-04-2019
*/

public class AlterGroup extends TestSetup implements IAlterSuiteListener {
	
	/**
	* 
	* <p>
	* STEPS:
	* <ul>
	* 	<li>Check to see if a param called area was passed in through Maven and set that as a String</li>
	*   <li>If there was a param called area passed in, add that as an Include Group tag to the testng.xml</li>
	* </ul>
	* @param suites Looks at the XML suite info for the test run
	*/
	@Override
	public void alter(List<XmlSuite> suites) {
		
		String group = System.getProperty("area", "");
		
		if (!group.equals("")) {
			for (XmlSuite suite : suites) {
				suite.addIncludedGroup(group);
			} // end for
		} // end if
		
    } // end alter method
	 
} // end class
