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

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
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

	 public static Image sdg(BufferedImage image,int x, int y, int destWidth,
	            int destHeight) throws IOException{
		 ImageFilter cropFilter;
		 cropFilter = new CropImageFilter(x, y, destWidth, destHeight);
		 Image img = Toolkit.getDefaultToolkit().createImage(
                 new FilteredImageSource(image.getSource(), cropFilter));
         return img;
		 
	 }
	public static BufferedImage createThumbnail(String img,int num) throws FileNotFoundException, IOException {
		BufferedImage img1 = ImageIO.read(new File(img));
		BufferedImage thumbnail= Scalr.resize(img1, Scalr.Method.SPEED, Scalr.Mode.AUTOMATIC,
				num,Scalr.OP_ANTIALIAS);
		return thumbnail;
		}
	
}
