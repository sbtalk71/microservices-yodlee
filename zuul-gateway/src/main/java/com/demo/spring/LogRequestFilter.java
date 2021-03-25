package com.demo.spring;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class LogRequestFilter extends ZuulFilter{

	private static Logger log=LoggerFactory.getLogger(LogRequestFilter.class);
	
	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		RequestContext ctx=RequestContext.getCurrentContext();
		HttpServletRequest request=ctx.getRequest();
		log.info("Request Received from : "+request.getMethod()+":"+request.getRequestURL().toString());
		return null;
	}

	@Override
	public String filterType() {
		//pre,post,error,route
		return "pre";
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

}
