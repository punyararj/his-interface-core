package com.healthcare.data.server.protobuf.rpc;

public interface RPCCallRequestHandler {
	void onClientRequested(RPCSSLConnector connector, RPCRawMessage message);
}
