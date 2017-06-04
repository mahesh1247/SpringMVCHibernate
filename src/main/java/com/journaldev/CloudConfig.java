package com.journaldev;


import javax.sql.DataSource;

import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("cloud")
class CloudConfig{
	@Bean
	@Profile("cloud")
	public Cloud cloud() {
	  return new CloudFactory().getCloud();
	}
	
    @Bean
    @Profile("cloud")
        public DataSource inventoryDataSource() {
    		System.out.println("Application Instance INfs"+cloud().getApplicationInstanceInfo());
    		System.out.println("Cloud Properties"+cloud().getCloudProperties());
    		System.out.println("serviceinfos"+cloud().getServiceInfos());
    		System.out.println("Application Instance INfs"+cloud().toString());
            return cloud().getSingletonServiceConnector(DataSource.class, null);
        }

   
}
