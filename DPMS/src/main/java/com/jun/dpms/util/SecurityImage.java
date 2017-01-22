package com.jun.dpms.util;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

public class SecurityImage {
	/**
	 * 鐢熸垚楠岃瘉鐮佸浘鐗�
	 * @param securityCode 楠岃瘉鐮佸瓧绗�
	 * @return BufferedImage 鍥剧墖
	 */
	public static BufferedImage createImage(String securityCode){
		//楠岃瘉鐮侀暱搴�
		int codeLength=securityCode.length();
		//瀛椾綋澶у皬
		int fSize=15;
		int fWidth=fSize+1;
		//鍥剧墖瀹藉害
		int width=codeLength*fWidth+6;
		//鍥剧墖楂樺害
		int height = fSize*2+1;
	
		//鍥剧墖
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.createGraphics();
		
		//璁剧疆鑳屾櫙鑹�
		g.setColor(Color.WHITE);
		//濉厖鑳屾櫙
		g.fillRect(0, 0, width, height);
		//璁剧疆杈规棰滆壊
		g.setColor(Color.LIGHT_GRAY);
		//杈规瀛椾綋鏍峰紡
		g.setFont(new Font("Arial",Font.BOLD,height-2));
		//缁樺埗杈规
		g.drawRect(0, 0, width-1, height-1);
		
		//缁樺埗鍣偣
		Random rand= new Random();
		g.setColor(Color.LIGHT_GRAY);
		for(int i=0;i<codeLength*6;i++){
			int x = rand.nextInt(width);
			int y= rand.nextInt(height);
			
			//缁樺埗1*1澶у皬鐨勭煩褰�
			g.drawRect(x, y, 1, 1 );
			
		
		}
		//缁樺埗楠岃瘉鐮�
		int codeY=height-10;
		//璁剧疆瀛椾綋棰滆壊鍜屾牱寮�
		g.setColor(new Color(19, 148, 246));
		g.setFont(new Font("Georgia", Font.BOLD, fSize));
		for(int i=0;i<codeLength;i++){
			g.drawString(String.valueOf(securityCode.charAt(i)), i*16+5, codeY);
		}
		
		//鍏抽棴璧勬簮
		g.dispose();
		return image;
	}
	/**
	 * 杩斿洖楠岃瘉鐮佸浘鐗囨祦鏍煎紡
	 * @param securityCode 楠岃瘉鐮�
	 * @return ByteArrayInputStream 鍥剧墖娴�
	 */
	public static ByteArrayInputStream getImageAsInputStream(String securityCode){
		BufferedImage image = createImage(securityCode);
		return convertImageToStream(image);
	}
	
	/**
	 * 灏咮ufferedImage杞崲涓築yteArrayInputStream
	 * @param image 鍥剧墖
	 * @return ByteArrayInputStream 娴�
	 */
	private static ByteArrayInputStream convertImageToStream(BufferedImage image) {
		// TODO Auto-generated method stub
		ByteArrayInputStream inputStream =null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageOutputStream iot;
		try {
			iot=ImageIO.createImageOutputStream(bos);
			ImageIO.write(image, "jpeg", iot);
			inputStream = new ByteArrayInputStream(bos.toByteArray());
			System.out.println(inputStream);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return inputStream;
	}
	
}
