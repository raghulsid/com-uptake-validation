package com.uptake.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author rmurug3
 *
 */
public class HomePage {

	@FindBy(xpath = "//span[text()='Products']")
	public WebElement products;

	@FindBy(xpath = "//span[text()='Industries']")
	public WebElement industries;

	@FindBy(xpath = "//a[text()='Aviation']")
	public WebElement aviation;
	
}
