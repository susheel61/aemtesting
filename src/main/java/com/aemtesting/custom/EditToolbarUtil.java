package com.aemtesting.custom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditToolbarUtil {

	public static void clickEdit(BaseComponent component, WebDriver webdriver) {
		String xpath = "//*[contains(@class,'" + component.getSiblingClass() + "')]";
		WebElement toolbarElem = webdriver.switchTo().frame("cq-cf-frame").findElement(By.xpath(xpath));
		toolbarElem.findElement(By.xpath(".//button[text()='Edit']")).click();
	}
}
