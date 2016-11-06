package com.healthcare.data.server;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;

public class ServiceMain implements Daemon {

	@Override
	public void init(DaemonContext context) throws DaemonInitException,
			Exception {

		String[] args = context.getArguments();
		
	}

	@Override
	public void start() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
