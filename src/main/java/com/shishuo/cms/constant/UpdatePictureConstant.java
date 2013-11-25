package com.shishuo.cms.constant;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.cms.dao.ConfigDao;

@Service
public class UpdatePictureConstant {

	public void updatePicture(long id,String image) throws FileNotFoundException, IOException{
		BufferedImage bi = ImageIO.read(new File(image));
        int srcWidth = bi.getWidth(); // 源图宽度
        int srcHeight = bi.getHeight(); // 源图高度
        System.out.println(srcWidth+"&&&&&&&&&&&&"+srcHeight);
        int descWidth = 0; 
        int descHeight = 0; 
        int num = 0;
        if(srcWidth>srcHeight){
        	if(srcWidth%srcHeight==0){
        		num = srcWidth/srcHeight;
        	}else{
        		num = srcWidth/srcHeight+1;
        	}	
        }else{
        	if(srcHeight%srcWidth==0){
        		num = srcHeight/srcWidth;
        	}else{
        		num = srcHeight/srcWidth+1;
        	}	
        }
//		String picture = ConfigConstant.IMAGE;
        String picture = "200x150;300x200;";
		System.out.println(picture);
		String[] str = picture.split(";");
		BufferedImage descImg = null;
		Image finalImg= null;
		int height = 0;
		int width = 0;
		for(int i=0;i<str.length;i++){
			String[] se = str[i].split("x");
			height=Integer.parseInt(se[0]);
			width=Integer.parseInt(se[1]);
			if(height>width){
				descImg=UpdatePicture.createThumbnail(bi,height*num);
			}else{
				descImg=UpdatePicture.createThumbnail(bi,width*num);
			}
			descWidth=descImg.getWidth();
			descHeight=descImg.getHeight();
			System.out.println("descWidth="+descWidth+"********descHeight="+descHeight);
			System.out.println("(descWidth-width)/2="+(descWidth-width)/2+"*******(descHeight-height)/2="+(descHeight-height)/2);
			Graphics gq = descImg.getGraphics();
			gq.drawImage(descImg, 0, 0, null); // 绘制截取后的图
			gq.dispose();
			ImageIO.write(descImg, "JPEG", new File("E:/notes/picture/10.jpg"));
			finalImg=UpdatePicture.sdg(descImg,(descWidth-width)/2,(descHeight-height)/2,width,height);
			BufferedImage tag = new BufferedImage(width, height,
	                 BufferedImage.TYPE_INT_RGB);
			
			Graphics g = tag.getGraphics();
	         g.drawImage(finalImg, 0, 0, null); // 绘制截取后的图
	         g.dispose();
	         // 输出为文件
	         ImageIO.write(tag, "JPEG", new File("E:/notes/picture/"+3+i+".jpg"));
		}
	}
	
//	public static void main(String[] args) throws IOException {
//		UpdatePictureConstant uo = new UpdatePictureConstant();
//		uo.updatePicture(1,"E:/notes/picture/activeMq.jpg");
//	}
}
