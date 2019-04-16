package com.gk.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FileUtil {
	
	/**
	 * 向文件写入内容，一条记录写一行
	 * @param file
	 * @param list
	 * @throws IOException
	 */
	public static void fileWrite(File file,List<String> list) throws IOException {
		FileUtils.writeLines(file, list,"\r\n");
	}

}
