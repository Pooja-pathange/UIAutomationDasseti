package com.diligend.utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;


@Sources({
		/*
		 * "system:properties", "system:env",
		 */
	
	 "classpath:${env}.properties"
	
/*
 * "file:${user.dir}/src/test/resources/demo.properties" ,
 * "file:${user.dir}/src/test/resources/stage.properties"
 */
})


public interface EnvironmentConfig extends Config {

	String Browser();
	
	//String environment();
	
	@DefaultValue("testing")
	
	@Key("url")
	String url();
	
	@Key("username")
	String username();
	
	
	@Key("password")
	String password();
	

	/*
	 * @Key("db.hostname") String getDBHostname();
	 * 
	 * @Key("db.port") int getDBPort();
	 */



}
