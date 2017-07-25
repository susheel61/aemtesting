package com.aemtesting.pageobjects.example;

import com.aemtesting.custom.BaseComponent;
import com.cognifide.qa.bb.aem.dialog.classic.field.AemTextField;
import com.cognifide.qa.bb.aem.qualifier.DialogField;
import com.cognifide.qa.bb.aem.ui.AemDialog;
import com.cognifide.qa.bb.aem.ui.component.AemComponent;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;

/**
 * Represents a single Popular Articles component in the Gometrixx page.
 */
@PageObject
@AemComponent(cssClassName = "popular-articles", group = "Geometrixx Media", name = "Popular Articles")
public class PopularArticles extends BaseComponent {
	/**
	 * Image component has a dialog.
	 */
	@Inject
	private AemDialog dialog;

	/**
	 * Dialog contains an title field.
	 */
	@DialogField(label = "Top level page")
	private AemTextField topLevelPage;

	public AemTextField getTopLevelPage() {
		return topLevelPage;
	}

	/**
	 * @return Dialog instance.
	 */
	public AemDialog getDialog() {
		return dialog;
	}

}
