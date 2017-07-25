package com.aemtesting.example;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aemtesting.GuiceModule;
import com.aemtesting.custom.EditToolbarUtil;
import com.aemtesting.pageobjects.example.ImageComponent;
import com.aemtesting.pageobjects.example.PopularArticles;
import com.aemtesting.pageobjects.example.WhatIsBobcatPage;
import com.cognifide.qa.bb.aem.AemLogin;
import com.cognifide.qa.bb.aem.ui.AemContentFinder;
import com.cognifide.qa.bb.aem.ui.menu.MenuOption;
import com.cognifide.qa.bb.aem.ui.parsys.AemParsys;
import com.cognifide.qa.bb.constants.Timeouts;
import com.cognifide.qa.bb.junit.Modules;
import com.cognifide.qa.bb.junit.TestRunner;
import com.cognifide.qa.bb.provider.selenium.BobcatWait;
import com.google.inject.Inject;

@RunWith(TestRunner.class)
@Modules(GuiceModule.class)
public class AddComponentTest {

	@Inject
	private WhatIsBobcatPage whatIsBobcatPage;

	@Inject
	private AemLogin aemLogin;

	@Inject
	private AemContentFinder contentFinder;
	
	@Inject
	private BobcatWait bobcatWait;

	@Inject
	private WebDriver webdriver;

	private AemParsys parsys;

	@Before
	public void openBlockbusterHitsPage() {
		aemLogin.authorLogin();
		whatIsBobcatPage.open();
		assertTrue(whatIsBobcatPage.isDisplayed());
		parsys = whatIsBobcatPage.getTopParsys();
	}

	@Test
	public void testAddingAndEditingImageComponent() {
		 ImageComponent imageComponent = parsys.insertComponent(ImageComponent.class);
		 assertTrue(whatIsBobcatPage.isDisplayed());
		 EditToolbarUtil.click(imageComponent, webdriver,MenuOption.EDIT);
		 contentFinder.clickTab("Images");
		 contentFinder.search("icon-FrontEnd-shield");
		 List<String> results = contentFinder.getResults();
		 if (results.size() > 0) {
		 imageComponent.insert(contentFinder.getElementByIndex(0));
		 assertTrue("Image not found",
		 results.get(0).contains(imageComponent.getImgAttribute("title")));
		 imageComponent.getDialog().clickTab("Advanced");
		 imageComponent.getTitle().setValue("This is a heading for image component");
		 imageComponent.getAltText().setValue("This is an alt text");
		 imageComponent.getLinkTo().setValue("/content/geometrixx-media/en");
		 imageComponent.getDescription().setValue("Sed hendrerit condimentum erat, non venenatis leo pulvinar ac.");
		 imageComponent.getDialog().ok();
		 }
		assertThat(imageComponent, CoreMatchers.notNullValue());

		PopularArticles popularArticles = parsys.insertComponent(PopularArticles.class);
		assertTrue(whatIsBobcatPage.isDisplayed());
		System.out.println("Page Reloaded");	
		EditToolbarUtil.click(popularArticles, webdriver, MenuOption.EDIT);
		popularArticles.getTopLevelPage().setValue("/content/geometrixx-media/en");
		popularArticles.getDialog().clickTab("Defaults");
		assertThat(popularArticles, CoreMatchers.notNullValue());

	}
}