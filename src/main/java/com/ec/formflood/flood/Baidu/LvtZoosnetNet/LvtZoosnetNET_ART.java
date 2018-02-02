package com.ec.formflood.flood.Baidu.LvtZoosnetNet;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.ec.common.spider.generic.AsyncRestTemplateSpider;
import com.ec.common.util.FileUtil;

import net.sourceforge.tess4j.ITessAPI;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.ImageHelper;
import net.sourceforge.tess4j.util.LoadLibs;

@Component("lvtZoosnetNET_ART")
public class LvtZoosnetNET_ART extends AsyncRestTemplateSpider implements InitializingBean {

	protected static final Logger LOGGER = LoggerFactory.getLogger(LvtZoosnetNET_ART.class);

	protected static final String url = "https://lvt.zoosnet.net/LR/CheckCode3.aspx?id=40898426&sid=1516871876682878854514&d=1516873280728";

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public void crawl() {

		try {
			String filename = "download/LvtZoosnetNET/1.gif";

			HttpHeaders headers = genDownloadHeaders();
			ByteArrayInputStream is = new ByteArrayInputStream(download(getUrl(), headers));

			FileUtil.write(filename, is);

			File imageFile = new File(filename);

			doOCR(imageFile);

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	
	public static boolean isWhite(int colorInt) {
		Color color = new Color(colorInt);
		if (color.getRed() + color.getGreen() + color.getBlue() > 600) {
			return true;
		}
		return false;
	}
	
	// 2.去除图像干扰像素（非必须操作，只是可以提高精度而已）。
    public static BufferedImage removeInterference(BufferedImage image)  
            throws Exception {  
        int width = image.getWidth();  
        int height = image.getHeight();  
        for (int x = 0; x < width; ++x) {  
            for (int y = 0; y < height; ++y) {  
                if (!isWhite(image.getRGB(x, y))) {
                    // 如果当前像素是字体色，则检查周边是否都为白色，如都是则删除本像素。
                    int roundWhiteCount = 0;
                    if(isWhiteColor(image, x+1, y+1))
                        roundWhiteCount++;
                    if(isWhiteColor(image, x+1, y-1))
                        roundWhiteCount++;
                    if(isWhiteColor(image, x-1, y+1))
                        roundWhiteCount++;
                    if(isWhiteColor(image, x-1, y-1))
                        roundWhiteCount++;
                    if(roundWhiteCount == 4) {
                        image.setRGB(x, y, Color.WHITE.getRGB());  
                    }
                } 
            }  
        }  
        return image;  
     }
    
    // 取得指定位置的颜色是否为白色，如果超出边界，返回true
    // 本方法是从removeInterference方法中摘取出来的。单独调用本方法无意义。
    private static boolean isWhiteColor(BufferedImage image, int x, int y) throws Exception {
        if(x < 0 || y < 0) return true;
        if(x >= image.getWidth() || y >= image.getHeight()) return true;

        Color color = new Color(image.getRGB(x, y));
        
        return color.equals(Color.WHITE)?true:false;
    }
	
	
	private String doOCR(File imageFile) throws Exception {

		
		

		//灰化
		BufferedImage grayImage = ImageHelper.convertImageToGrayscale(ImageIO.read(imageFile));
		ImageIO.write(grayImage, "gif", new File("download/LvtZoosnetNET/", "grayImage.gif"));

		//二化
		BufferedImage binaryImage = ImageHelper.convertImageToBinary(grayImage);
		ImageIO.write(binaryImage, "gif", new File("download/LvtZoosnetNET/", "binaryImage.gif"));

		//灰化去燥
		BufferedImage grayImageRmIf=removeInterference(grayImage);
		ImageIO.write(grayImageRmIf, "gif", new File("download/LvtZoosnetNET/", "grayImageRmIf.gif"));
		//二化去燥
		BufferedImage binaryImageRmIf=removeInterference(binaryImage);
		ImageIO.write(binaryImageRmIf, "gif", new File("download/LvtZoosnetNET/", "binaryImageRmIf.gif"));
		
		
		
		
		// ITesseract instance = new Tesseract1(); // JNA Direct Mapping
		Tesseract instance = new Tesseract(); // JNA Interface Mapping
		instance.setDatapath(LoadLibs.extractTessResources("tessdata").getAbsolutePath());
		instance.setLanguage("eng");
		instance.setOcrEngineMode(ITessAPI.TessOcrEngineMode.OEM_TESSERACT_CUBE_COMBINED);

		//instance.setTessVariable("tessedit_char_blacklist", "€èéìà§ùòç$£&%éÎÉÈ§§k¥,;/:.,''‘’-[*~»!%~!@#$%^&*()_+|/.,';][\\=-“`”? <>?:\"{}");
		instance.setTessVariable("tessedit_char_whitelist", "0123456789QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm");
		
		List<String> configs=new ArrayList<>();
		configs.add("digits");
		instance.setConfigs(configs);
		
		
		System.out.println("origin:" + instance.doOCR(imageFile).trim());
		
		System.out.println("grayImage:" + instance.doOCR(grayImage).trim());
		System.out.println("binaryImage:" + instance.doOCR(binaryImage).trim());
		System.out.println("grayImageRmIf:" + instance.doOCR(grayImageRmIf).trim());
		System.out.println("binaryImageRmIf:" + instance.doOCR(binaryImageRmIf).trim());
		
		//取一小块
		
		 
		
		 
			System.out.println("rectangle:" + instance.doOCR(binaryImageRmIf, new Rectangle(0,0,22,30)).trim());
			System.out.println("rectangle:" + instance.doOCR(binaryImageRmIf, new Rectangle(22,0,22,30)).trim());
			System.out.println("rectangle:" + instance.doOCR(binaryImageRmIf, new Rectangle(44,0,22,30)).trim());
			System.out.println("rectangle:" + instance.doOCR(binaryImageRmIf, new Rectangle(66,0,22,30)).trim());
					 
		
		
		return null;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
		FileUtil.create("download/LvtZoosnetNET", false);
	}

}
