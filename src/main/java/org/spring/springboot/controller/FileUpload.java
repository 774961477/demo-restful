package org.spring.springboot.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 * 
 * @author Fly
 *
 */
@RestController
public class FileUpload {

	/**
	 * 文件上传根目录(在Spring的application.yml的配置文件中配置):<br>
	 * web: upload-path: （jar包所在目录）/resources/static/
	 */
	@Value("${web.upload-path}")
	private String webUploadPath;

	/**
	 * ResultVo是一个对象，包含： private int errorCode; private String errorMsg; private
	 * Integer total; private Object data;
	 */

	/**
	 * 基于用户标识的头像上传
	 * 
	 * @param file
	 *            图片
	 * @param userId
	 *            用户标识
	 * @return
	 */
	@PostMapping(value = "/fileUpload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> fileUpload(@RequestParam("file") MultipartFile file) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (!file.isEmpty()) {
			if (file.getContentType().contains("image")) {
				try {

					Date nowDate = new Date();
					String year = String.valueOf(nowDate.getYear());
					String month = String.valueOf(nowDate.getMonth());

					String temp = "images" + File.separator + "upload" + File.separator + year + File.separator + month
							+ File.separator;
					// 获取图片的文件名
					String fileName = file.getOriginalFilename();
					// 获取图片的扩展名
					//String extensionName = StringUtils.substringAfter(fileName, ".");
					String extensionName = file.getContentType().split("/")[1];
					// 新的图片文件名 = 获取时间戳+"."图片扩展名
					
					String prefixName = String.valueOf(System.currentTimeMillis()) ;
					String newFileName = prefixName + "." + extensionName;
					// 数据库保存的目录
					String datdDirectory = temp.concat(File.separator);
					// 文件路径
					String filePath = webUploadPath.concat(datdDirectory);

					File dest = new File(filePath, newFileName);
					if (!dest.getParentFile().exists()) {
						dest.getParentFile().mkdirs();
					}

					// 上传到指定目录
					file.transferTo(dest);

					// 将反斜杠转换为正斜杠
					String data = "uploadfile/" + datdDirectory.replaceAll("\\\\", "/") + newFileName;

					resultMap.put("file", data);
					resultMap.put("fileId", prefixName);
					
					// resultVo.setData(resultMap);
					// resultVo.setError(1, "上传成功!");
				} catch (IOException e) {
					// resultVo.setError(0, "上传失败!");
				}
			} else {
				// resultVo.setError(0, "上传的文件不是图片类型，请重新上传!");
			}
			return resultMap;
		} else {
			// resultVo.setError(0, "上传失败，请选择要上传的图片!");
			return resultMap;
		}
	}

}
