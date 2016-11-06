package com.healthcare.data.server.listener;

import com.healthcare.data.server.protobuf.rpc.RPCClientThread;

public interface ClientExitListener {

	public void onClientExit(RPCClientThread clientThread);
	
}
