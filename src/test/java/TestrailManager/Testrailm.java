package TestrailManager;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;

public class Testrailm {

	public static String Test_Run_ID="1";
	
	public static String Test_Rail_username="thirumalathiru3@gmail.com";
	public static String Testrail_pass="Thiru@113";
	
	public static String Testrail_Engine_URL="https://thiru10.testrail.io";
	
	public static int Test_Rail_Pass_status=1;
	
	public static int Tes_Rail_Fail_status=5;
	
	public static void addTestresultsforTC(String testcaseid, int status,String error) {
		String testrunid=Test_Run_ID; 
		APIClient client = new APIClient(Testrail_Engine_URL);
		client.setUser(Test_Rail_username);
		client.setPassword(Testrail_pass);
		
		
		
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("status_id", status);
		hm.put("comment","This case executed via opencart automation code"+error);
		
		
		try {
			client.sendPost("add_result_for_case/"+testrunid+"/"+testcaseid, hm);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (APIException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
