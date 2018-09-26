package com.readboy.ssm.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import org.apache.tools.ant.BuildException;  
import org.apache.tools.ant.Project;  
import org.apache.tools.ant.taskdefs.Expand;  
import org.apache.tools.ant.taskdefs.Zip;  
import org.apache.tools.ant.types.FileSet;  

//有关文件的操作类写在这里

public class Zipper {  
    public final static String encoding = "UTF-8";  
    // 压缩  
    public static void zip(String srcPathname, String zipFilepath)  
            throws BuildException, RuntimeException {  
        File file = new File(srcPathname);  
        if (!file.exists())  
            throw new RuntimeException("source file or directory "  
                    + srcPathname + " does not exist.");  
  
        Project proj = new Project();  
        FileSet fileSet = new FileSet();  
        fileSet.setProject(proj);  
        // 判断是目录还是文件  
        if (file.isDirectory()) {  
            fileSet.setDir(file);  
            // ant中include/exclude规则在此都可以使用  
            // 比如:  
            // fileSet.setExcludes("**/*.txt");  
            // fileSet.setIncludes("**/*.xls");  
        } else {  
            fileSet.setFile(file);  
        }  
  
        Zip zip = new Zip();  
        zip.setProject(proj);  
        zip.setDestFile(new File(zipFilepath));  
        zip.addFileset(fileSet);  
        zip.setEncoding(encoding);
        zip.execute();  
    }  
  
    // 解压缩  
    public static void unzip(String zipFilepath, String destDir)  
            throws BuildException, RuntimeException {  
        if (!new File(zipFilepath).exists())
            throw new RuntimeException("zip file " + zipFilepath  
                    + " does not exist.");
   //     Project proj = new Project();  
        Expand expand = new Expand();  
     //   expand.setProject(proj);  
        expand.setTaskType("unzip");  
        expand.setTaskName("unzip");
        expand.setEncoding(encoding);  
        expand.setSrc(new File(zipFilepath));  
        expand.setDest(new File(destDir));  
        expand.execute();
    }  
    
    public static void AnsiToUtf8(File f) throws IOException{
    	String line_separator = System.getProperty("line.separator");
    	FileInputStream fis = new FileInputStream(f);
    	StringBuffer content = new StringBuffer();
    	//DataInputStream in = new DataInputStream(fis);
    	BufferedReader d = new BufferedReader(new InputStreamReader(fis, "GBK"));// , "UTF-8"  
    	String line = null;
    	while ((line = d.readLine()) != null)
    		content.append(line + line_separator);
    	d.close();
    	//in.close();
    	fis.close();
    	OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
    	osw.write(content.toString());
    	osw.close();
    	osw.flush();
    	content = null;
    }
    
    //遍历删除文件夹下所有文件
    public static void deleteAllFile(File file){
    	File files[] = file.listFiles();
    	for(int i = 0; files != null && i < files.length; i++){
    		if(files[i].isDirectory()){
    			deleteAllFile(files[i]);
    		}
    		files[i].delete();
    	}
    }
	public static void insert(String fileName, long pos, String insertContent)
			throws IOException
	{
		RandomAccessFile raf = null;
		File tmp = File.createTempFile("tmp", null);
		FileOutputStream tmpOut = null;
		FileInputStream tmpIn = null;
		tmp.deleteOnExit();
		try {
			raf = new RandomAccessFile(fileName, "rw");
			tmpOut = new FileOutputStream(tmp);
			tmpIn = new FileInputStream(tmp);
			raf.seek(pos);
			byte[] bbuf = new byte[1024];
			int hasRead = 0;
			while ((hasRead = raf.read(bbuf)) > 0) {
				tmpOut.write(bbuf, 0, hasRead);
			}
			raf.seek(pos);
			raf.write(insertContent.getBytes());
			while ((hasRead = tmpIn.read(bbuf)) > 0) {
				raf.write(bbuf, 0, hasRead);
			}
		} finally{
			raf.close();
		}
	}
}  