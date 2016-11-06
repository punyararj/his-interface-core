package com.healthcare.data.server.listener;

import javax.net.ssl.SSLSocket;

public interface ClientListener {

	public void onClientRequest(SSLSocket socket);
	
}
