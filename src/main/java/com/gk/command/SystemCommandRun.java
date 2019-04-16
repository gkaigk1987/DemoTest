package com.gk.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemCommandRun {
	
	private static Logger logger = LoggerFactory.getLogger(SystemCommandRun.class);
	
	/**
	 * 	执行系统命令
	 * @param command
	 * @return
	 * @throws InterruptedException
	 */
	public void exec(String command) throws InterruptedException {
		Process pro = null;
		Runtime runTime = Runtime.getRuntime();
		if(runTime == null) {
			logger.error("获取Runtime出错！");
		}
		try {
			pro = runTime.exec(command);
			BufferedReader input = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			String line = null;
			while ((line = input.readLine()) != null) {
				logger.info(line);
			}
			if (pro.waitFor() != 0) {
                if (pro.exitValue() == 1) {
                	//p.exitValue()==0表示正常结束，1：非正常结束  
                	logger.error("命令执行非正常结束!");
                }
            }
		} catch (IOException ex) {
			logger.error("IO异常，执行系统命令出错！");
			ex.printStackTrace();
		} 
		return;
	} 
	
	public static void main(String[] args) throws InterruptedException {
		for(int i = 8000; i < 8010; i++) {
			SystemCommandRun run = new SystemCommandRun();
			String command = "java -jar E:/MyGithub/MySpringCloud/Cloud-Service2/target/Cloud-Service2-0.0.1-SNAPSHOT.jar --server.port=" + i;
			run.exec(command);
			logger.info("========================{}端口启动成功===============================",i);
			try {
				Thread.sleep(5 * 1000);
			} catch (Exception e) {
				// ignore
			}
		}
	}

}
