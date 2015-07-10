package com.oneobject.spring.extension;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by saberseddik on 15-07-10.
 */

public class ParentBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    protected Class getBeanClass(Element element) {
        return Parent.class;
    }

    protected void doParse(Element element, BeanDefinitionBuilder bean) {

        String firstName = element.getAttribute("firstName");
        bean.addPropertyValue("firstName", firstName);

        String lastName = element.getAttribute("lastName");
        bean.addPropertyValue("lastName", lastName);

        List<Element> childElements = DomUtils.getChildElementsByTagName(element, "child");
        Map<String, Child> childMaps = new HashMap<>();
        for (Element childElement : childElements) {
            Child child = processChildElement(childElement);
            childMaps.put(child.getFirstName(), child);
        }
        bean.addPropertyValue("childs", childMaps);
    }

    private Child processChildElement(Element element) {
        final Child child = new Child();
        String firstName = element.getAttribute("firstName");
        child.setFirstName(firstName);
        return child;
    }

}
