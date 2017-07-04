package pokeFetcher;
import org.json.*;
import java.util.ArrayList;

public class PokeFetcher {
	
	public static void main(String []args) {
      ArrayList<String> nameList = new ArrayList<String>();
      OrderListHandler orderHandler = new OrderListHandler();
      
      try{
	    int startId = Integer.parseInt(args[0]);
	    int endId = Integer.parseInt(args[1]);
	    if(startId>endId) {
	    		System.out.println("range of ID is wrong: given start ID is larger than the end ID");
	    }
	    
    	  	for(int i=startId;i<=endId;i++) {
        	  	String result = HTMLHandler.getHTML("http://pokeapi.co/api/v2/pokemon/"+i+"/");
      
        	  	//JSONParser parser= new JSONParser(result);
        	  	JSONObject obj = new JSONObject(result);

        	  	System.out.println("pokemon id:"+obj.getInt("id"));
        	  	
        	  	String name = obj.getString("name");
        	  	System.out.println("pokemon name:"+name);
        	  	
        	  	System.out.println("pokemon weight:"+obj.getInt("weight"));
        	  	
        	  	int height = obj.getInt("height");
        	  	System.out.println("pokemon height:"+height);
        	  	System.out.println("//////////////////////");
        	  	
        	  	int index = orderHandler.insertInOrder(height);
        	  	if(index>=0) {
            	  	nameList.add(index,name);
            	  	if(nameList.size()>10) {
            	  		nameList.remove(10);
            	  	}
        	  	}
        	 }
    	  	int length = nameList.size();
    	  	for(int i=0;i<length;i++) {
    	  		System.out.println("pokemon name "+nameList.get(i)+": height is in order "+i);
    	  	}
      }catch(NumberFormatException e) {
    	  	System.out.println("The type of input arguments are wrong. The arguments should be 2 numbers seperate with one space, e.g. 20 30");
    	  	return;
      }catch(Exception e) {
    	  	System.out.println("exception"+e);
    	  }
	}
	
}
