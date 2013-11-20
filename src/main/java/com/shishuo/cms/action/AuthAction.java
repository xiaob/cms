package com.shishuo.cms.action;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.shishuo.cms.entity.vo.JsonVo;
import com.shishuo.cms.exception.AuthException;
import com.shishuo.cms.exception.ValidateException;
import com.shishuo.cms.service.AdminService;

/**
 * @author Herbert
 * 
 */

@Controller
@RequestMapping("/auth")
public class AuthAction extends BaseAction {

	/**
	 * Kaptcha 验证码
	 */
	@Autowired
	private DefaultKaptcha captchaProducer;

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "admin/login", method = RequestMethod.GET)
	public String admin(HttpServletRequest request, ModelMap modelMap) {
		return "admin/login";
	}

	@ResponseBody
	@RequestMapping(value = "admin/login.json", method = RequestMethod.POST)
	public JsonVo<String> adminLogin(
			@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "captcha") String captcha,
			HttpServletRequest request, ModelMap modelMap) {
		JsonVo<String> json = new JsonVo<String>();

		try {
			String kaptcha = (String) request.getSession().getAttribute(
					com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
			if (!EmailValidator.getInstance().isValid(email)) {
				json.getErrors().put("email", "邮件格式错误");
			}
			if (StringUtils.isBlank(password)) {
				json.getErrors().put("password", "密码不能为空");
			} else if (password.length() < 6 && password.length() > 30) {
				json.getErrors().put("password", "密码最少6个字符，最多30个字符");
			}
			// 校验验证码
			if (StringUtils.isNotBlank(kaptcha)
					&& kaptcha.equalsIgnoreCase(captcha)) {

			} else {
				json.getErrors().put("captcha", "验证码错误");
			}

			this.validate(json);

			adminService.adminLogin(email, password, request);

		} catch (Exception e) {
			json.setResult(false);
			json.getErrors().put("password", "邮箱或密码错误");
		}
		return json;
	}

	/**
	 * 生成验证码
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "captcha", method = RequestMethod.GET)
	public void captcha(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control",
				"no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		String capText = captchaProducer.createText();
		request.getSession().setAttribute(
				com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY, capText);
		BufferedImage bi = captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
	}


}
