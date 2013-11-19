package com.shishuo.cms.action.admin;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.shishuo.cms.constant.FileConstant;
import com.shishuo.cms.entity.vo.PageVo;

@Controller
@RequestMapping("/admin/picture")
public class AdminPictureUpLoadAction extends AdminBaseAction {
	
	@RequestMapping(method = RequestMethod.GET)
	public String upload() {
		return "admin/pictureUpload";
	}

	@ResponseBody
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public ModelAndView handleRequest(@RequestParam("file") MultipartFile file,
			HttpServletRequest request) throws Exception {
		if (this.checkPhotoFile(file)) {
			String webroot = System.getProperty("cms.app.root");
			String path = webroot+"/upload/"+System.currentTimeMillis()+".jpg";
			File source = new File(path);
			fileService.addFile(0, file.getOriginalFilename(), path, "", "", 4);
			file.transferTo(source);
		} else {
			String errorMessage = "上传的文件只能是jpg,png,gif的图片格式";
		}
		return null;
	}

	public boolean checkPhotoFile(MultipartFile file) {
		if (file.isEmpty()) {
			return false;
		}
		if (file.getContentType().equals("image/jpg")
				|| file.getContentType().equals("image/png")
				|| file.getContentType().equals("image/jpeg")
				|| file.getContentType().equals("image/gif")) {
			return true;
		} else {
			return false;
		}
	}

    @RequestMapping(value = "list", method = RequestMethod.GET)
	 public String list(@RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum,
			            HttpServletRequest request,ModelMap modelMap){
           PageVo<com.shishuo.cms.entity.File> filePage = fileService.getUserImagePage(1, 4, pageNum);
          modelMap.addAttribute("filePage", filePage);
    	    return "admin/pictureList";
    }
	
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(@RequestParam("fileId") String fileId,HttpServletRequest request){
    	String[] fileIdArray = fileId.split(",");
    	for(String id : fileIdArray){
    		fileService.deleteFileById(Long.parseLong(id));
    	}
    	return null;
    }
    
    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String update(@RequestParam("fileId") String fileId,
    		             @RequestParam("folderId") long folderId,
    		             HttpServletRequest request){
    	String[] fileIdArray = fileId.split(",");
    	for(String id : fileIdArray){
    		fileService.updateImage(folderId, Long.parseLong(id), 4);
    	}
    	return null;
    }
    
    
}
