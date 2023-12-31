package StepDefinition;

import Pages.PayGradesPage;
import TestBase.TestBase;
import io.cucumber.java.en.*;

public class PayGrade extends TestBase {
	PayGradesPage payGradePg = new PayGradesPage();
	
	@And ("^Admin enters (.*)$")
	public void enterPayGradeName(String paygradename)
	{
		payGradePg.enterpayGradeName(paygradename);
	}
	

}
