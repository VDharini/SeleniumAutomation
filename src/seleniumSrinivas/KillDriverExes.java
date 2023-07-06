package seleniumSrinivas;

import java.io.IOException;

public class KillDriverExes {

	public static void main(String[] args) throws Exception {
		
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		//Runtime.getRuntime().exec("taskkill /F /IM backgroundTaskHost.exe");
		//Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
		//Runtime.getRuntime().exec("taskkill /F /IM msedge.exe");
		//Runtime.getRuntime().exec("taskkill /F /IM msedgewebview2.exe");
		//Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		//Runtime.getRuntime().exec("taskkill /F /IM soffice.exe");


	}

}
