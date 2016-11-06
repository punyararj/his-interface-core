package com.healthcare.data.server.utils;

import java.io.File;

public class ServerUtils {

	public static File getRunnigJarFile(){
		return new File(ServerUtils.class.getProtectionDomain().getCodeSource().getLocation().getPath());
	}
	
}
