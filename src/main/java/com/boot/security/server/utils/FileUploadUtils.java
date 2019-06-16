package com.boot.security.server.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

public class FileUploadUtils {
	/**
	 * 
	AccessDenied 拒绝访问 403 
	BucketAlreadyExists Bucket已经存在 409 
	BucketNotEmpty Bucket不为空 409 
	EntityTooLarge 实体过大 400 
	EntityTooSmall 实体过小 400 
	FileGroupTooLarge 文件组过大 400 
	FilePartNotExist 文件Part不存在 400 
	FilePartStale 文件Part过时 400 
	InvalidArgument 参数格式错误 400 
	InvalidAccessKeyId AccessKeyId不存在 403 
	InvalidBucketName 无效的Bucket名字 400 
	InvalidDigest 无效的摘要 400 
	InvalidObjectName 无效的Object名字 400 
	InvalidPart 无效的Part 400 
	InvalidPartOrder 无效的part顺序 400 
	InvalidTargetBucketForLogging Logging操作中有无效的目标bucket 400 
	InternalError OSS内部发生错误 500 
	MalformedXML XML格式非法 400 
	MethodNotAllowed 不支持的方法 405 
	MissingArgument 缺少参数 411 
	MissingContentLength 缺少内容长度 411 
	NoSuchBucket Bucket不存在 404 
	NoSuchKey 文件不存在 404 
	NoSuchUpload Multipart Upload ID不存在 404 
	NotImplemented 无法处理的方法 501 
	PreconditionFailed 预处理错误 412 
	RequestTimeTooSkewed 发起请求的时间和服务器时间超出15分钟 403 
	RequestTimeout 请求超时 400 
	SignatureDoesNotMatch 签名错误 403 
	InvalidEncryptionAlgorithmError 指定的熵编码加密算法错误 400 
 * @param root
 * @param imgurl
 * @return
 */
	private static final String OSSURL="https://oss-cn-hangzhou.aliyuncs.com";
	private static final String ACCESSKEYID="LTAIBe76IbDU9Dqs";
	private static final String ACCESSKEYSECRET="jznoItBnzonaOP6KG1eCWJMCwqGNL8";
	public static String uploadOss(String root,String imgurl,String bucket,String bucketpath){ 
		OSSClient client = new OSSClient(OSSURL,ACCESSKEYID,ACCESSKEYSECRET);
		String path = "";
		try{
			client.setBucketAcl(bucket, CannedAccessControlList.PublicRead);
            File file = new File(root+"/"+imgurl);
			client.putObject(bucket, bucketpath+imgurl, file);
		}catch (OSSException oe) {
		    path = oe.getErrorCode()+":"+oe.getErrorMessage();
		}catch (ClientException ce) {
		    path = ce.getErrorCode()+":"+ce.getMessage();
		} finally {
		    if (client != null) {
		    	client.shutdown();
		    }
		}
		return path;	
	}
	
	
	/**
	 * 生成二维码，返回图片路径
	 */
	public static String generateEwm(String ewmUrl){
		String root = PropertyHolder.getServerPath();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String rpath = "/ewm/" + sdf.format(new Date()).substring(0,6);
		File dir = new File(root+rpath);
		if(!dir.exists()){
			dir.mkdirs();
		}
		String fileName = FileUploadUtils.getImageByType("jpg");
		String allpath = dir + "/" + fileName;
		try{
			genetateMatrix(ewmUrl,allpath,"jpg");
		}catch (Exception e) {
			e.printStackTrace();
		}
		//上传到oss上
		String mess = uploadOss(root,rpath+"/"+fileName,"whtxcx","upload");
		if(!"".equals(mess)){
			System.out.println("二维码上传到oss失败："+rpath+"/"+fileName);
			return rpath+"/"+fileName;
		}else{
			//删除本地图片
			System.out.println("删除本地二维码："+root+rpath+"/"+fileName);
			File localfile = new File(root+rpath+"/"+fileName);
			if(localfile.exists()&&localfile.isFile()){
				localfile.delete();
			}
			rpath = "https://whtxcx.oss-cn-hangzhou.aliyuncs.com/upload"+rpath+"/"+fileName;
			System.out.println("oss二维码路径："+rpath);
			return rpath;
		}
	}
	
	/**
	 * 根据类型生成名称
	 * @param filetype
	 * @return
	 */
	public static String getImageByType(String filetype) {
		return RandomStringUtils.randomAlphabetic(8)+ "."+filetype;
	}
	
	/**
	 * 生成二维码
	 */
	public static void genetateMatrix(String text,String pathname,String format) throws Exception{
		int width = 300;
		int height = 300;
		Hashtable hints = new Hashtable();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height,hints);
		//生成二维码
		File outputfile = new File(pathname);
		MatrixToImageWriter.writeToFile(bitMatrix, format, outputfile);
	}
	
	public static void main(String[] args) {
		generateEwm("11111");
	}
}

