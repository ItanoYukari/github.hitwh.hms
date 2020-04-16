package com.hlh.config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	public static String upload( MultipartFile mFile,HttpServletRequest request){
		SimpleDateFormat yformat = new SimpleDateFormat("yyyy");
		SimpleDateFormat mformat = new SimpleDateFormat("MM");
		SimpleDateFormat dformat = new SimpleDateFormat("dd");
		Date nowTime = new Date();
		String year = yformat.format(nowTime);
		String month = mformat.format(nowTime);
		String day = dformat.format(nowTime);
		String SavePath = "src/main/resources/static/files/" + year + "_" + month+"_"+day+"/";
		System.out.print(SavePath);
		File directory = new File(SavePath);
		if(!directory.exists()){
			directory.mkdirs();
		}
		String SaveUrl = "/static/files/" + year + "_" + month+"_"+day+"/";
		Date dt = new Date();
		Random random = new Random();
		//文件重新命名
		String FileNameAuto = String.format("%X_%X", new Object[] {
				new Integer((int) (dt.getTime())),
				new Integer(random.nextInt()) });
		String name= mFile.getOriginalFilename();  
		int pos = name.lastIndexOf(".");
		//获取文件名后缀Fi
		String ext = name.substring(pos);
		String baseName=FileNameAuto+ext;
		OutputStream outputStream =null;
		try {
			outputStream = new FileOutputStream(SavePath+baseName);
			FileCopyUtils.copy(mFile.getInputStream(), outputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(outputStream!=null){
					outputStream.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return SaveUrl+baseName;
	}
	
	public static String upload2( MultipartFile mFile,HttpServletRequest request){
		SimpleDateFormat yformat = new SimpleDateFormat("yyyy");
		SimpleDateFormat mformat = new SimpleDateFormat("MM");
		SimpleDateFormat dformat = new SimpleDateFormat("dd");
		Date nowTime = new Date();
		String year = yformat.format(nowTime);
		String month = mformat.format(nowTime);
		String day = dformat.format(nowTime);
		String SavePath = "src/main/resources/static/files/" + year + "_" + month+"_"+day+"/";
		System.out.print(SavePath);
		File directory = new File(SavePath);
		if(!directory.exists()){
			directory.mkdirs();
		}
		String SaveUrl = "/static/files/" + year + "_" + month+"_"+day+"/";
		Date dt = new Date();
		Random random = new Random();
		//文件重新命名
		String FileNameAuto = String.format("%X_%X", new Object[] {
				new Integer((int) (dt.getTime())),
				new Integer(random.nextInt()) });
		String name= mFile.getOriginalFilename();  
		int pos = name.lastIndexOf(".");
		//获取文件名后缀Fi
		String ext = name.substring(pos);
		String baseName=FileNameAuto+ext;
		OutputStream outputStream =null;
		try {
			outputStream = new FileOutputStream(SavePath+baseName);
			FileCopyUtils.copy(mFile.getInputStream(), outputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(outputStream!=null){
					outputStream.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return SavePath+baseName;
	}
	
	//删除
	public static void deleteFile(HttpServletRequest request,String filename){
		String f = request.getSession().getServletContext().getRealPath(
				"/")+filename;
		File file = new File(f);
		file.delete();
	}

}
