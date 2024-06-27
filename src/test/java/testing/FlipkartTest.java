package testing;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import java.util.ArrayList;
import java.util.List;

import base.BasePage;
import Pages.HomePage;
import Pages.ProductListPage;
import Pages.SingleProductPage;

public class FlipkartTest extends BasePage {
	
	HomePage homepage=new HomePage();
	ProductListPage productspage=new ProductListPage();
	SingleProductPage singleproduct=new SingleProductPage();
	
	String prodname="mobiles";
	@Test
	public void verifyTitleandHeading()
	{
		homepage.openUrl();
		homepage.search(prodname);
		String title=productspage.readTitle();
		String heading=productspage.readHeading();
		test=report.createTest("Validate Title and Heading");
		if(title.contains(prodname) && heading.contains(prodname))
		{
			test.log(Status.PASS, "Title and Heading matches the productname.");
		}
		else
		{
			test.log(Status.FAIL, "Title and Heading NOT matches the productname.");
		}
	}
	@Test
	public void verifyPricesSortingOrder()
	{
		homepage.openUrl();
		homepage.search(prodname);
		productspage.clickPriceLowToHigh();
		List<Integer> act=productspage.readAllPrices();
		List<Integer> exp=new ArrayList<Integer>(act);
		exp.stream().sorted();
		test=report.createTest("Validate prices are in sorting order");
		if(act.equals(exp))
		{
			test.log(Status.PASS, "Prices are in sorting order");
			
		}
		else
		{
			test.log(Status.FAIL, "Prices are NOT  in sorting order");
		}
		test.log(Status.INFO,exp.toString());
		test.log(Status.INFO,act.toString());
	}
	
	@Test
	
	public void verifyProductNameandPriceinCart()
	{
		homepage.openUrl();
		homepage.search(prodname);
		String first[]= productspage.clickOneProduct();
		singleproduct.clickAddToCart();
		String second[]=singleproduct.readProductNameandPrice();
		
		test=report.createTest("Validate productName and Prices in the cart");
		if(first[0].matches(second[0]) && first[1].matches(second[1]))
		{
			test.log(Status.PASS,"Product Name && Price in cart are same");
		}
		else
		{
			test.log(Status.FAIL,"Product Name && Price in Cart are not same");
		}
	}

}
