package com.ec.formflood.flood.LvtZoosnetNET;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.ec.common.utils.FileUtil;
import com.ec.formflood.flood.FloodAsyncRestTemplate;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.Tesseract1;
import net.sourceforge.tess4j.util.ImageHelper;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.ImageHelper;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

@Service("lvtZoosnetNET_ART")
public class LvtZoosnetNET_ART extends FloodAsyncRestTemplate implements InitializingBean{

	protected static final Logger LOGGER = LoggerFactory.getLogger(LvtZoosnetNET_ART.class);

	protected static final String url="https://lvt.zoosnet.net/LR/CheckCode3.aspx?id=40898426&sid=1516871876682878854514&d=1516873280728";

	
	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public void flooding() {
		
		try {
			String filename="download/LvtZoosnetNET/1.gif";
			File imageFile = new File(filename);
			
			HttpHeaders headers=genDownloadHeaders();
			ByteArrayInputStream is = new ByteArrayInputStream(download(getUrl(),headers));
			
			FileUtil.write(filename, is);
	 
			
	        ITesseract instance = new Tesseract();  // JNA Interface Mapping  
	        //ITesseract instance = new Tesseract1(); // JNA Direct Mapping  
	        instance.setOcrEngineMode(0); //这个应该就是默认值，可以不设置

	        System.err.println(filename);

	        //将验证码图片的内容识别为字符串 
	        String result = instance.doOCR(imageFile);
	        System.err.println("result1");
	        System.err.println(result);
	        
	        //二值化
	        
	        BufferedImage grayImage = ImageHelper.convertImageToBinary(ImageIO.read(imageFile));
	        ImageIO.write(grayImage, "gif", new File("download/LvtZoosnetNET/2/","1.gif"));
            
            File imageFile2 = new File("download/LvtZoosnetNET/2/1.gif");
            String result2 = instance.doOCR(imageFile2);
            System.out.println(result2);
            System.out.println("----------------------");
            //截取一小块
            Rectangle rectangle = new Rectangle(0, 0, 100, 20);
            String result3 = instance.doOCR(grayImage,rectangle)
                    .replace(" ",".").replace(",","");
            System.out.println(result3);
            
            
	        
		} catch (Exception e) {
			LOGGER.error(e.getMessage(),e);
		}  
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
		FileUtil.create("download/LvtZoosnetNET", false);
	}

}
