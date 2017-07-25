package com.aemtesting.pageobjects.example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aemtesting.custom.BaseComponent;
import com.cognifide.qa.bb.aem.dialog.classic.field.AemTextArea;
import com.cognifide.qa.bb.aem.dialog.classic.field.AemTextField;
import com.cognifide.qa.bb.aem.dialog.classic.field.image.AemImage;
import com.cognifide.qa.bb.aem.qualifier.DialogField;
import com.cognifide.qa.bb.aem.ui.AemDialog;
import com.cognifide.qa.bb.aem.ui.component.AemComponent;
import com.cognifide.qa.bb.aem.ui.menu.AemToolbar;
import com.cognifide.qa.bb.dragdrop.Draggable;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;

/**
 * Represents a single image component in the Gometrixx page.
 * <p/>
 * You can easily reuse this class, perhaps with a small modification, to create
 * your own components.
 */
@PageObject
@AemComponent(cssClassName = "image", group = "Geometrixx Media", name = "Image")
public class ImageComponent extends BaseComponent{
	/**
	 * Image component has a dialog.
	 */
	@Inject
	private AemDialog dialog;

	@Inject
	private AemToolbar toolbar;

	/**
	 * Dialog contains an image field.
	 */
	@DialogField(css = ".cq-smartfile-_46_47file")
	private AemImage image;

	/**
	 * Dialog contains an title field.
	 */
	@DialogField(label = "Title")
	private AemTextField title;
	/**
	 * Dialog contains an title field.
	 */
	@DialogField(label = "Alt Text")
	private AemTextField altText;
	/**
	 * Dialog contains an title field.
	 */
	@DialogField(label = "Description")
	private AemTextArea description;

	@DialogField(label = "Link to")
	private AemTextField linkTo;

	/**
	 * It is possible to lookup the image that is associated with the image
	 * component.
	 */
	@FindBy(xpath = ".//img")
	private WebElement img;

	/**
	 * @return Dialog instance.
	 */
	public AemDialog getDialog() {
		return dialog;
	}

	/**
	 * @return Toolbar instance.
	 */
	public AemToolbar getToolbar() {
		return toolbar;
	}

	/**
	 * Clears the image in the dialog.
	 */
	public void clear() {
		image.clear();
	}

	/**
	 * Drags the image from content finder to the image field in the dialog.
	 */
	public void insert(Draggable elementByName) {
		image.insert(elementByName);
	}

	/**
	 * Return the path of the image from the IMG element on the page.
	 */
	public String getImgAttribute(String attributeName) {
		return img.getAttribute(attributeName);
	}

	public AemTextField getTitle() {
		return title;
	}

	public AemTextArea getDescription() {
		return description;
	}

	public AemTextField getLinkTo() {
		return linkTo;
	}

	public AemTextField getAltText() {
		return altText;
	}

}
