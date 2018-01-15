package com.charlie1.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.charlie1.funds.model.selectFundsByFund;

@Controller
public class HelloController {

	@RequestMapping(value = "/rest/hello", method = RequestMethod.GET)
	public String getData(ModelMap mode) throws JSONException {

		//ModelAndView model = new ModelAndView("hello");
		
		
		String fundtmp = "{'Fund': 'PGMIX'}";
        JSONObject jsonObj = new JSONObject(fundtmp);
        String sfund = jsonObj.getString("Fund");
        selectFundsByFund thefund = new selectFundsByFund(sfund);
        
        String strRisk = thefund.getjsonStr();
        String strHolding = thefund.getholdingsStr();
        String strCalPerf = thefund.getperfCalander();
        String strReturn =  thefund.getreturnsdataStr();
        
        String jsonHolding = "{\"Holdings\": [";	
        jsonHolding += strHolding + "]}";
        
        
        String jsonCalPerf = "{\"PerformanceCalander\": [";
        jsonCalPerf += strCalPerf + "]}";
        
        String jsonReturn = "{\"Returns\": [";
        jsonReturn += strReturn + "]}";
        
        
      
        
        
        
        
        
        mode.addAttribute("jsonHoldings",jsonHolding);
        mode.addAttribute("jsonCalPerf",jsonCalPerf);
        mode.addAttribute("jsonAnnualReturns",jsonReturn);
        
        
       
        
        
        
        
        
        mode.addAttribute("jsonCalPerf",strCalPerf);
        mode.addAttribute("jsonAnnualReturns",strReturn);
		mode.addAttribute("strJson", strRisk);
		
		
	
		return "hello";

	}

}

