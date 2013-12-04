package com.shishuo.cms.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.shishuo.cms.constant.FileConstant;
import com.shishuo.cms.constant.SystemConstant;
import com.shishuo.cms.constant.FileConstant.Type;


@Service
public class UpdatePictureConstant {

	/**
	 * 按照指定大小切割图片并存到服务器
	 */
	public void updateArticlePicture(long id,String image,String picture) throws FileNotFoundException, IOException{
		BufferedImage bi = ImageIO.read(new File(image));
        int srcWidth = bi.getWidth(); // 源图宽度
        int srcHeight = bi.getHeight(); // 源图高度
        int descWidth = 0; 
        int descHeight = 0; 
        int num = 0;
        String webroot = System.getProperty(SystemConstant.SHISHUO_CMS_ROOT);
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
		String[] str = picture.split(";");
		BufferedImage descImg = null;
		Image finalImg= null;
		int height = 0;
		int width = 0;
			String[] se = str[0].split("x");
				height=Integer.parseInt(se[0]);
				width=Integer.parseInt(se[1]);
				if(height>=width){
					descImg=UpdatePicture.createThumbnail(image,height*num);
				}else{
					descImg=UpdatePicture.createThumbnail(image,width*num);
				}
				descWidth=descImg.getWidth();
				descHeight=descImg.getHeight();
				finalImg=UpdatePicture.sdg(descImg,(descWidth-width)/2,(descHeight-height)/2,width,height);
				BufferedImage tag = new BufferedImage(width, height,
	                 BufferedImage.TYPE_INT_RGB);
				Graphics g = tag.getGraphics();
				g.drawImage(finalImg, 0, 0, null); // 绘制截取后的图
				g.dispose();
				// 输出为文件
				ImageIO.write(tag, "JPEG", new File(webroot+"/upload/article/"+id+"_big.jpg"));
	        
	        String[] se1 = str[1].split("x");
				height=Integer.parseInt(se1[0]);
				width=Integer.parseInt(se1[1]);
				if(height>=width){
					descImg=UpdatePicture.createThumbnail(image,height*num);
				}else{
					descImg=UpdatePicture.createThumbnail(image,width*num);
				}
				descWidth=descImg.getWidth();
				descHeight=descImg.getHeight();
				finalImg=UpdatePicture.sdg(descImg,(descWidth-width)/2,(descHeight-height)/2,width,height);
				BufferedImage tag1 = new BufferedImage(width, height,
		                 BufferedImage.TYPE_INT_RGB);
				Graphics g1 = tag1.getGraphics();
		        g1.drawImage(finalImg, 0, 0, null); // 绘制截取后的图
		        g1.dispose();
		        // 输出为文件
		        ImageIO.write(tag1, "JPEG", new File(webroot+"/upload/article/"+id+"_small.jpg"));
	}
	
	public void updatePicture(long id,String image,String picture,FileConstant.Type type) throws FileNotFoundException, IOException{
		BufferedImage bi = ImageIO.read(new File(image));
        int srcWidth = bi.getWidth(); // 源图宽度
        int srcHeight = bi.getHeight(); // 源图高度
        int descWidth = 0; 
        int descHeight = 0; 
        int num = 0;
        String webroot = System.getProperty(SystemConstant.SHISHUO_CMS_ROOT);
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
		BufferedImage descImg = null;
		Image finalImg= null;
		int height = 0;
		int width = 0;
			String[] se = picture.split("x");
				height=Integer.parseInt(se[0]);
				width=Integer.parseInt(se[1]);
				if(height>=width){
					descImg=UpdatePicture.createThumbnail(image,height*num);
				}else{
					descImg=UpdatePicture.createThumbnail(image,width*num);
				}
				descWidth=descImg.getWidth();
				descHeight=descImg.getHeight();
				finalImg=UpdatePicture.sdg(descImg,(descWidth-width)/2,(descHeight-height)/2,width,height);
				BufferedImage tag = new BufferedImage(width, height,
	                 BufferedImage.TYPE_INT_RGB);
				Graphics g = tag.getGraphics();
				g.drawImage(finalImg, 0, 0, null); // 绘制截取后的图
				g.dispose();
				// 输出为文件
				ImageIO.write(tag, "JPEG", new File(webroot+"/upload/"+type+"/"+id+"_picture.jpg"));
	}
}
