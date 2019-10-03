package com.aplus.gaming.schedular.utils.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Collection;
import java.util.HashSet;


/**
 * 文件操作通用类
 * 
 * @author ZMM
 */
public class FileUtil {
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
	private static final String DEFAULT_ENCODING = "UTF-8";

	private FileUtil() {
	}

	/**
	 * 读取文件到字符串中
	 * 
	 * 
	 * @param strFilePath
	 *            文件全路径(含文件名)
	 * @param strCoding
	 *            编码格式
	 * @return String
	 */
	public static String fileToString(String strFilePath, String strCoding) {
		StringBuilder strBuffResult = new StringBuilder();
		int i;
		if (strCoding == null || strCoding.trim().length() <= 0) {
			strCoding = DEFAULT_ENCODING;
		}
		BufferedReader bufferedReader = null;
		InputStreamReader inputStreamReader = null;
		try(FileInputStream fileInputStream = new FileInputStream(strFilePath)) {
			if (strCoding.trim().length() <= 0) {
				inputStreamReader = new InputStreamReader(fileInputStream);
			} else {
				inputStreamReader = new InputStreamReader(fileInputStream, strCoding);
			}
			bufferedReader = new BufferedReader(inputStreamReader);
			while ((i = bufferedReader.read()) != -1) {
				strBuffResult.append((char) i);
			}
		} catch (Exception ex) {
			logger.info("读取文件到字符串发生异常." + ex);
		} finally {
			try {
				assert bufferedReader != null;
				bufferedReader.close();
			} catch (IOException ignored) {
			}
			try {
				inputStreamReader.close();
			} catch (IOException ignored) {
			}
		}
		// 释放对象
		return strBuffResult.toString();
	}

	/**
	 * 将字符串写入到文件中
	 * 
	 * @param strContent
	 *            字符串内容
	 * 
	 * @param strFilePath
	 *            文件全路径(含文件名)
	 * @param strCoding
	 *            编码格式,默认：UTF-8
	 * @return boolean
	 */
	public static boolean stringToFile(String strContent, String strFilePath,
			String strCoding) {
		boolean blnResult = false;
		if (strCoding == null || strCoding.trim().length() <= 0) {
			strCoding = DEFAULT_ENCODING;
		}
		try (FileOutputStream fileOutputStream = new FileOutputStream(strFilePath);
			Writer writer =(strCoding == null || strCoding.trim().length() <= 0)
				?new OutputStreamWriter(fileOutputStream) :new OutputStreamWriter(fileOutputStream, strCoding);
			){
			writer.write(strContent);
			writer.flush();
			blnResult = true;
		} catch (Exception ex) {
			logger.info("类:FileUtil；方法:stringToFile；信息:" + ex);
		}
		// 释放对象
		strCoding = null;
		strContent = null;
		strFilePath = null;
		return blnResult;
	}

	/**
	 * 将二进制文件写入磁盘
	 * 
	 * @param file
	 *            二进制文件内容
	 * 
	 * 
	 * 
	 * @param strFilePath
	 *            文件全路径(含文件名)
	 * 
	 * @return boolean
	 */
	public static boolean byteToFile(byte[] file, String strFilePath) {
		boolean blnResult = false;
		File tmp_file = null;
		FileOutputStream fileOutputStream = null; // 文件输出对象
		try {
			// 检查该文件是否存在
			tmp_file = new File(strFilePath);
			if (tmp_file.exists()) {
				tmp_file.delete();
			}
			fileOutputStream = new FileOutputStream(strFilePath);
			fileOutputStream.write(file);
			blnResult = true;
		} catch (Exception ex) {
			logger.info("类:FileUtil；方法:byteToFile；信息:" + ex);
		} finally {
			if(fileOutputStream!=null){
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			fileOutputStream = null;
		}
		// 释放对象

		strFilePath = null;
		return blnResult;
	}

	/**
	 * 新建目录
	 * 
	 * @param strFolderPath
	 *            目录路径（含要创建的目录名称）
	 * 
	 * @return boolean
	 */
	public static boolean createFolder(String strFolderPath) {
		boolean blnResult = true;
		File file;
		if (strFolderPath != null && strFolderPath.trim().length() > 0) {
			try {
				file = new File(strFolderPath);
				if (!file.exists()) {
					blnResult = file.mkdirs();
				}
			} catch (Exception e) {
				logger.info("目录操作出错:"+ strFolderPath, e);
				blnResult = false;
			} 
		}
		return blnResult;
	}

	/**
	 * 复制整个文件夹的内容
	 * 
	 * @param strOldFolderPath
	 *            准备拷贝的目录
	 * 
	 * @param strNewFolderPath
	 *            指定绝对路径的新目录
	 * @return void
	 */
	public static void copyFolder(String strOldFolderPath,
			String strNewFolderPath) {
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		File file = null;
		String[] strArrayFile = null;
		File fileTemp = null;
		byte[] byteArray = null;
		int intIndex = 0;
		try {
			new File(strNewFolderPath).mkdirs(); // 如果文件夹不存在 则建立新文件夹

			file = new File(strOldFolderPath);
			strArrayFile = file.list();
			for (int i = 0; i < strArrayFile.length; i++) {
				if (strOldFolderPath.endsWith(File.separator)) {
					fileTemp = new File(strOldFolderPath + strArrayFile[i]);
				} else {
					fileTemp = new File(strOldFolderPath + File.separator
							+ strArrayFile[i]);
				}
				if (fileTemp.isFile() && !fileTemp.isHidden()) {
					fileInputStream = new FileInputStream(fileTemp);
					fileOutputStream = new FileOutputStream(strNewFolderPath
							+ "/" + fileTemp.getName());
					byteArray = new byte[1024 * 5];
					while ((intIndex = fileInputStream.read(byteArray)) != -1) {
						fileOutputStream.write(byteArray, 0, intIndex);
					}
					fileOutputStream.flush();
					//fileOutputStream.close();
					//fileInputStream.close();
					intIndex = 0;
				}
				if (fileTemp.isDirectory() && !fileTemp.isHidden()) {// 如果是子文件夹

					copyFolder(strOldFolderPath + File.separator
							+ strArrayFile[i], strNewFolderPath
							+ File.separator + strArrayFile[i]);
				}
			}
		} catch (Exception e) {
			logger.info("类:FileUtil,方法:copyFolder,信息:复制整个文件夹内容操作出错," + e);
		} finally {
			if(	fileOutputStream != null){
				try {
					fileOutputStream.close();
				} catch (IOException e) {
				}
			}

				if( fileInputStream != null) {
					try {
						fileInputStream.close();
					} catch (IOException e) {
					}
				}
			fileInputStream = null;
			fileOutputStream = null;
			file = null;
			fileTemp = null;
			byteArray = null;
		}
		// 释放对象
		strArrayFile = null;
		strNewFolderPath = null;
		strOldFolderPath = null;
	}
	
	/**
	 * 复制单个文件
	 * @param s 准备移动的文件名
	 * @param d 移动到新目录的文件名
	 */
	public static boolean moveFile(String s, String d) {
		boolean flag = true;
		File src = new File(s);
		File dst = new File(d);
		if(src.exists()&&src.isFile()){
			if(dst.exists()){
				if(dst.isFile()){
					dst.delete();
				}else if(dst.isDirectory()){
					delFolder(d);
				}
			}else{
				String tmpstr = d.substring(0,d.lastIndexOf("/"));
				File tmpdir = new File(tmpstr);
				if (!tmpdir.exists()&&!tmpdir.isDirectory()){
					tmpdir.mkdirs();
				}
			}
			flag = src.renameTo(dst);
		}else{
			flag = false;
		}
		return flag;
	}

	/**
	 * 删除文件夹
	 * 
	 * 
	 * @param strFolderPath
	 *            文件夹完整绝对路径
	 * 
	 * @return void
	 */
	public static void delFolder(String strFolderPath) {
		File file;
		if (strFolderPath != null && strFolderPath.trim().length() > 0) {
			try {
				delAllFile(strFolderPath); // 删除完里面所有内容

				file = new File(strFolderPath);
				file.delete(); // 删除空文件夹
			} catch (Exception e) {
				logger.info("类:FileUtil,方法:delFolder,信息:删除目录有误," + e);
			}
		} else {
			logger.info("strFolderPath=null");
		}
	}

	/**
	 * 删除指定文件夹下所有文件及目录
	 * 
	 * @param strFolderPath
	 *            文件夹完整绝对路径
	 * 
	 * @return boolean
	 */
	public static void delAllFile(String strFolderPath) {
		int intFileCount;
		String[] strArrayFile;
		File file = new File(strFolderPath);
		if (file.exists() && file.isDirectory()) {
			strArrayFile = file.list();
			if (strArrayFile == null || strArrayFile.length <= 0) {
			} else {
				intFileCount = strArrayFile.length;
				if (intFileCount > 0) {
					for (int i = 0; i < intFileCount; i++) {
						if (strFolderPath.endsWith(File.separator)) {
							file = new File(strFolderPath + strArrayFile[i]);
						} else {
							file = new File(strFolderPath + File.separator
									+ strArrayFile[i]);
						}
						if (file.isFile()) {
							file.delete();
						}
						if (file.isDirectory()) {
							delAllFile(strFolderPath + File.separator
									+ strArrayFile[i]);// 先删除文件夹里面的文件

							delFolder(strFolderPath + File.separator
									+ strArrayFile[i]);// 再删除空文件夹

						}
					}
				} else {
				}
			}
		} else {
			logger.info("类:FileUtil,方法:delAllFile,信息:删除文件目录有误," + strFolderPath);
		}
	}

	/**
	 * 获取目录下所有文件包括子文件夹
	 * 
	 * @param basePath
	 *            根目录
	 * @param filter
	 *            过滤条件，使用','分割
	 * @param container
	 *            符合条件的集合
	 * @return
	 */
	private static Collection<File> getAllFiles(final String basePath, final String filter, final Collection<File> container) {
		if (basePath != null && !"".equals(basePath) && container != null) {
			File file = new File(basePath);
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (File f : files) {
					getAllFiles(f.getAbsolutePath(), filter, container);
				}
			} else {
				String[] filters = filter.split(",");
				for (String strFilter : filters) {
					String fName = file.getAbsolutePath().toLowerCase();
					String strFilterLowCase = strFilter.trim().toLowerCase();
					boolean isSubFix = strFilterLowCase.startsWith(".");
					boolean isContains = fName.contains(strFilterLowCase);
					if (isSubFix) {
						isContains = false;
					}
					if (isSubFix && fName.endsWith(strFilterLowCase)
							|| isContains) {
						container.add(file);
						break;
					}
				}
			}
		}
		return container;
	}

	/**
	 * 获取目录下所有文件包括子文件夹
	 * 
	 * @param basePath
	 */
	public static Collection<File> getAllFiles(final String basePath,
			final String filter) {
		return getAllFiles(basePath, filter, new HashSet<File>());
	}

	/**
	 * 根据路径创建文件
	 * 
	 * @param filePath
	 *            文件路径+文件名
	 * @return boolean
	 */
	public static boolean createFileByPath(String filePath) {
		boolean result = false;
		try {
			File file = new File(filePath);
			result = file.createNewFile();
		} catch (IOException e) {
			logger.info(filePath + " 文件创建失败.", e);
		}
		return result;
	}
	
	/**
	 * 将文件转换为byte数组
	 * @param file
	 * @return
	 */
	public static byte[] fileToBytes(String file){
		byte[] bytes = null;
		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File(file)));
			ByteArrayOutputStream out = new ByteArrayOutputStream(1024)){
			byte[] temp = new byte[1024];
			int size = 0;
			while ((size = in.read(temp)) != -1) {
				out.write(temp, 0, size);
			}
			bytes = out.toByteArray();
		} catch (FileNotFoundException e) {
			logger.info("类:FileUtil,方法:fileToBytes," + "信息:"
				+ file + " 文件未找到，原因" + e.getMessage());
		} catch (IOException e) {
			logger.info("类:FileUtil,方法:fileToBytes," + "信息:"
				+ file + " 文件读取失败，原因" + e.getMessage());
		}
		return bytes;
	}
	
	
	public static int getPercent(float h,float w){
		int p = 0;
		float p2 = 0.0f;
		p2 = 530/w*100;
		p = Math.round(p2);
		return p;
	}
	 /** 
     * Moving a File to Another Directory 
     * @param srcFile  eg: c:\windows\abc.txt 
     * @param destPath eg: c:\temp 
     * @return success 
     */ 
    public static boolean move(String srcFile, String destPath){ 
		 // File (or directory) to be moved 
		 File file = new File(srcFile); 
		 // Destination directory 
		 File dir = new File(destPath); 
		 // Move file to new directory 
		 boolean success = file.renameTo(dir); 
		 return success; 
    }
    
    public static final InputStream byte2Input(byte[] buf) {  
        return new ByteArrayInputStream(buf);  
    }  
  
    public static final byte[] input2byte(InputStream inStream) throws IOException {  
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();  
        byte[] buff = new byte[100];  
        int rc = 0;  
        while ((rc = inStream.read(buff, 0, 100)) > 0) {  
            swapStream.write(buff, 0, rc);  
        }  
        byte[] in2b = swapStream.toByteArray();  
        return in2b;  
    }  
    
    public static String getStringFromInputStream(InputStream is) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(
				new BufferedInputStream(new BufferedInputStream(is)), DEFAULT_ENCODING));
		StringBuilder sb = new StringBuilder();
		try {
			String line = "";
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
		} catch (IOException e) {
			logger.warn("IO异常发生",e);
		}
		return sb.toString();
    }
    
   
    
    public static InputStream getImputStream(String xmlData) throws Exception {
		if (xmlData != null && !"".equals(xmlData.trim())) {
			xmlData = xmlData.replaceAll("&amp;amp;", "&amp;");
			ByteArrayInputStream tInputStringStream = new ByteArrayInputStream(xmlData.getBytes(DEFAULT_ENCODING));
			return tInputStringStream;
		}
		return null;
	}
    
   
    
   
}
