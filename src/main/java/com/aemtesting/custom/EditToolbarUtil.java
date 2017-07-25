package com.aemtesting.custom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cognifide.qa.bb.aem.ui.menu.MenuOption;

/**
 * A Utility class which has requires component object, webdriver and toolbar
 * option to click. This takes care switching into the iframe, then clicking the
 * required toolbar option and coming out the frame. Now another component can
 * follow the same if its in same test case.
 * 
 * @author susheels
 */
public class EditToolbarUtil {

	/**
	 * This method helps in clicking the toolbar in aem.
	 * 
	 * @param component
	 *            We need to pass component object.
	 * @param webdriver
	 *            We need to pass webdriver.
	 * @param option
	 *            This is an Enum class with all options required for toolbar.
	 */
	public static void click(BaseComponent component, WebDriver webdriver, MenuOption option) {
		String xpath = "//*[contains(@class,'" + component.getSiblingClass() + "')]";
		WebElement toolbarElem = webdriver.switchTo().frame("cq-cf-frame").findElement(By.xpath(xpath));
		toolbarElem.findElement(By.xpath(".//button[text()='" + option.getLabel() + "']")).click();
		webdriver.switchTo().defaultContent();
	}
}
