/*
 * 
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	 
 *		http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
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

/**
 * 切割图片
 * @author Administrator
 *
 */
public class UpdatePicture {

	 public static void abscut(String srcImageFile, int x, int y, int destWidth,
	            int destHeight,int finalWidth,int finalHeight) {
	        try {
	            Image img;
	            ImageFilter cropFilter;
	            // 读取源图像
	            BufferedImage bi = ImageIO.read(new File(srcImageFile));
	            int srcWidth = bi.getWidth(); // 源图宽度
	            int srcHeight = bi.getHeight(); // 源图高度
	           
	            System.out.println("srcWidth= " + srcWidth + "\tsrcHeight= "
	                    + srcHeight);
	            if (srcWidth >= destWidth && srcHeight >= destHeight) {
	                Image image = bi.getScaledInstance(finalWidth, finalHeight,Image.SCALE_DEFAULT);//获取缩放后的图片大小
	                cropFilter = new CropImageFilter(x, y, destWidth, destHeight);
	                img = Toolkit.getDefaultToolkit().createImage(
	                        new FilteredImageSource(image.getSource(), cropFilter));
	                BufferedImage tag = new BufferedImage(destWidth, destHeight,
	                        BufferedImage.TYPE_INT_RGB);
	                Graphics g = tag.getGraphics();
	                g.drawImage(img, 0, 0, null); // 绘制截取后的图
	                g.dispose();
	                // 输出为文件
	                ImageIO.write(tag, "JPEG", new File("E:/notes/picture/24.jpg"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public static Image sdg(BufferedImage image,int x, int y, int destWidth,
	            int destHeight) throws IOException{
		 ImageFilter cropFilter;
		 cropFilter = new CropImageFilter(x, y, destWidth, destHeight);
		 Image img = Toolkit.getDefaultToolkit().createImage(
                 new FilteredImageSource(image.getSource(), cropFilter));
//		 BufferedImage tag = (BufferedImage)img;
//		 BufferedImage tag = new BufferedImage(destWidth, destHeight,
//                 BufferedImage.TYPE_INT_RGB);
//         Graphics g = tag.getGraphics();
//         g.drawImage(img, 0, 0, null); // 绘制截取后的图
//         g.dispose();
//         // 输出为文件
//         ImageIO.write(tag, "JPEG", new File("E:/notes/picture/11.jpg"));
         return img;
		 
	 }
	public static BufferedImage createThumbnail(String img,int num) throws FileNotFoundException, IOException {
		BufferedImage img1 = ImageIO.read(new File(img));
//		BufferedImage thumbnail = Scalr.resize(img1,Scalr.Method.SPEED,num
//	               , Scalr.OP_ANTIALIAS, Scalr.OP_BRIGHTER);
		BufferedImage thumbnail= Scalr.resize(img1, Scalr.Method.SPEED, Scalr.Mode.AUTOMATIC,
				num,Scalr.OP_ANTIALIAS);
//		 Graphics g = thumbnail.getGraphics();
//         g.drawImage(thumbnail, 0, 0, null); // 绘制截取后的图
//         g.dispose();
//         // 输出为文件
//         ImageIO.write(thumbnail, "JPEG", new File("E:/notes/picture/24.jpg"));
		return thumbnail;
		}
	
//	public static void main(String[] args) {
//        abscut("E:/notes/picture/yingjingliya.jpg", 100, 200, 100, 200,300,600);
//        System.out.println("切割成功");
//    }
	
//	public static void main(String[] args) throws FileNotFoundException, IOException {
//		BufferedImage img = ImageIO.read(new File("E:/notes/picture/activeMq.jpg"));
//		createThumbnail("E:/notes/picture/activeMq.jpg",200);
//      System.out.println("切割成功");
//  }
	
}
