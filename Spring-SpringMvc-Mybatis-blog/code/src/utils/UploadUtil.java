package utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;

public class UploadUtil {
	public static String uploadImg(String filePath, InputStream in) throws IOException {
		//��ȡtomcat �ĸ�Ŀ¼��webapps �µ�·������editormd.root ��web.xml ������
		String tomcatRootPath = System.getProperty("editormd.root") + "..";
		String resultPath = tomcatRootPath + filePath;
		
		createFile(resultPath);
		File realFile = new File(resultPath);
		FileUtils.copyInputStreamToFile(in, realFile);
		return resultPath;
	}

	/*
	 * �����ļ��� ����ļ��в����ڽ�������
	 * */
	public static File createFile(String resultPath) {
		File file = new File(resultPath);
		if(file.exists())
			return null;
		if(resultPath.endsWith(File.separator))
			return null;
		if(!file.getParentFile().exists()) {
			if(!file.getParentFile().mkdirs())
				return null;
		}
		try {
			if(file.createNewFile())
				return file;
			return null;
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
