package com.ec.formflood.random.local;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.ec.formflood.flood.Baidu.BaiduFlood;
import com.ec.formflood.random.RAdderss;
@Component("rAdderssLocalImpl")
public class RAdderssLocalImpl implements RAdderss,InitializingBean{
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(BaiduFlood.class);

	
	
	private static int strategyIndex = 0;
	
	private List<AdderssEntity> adderssPools=new ArrayList<>();
	
	
	@Override
	public AdderssEntity random() {

		strategyIndex = ++strategyIndex % adderssPools.size();
		return adderssPools.get(strategyIndex);
	
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
		List<String> areaList=readLine("config/area.txt");
		List<String> addrList=readLine("config/addr.txt");
		
			 
			for(int i=0;i<areaList.size()-1;i++){
				
				try{
					String addr=addrList.get(i);
					if(addr.indexOf("省")>-1 ||addr.indexOf("市")>-1 ||addr.indexOf("区")>-1 ||addr.indexOf("县")>-1 ){
						continue;
					}
					String areaStr=areaList.get(i);
					String areaArr[]=areaStr.split(" ");
					String province=areaArr[0];
					String city=areaArr[1];
					String county=areaArr[2];
					
					adderssPools.add(new AdderssEntity(province,city,county,addr));
				}catch(Exception e){
					LOGGER.error(e.getMessage(),e);
				}
				
			}
			
			for(AdderssEntity ad: adderssPools){
				System.err.println(ad);
			}
		
		
		
	}
	
	private List<String> readLine(String txt) throws IOException{
		List<String> set=new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(txt))));   
        String line = br.readLine();  
        while (line != null ) {
       	 set.add(line);
       	 line = br.readLine();   
        }  
        return set;
	}

}
