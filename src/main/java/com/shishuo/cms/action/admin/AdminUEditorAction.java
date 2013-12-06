package com.shishuo.cms.action.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shishuo.cms.constant.SystemConstant;
import com.shishuo.cms.util.HttpUtils;
import com.shishuo.cms.util.UploadUtils;

@Controller
@RequestMapping("/admin/ueditor")
public class AdminUEditorAction extends AdminBaseAction {

	/**
	 * @see imageManager.jsp
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/photo/manager.htm", method = RequestMethod.POST)
	public String photoManager(HttpServletRequest request) {
		String photoUploadPath = HttpUtils.getRealPath()
				+ SystemConstant.UPLOAD_PHOTO_PATH;
		List<File> fileList = UploadUtils.getFiles(photoUploadPath,
				new ArrayList<File>(), UploadUtils.PHOTO_TYPE);
		String imgStr = "";
		for (File file : fileList) {
			imgStr += file.getPath().replace(HttpUtils.getRealPath(), "")
					+ "ue_separate_ue";
		}
		if (imgStr != "") {
			imgStr = imgStr.substring(0, imgStr.lastIndexOf("ue_separate_ue"))
					.replace(File.separator, "/").trim();
		}
		return imgStr;
	}

	@ResponseBody
	@RequestMapping(value = "/photo/upload.htm", method = RequestMethod.POST)
	public String upload(@RequestParam("dir") String dir,
			@RequestParam("fileName") String fileName,
			@RequestParam("pictitle") String pictitle,
			@RequestParam("upfile") MultipartFile file,
			HttpServletRequest request) {
		String photoUploadPath = HttpUtils.getRealPath()
				+ SystemConstant.UPLOAD_PHOTO_PATH;
		String photoPath = UploadUtils.getFolder(photoUploadPath) + "/"
				+ fileName;
		try {
			file.transferTo(new File(photoPath));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("original", fileName);
		json.put("url", photoPath.replace(HttpUtils.getRealPath(), ""));
		json.put("title", pictitle);
		json.put("state", "SUCCESS");
		return json.toString();
	}
}
