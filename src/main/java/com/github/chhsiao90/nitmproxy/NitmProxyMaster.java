package com.github.chhsiao90.nitmproxy;

import com.github.chhsiao90.nitmproxy.channel.BackendChannelBootstrap;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

public class NitmProxyMaster {
    private NitmProxyConfig config;
    private HandlerProvider handlerProvider;
    private BackendChannelBootstrap backendChannelBootstrap;

    public NitmProxyMaster(NitmProxyConfig config,
                           HandlerProvider handlerProvider,
                           BackendChannelBootstrap backendChannelBootstrap) {
        this.config = config;
        this.handlerProvider = handlerProvider;
        this.backendChannelBootstrap = backendChannelBootstrap;
    }

    public NitmProxyConfig config() {
        return config;
    }

    public HandlerProvider provider() {
        return handlerProvider;
    }

    public ChannelFuture connect(ChannelHandlerContext fromCtx, ConnectionContext connectionContext,
                                 ChannelHandler handler) {
        return backendChannelBootstrap.connect(fromCtx, this, connectionContext, handler);
    }
}
