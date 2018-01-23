//package com.charlie1.analytics;

/*
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class structure {
	
	
	public structure() {}
	
	
	
	public void Assignment1() {
		
		
		
		//list.forEach(item -> 
        //item.forEach((k, v) -> System.out.println(k + ": " + (String)v);        																	); 
		
		
        //list.forEach(item -> 
        //item.forEach((k, v) -> System.out.println(k + ": " + (String)v));
		
		
		
		
		 Map<String, String> map = new HashMap<>();
		    map.put("First", "1");
		    map.put("Second", "2");
		    map.put("third", "3");
		    map.put("four", "4");

		    // here is the logic 
		    for (Map.Entry<String, String> entry : map.entrySet()) {
		        System.out.println(entry.getKey() + " - " + entry.getValue());
		    }
		    
		    
			List<Map<String, Object>> LMResult;
			LMResult = map;// AtmInfoDAO.TestResultset();
		    String strAtmInfo = "";
		    
		    
		    strAtmInfo += "{";
	        
	           
	        for (Map<String, Object> map :  LMResult) {
	            for (Map.Entry<String, Object> entry : map.entrySet()) {
	         //       System.out.println(entry.getKey() + " -* " + entry.getValue());
	            	
	            	strAtmInfo += "\""  + entry.getKey() +"\":\""+ entry.getValue()+"\",";
	            	if(entry.getKey().equals("Rate")) { 
	            		
	            		StringBuilder sb = new StringBuilder(strAtmInfo);
	    	        	sb.deleteCharAt(strAtmInfo.length()-1);
	    	        	strAtmInfo = sb.toString();
	    	        	strAtmInfo += "},{"; 
	    	        //	strAtmInfo += "}";
	            		break;
	            	}
	            	
	            
	            //	bankingData = "{'CustId': '-','TerminalID' : '-','Model': '-','StoreID':'-'}";
	            	
	            	
	            	
	            }
	        	
	        } 
		    
		   
		/*
		 class Helper {
    public static <T> T[] toArray(List<T> list) {
        T[] array = (T[]) new Object[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}

public static void main(String[] args) {
    List<String> list = new ArrayList<String>();
    list.add("abc");
    String[] array = toArray(list);
    System.out.println(array);
}

list.toArray(T[] array)
		
		
		newEntries.toArray(new IClasspathEntry[0])
		toArray(newEntries)
		
	*/	
		
		
		
		
//	}
	
	
	
	
	

//}
