package com.aemtesting.pageobjects.example;

import org.openqa.selenium.support.FindBy;

import com.cognifide.qa.bb.aem.page.AuthorPage;
import com.cognifide.qa.bb.aem.ui.parsys.AemParsys;
import com.cognifide.qa.bb.qualifier.Frame;
import com.cognifide.qa.bb.qualifier.PageObject;

/**
 * This class represents a page from Geometrixx project.
 * <p/>
 * Frame annotation determines default frame for all methods in this class.
 */
@PageObject
@Frame("$cq")
public class WhatIsBobcatPage extends AuthorPage {

	private String title = "What is bobcat";

	private String url = "/cf#/content/geometrixx-media/en/entertainment/what-is-bobcat.html";
	
	@FindBy(xpath = "//div[contains(@class, 'cq-placeholder-article-content-par_47_42')]/..")
	private AemParsys topParsys;
	
	public AemParsys getTopParsys() {
		return topParsys;
	}

	@Override
	public String getContentPath() {
		return url;
	}

	@Override
	public String getPageTitle() {
		return title;
	}
}
