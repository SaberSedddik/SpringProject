package com.oneobject.spring.extension;


import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by saberseddik on 15-07-10.
 */
public class MyExtensionNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("parent", new ParentBeanDefinitionParser());
    }

}
