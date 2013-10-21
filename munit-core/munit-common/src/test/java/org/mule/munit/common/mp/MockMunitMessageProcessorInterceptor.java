/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.munit.common.mp;

import net.sf.cglib.proxy.MethodProxy;

import org.mule.api.MuleContext;

/**
 * <p>
 * A class for test only. This just overrides protected methods to simplify class testing
 * </p>
 *
 * @author Mulesoft Inc.
 * @since 3.3.2
 */
public class MockMunitMessageProcessorInterceptor extends MunitMessageProcessorInterceptor
{

    MockedMessageProcessorManager manager;
    boolean mockProcess;
    MuleContext context;

    public MockMunitMessageProcessorInterceptor(String name, MockedMessageProcessorManager manager)
    {
        super(name);
        this.manager = manager;
    }

    @Override
    public Object process(Object obj, Object[] args, MethodProxy proxy) throws Throwable
    {
        if (mockProcess)
        {
            return obj;
        }
        return super.process(obj, args, proxy);
    }

    @Override
    protected MockedMessageProcessorManager getMockedMessageProcessorManager()
    {
        return manager;
    }

    @Override
    public MuleContext getMuleContext()
    {
        return context;
    }

    public void setMockProcess(boolean mockProcess)
    {
        this.mockProcess = mockProcess;
    }

    public void setContext(MuleContext context)
    {
        this.context = context;
    }
}
