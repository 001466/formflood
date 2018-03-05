package com.ec.formflood.random.local;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.ec.common.util.StringUtil;
import com.ec.formflood.random.RName;
@Component("rNameLocalImpl")

public class RNameLocalImpl implements RName,InitializingBean{
	
	List<String> firstnamePools=null;
	List<String> lastnamePools=null;
	
	private static int firstNameIndex = 0;
	private static int middleNameIndex = 0;
	private static int lastNameIndex = 125;

	@Override
	public String random() {
		firstNameIndex 		= ++firstNameIndex 	% firstnamePools.size();
		middleNameIndex 	= ++middleNameIndex 	% lastnamePools.size();
		lastNameIndex 		= ++lastNameIndex 	% lastnamePools.size();
		
		return new StringBuilder(firstnamePools.get(firstNameIndex)).append(lastnamePools.get(middleNameIndex)).append(lastnamePools.get(lastNameIndex)).toString();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		firstnamePools=readWord("config/firstname.txt");
		lastnamePools=readWord("config/lastname.txt");
	}
	
	private List<String> readWord(String txt) throws IOException{
		List<String> list=new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(txt))));   
		char cbuf[]=new char[1]; 
		while(br.read(cbuf)>0){
			String str=new String(cbuf).trim();
			if(StringUtil.isEmpty(str)){
				continue;
			}
			list.add(str);
		}
        return list;
	}

}
