package com.jeesoft.security;

import java.lang.reflect.Method;
import java.security.Principal;

import javax.ws.rs.core.Response;

import org.apache.cxf.common.util.ClassHelper;
import org.apache.cxf.jaxrs.JAXRSInvoker;
import org.apache.cxf.jaxrs.impl.SecurityContextImpl;
import org.apache.cxf.jaxrs.model.OperationResourceInfo;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.MessageContentsList;

public class CustomJAXRSInvoker extends JAXRSInvoker {

	@Override
	public Object invoke(Exchange exchange, Object requestParams,
			Object resourceObject) {

		OperationResourceInfo ori = exchange.get(OperationResourceInfo.class);
		Method m = ori.getMethodToInvoke();
		Class<?> realClass = ClassHelper.getRealClass(resourceObject);

		Principal p = new SecurityContextImpl(exchange.getInMessage())
				.getUserPrincipal();
		
		
		/*return new MessageContentsList(Response.status(
				Response.Status.FORBIDDEN).build());*/

		return super.invoke(exchange, requestParams, resourceObject);
	}
}
