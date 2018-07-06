package com.eric.protocal;

/**
 *
 */
public interface Protocol {

    public void export(String interfaceName, Class<?> impl) throws Exception;
}
