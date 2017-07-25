package com.aemtesting.custom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class representing the base component. Every component which has edit toolbar
 * has to extend this base component. This is to generalize so that we can pass
 * all different types of component objects to one type, which is BaseComponent.
 * This also takes care of providing the exact toolbar class.
 * 
 * @author susheels
 */
public class BaseComponent {

	/**
	 * Trying to lookup the preceding sibling for the current component.
	 */
	@FindBy(xpath = ".//preceding-sibling::div[1]")
	private WebElement sibling;

	/**
	 * Return the css class value and replace the world placeholder to element.
	 * This gives us the actual class name of edit bar, which is unique for each
	 * component.
	 */
	public String getSiblingClass() {
		return sibling.getAttribute("class").split(" ")[0].replace("placeholder", "element");
	}

}
