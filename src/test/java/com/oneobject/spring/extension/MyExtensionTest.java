package com.oneobject.spring.extension;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertThat;

/**
 * Created by saberseddik on 15-07-09.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/oneobject/spring/extension/myextension-test-context.xml")
public class MyExtensionTest {

    @Autowired
    Parent parent;

    @Test
    public void testBeanCreationAsExpected() {
        Child expectedMayssa = new Child();
        expectedMayssa.setFirstName("Mayssa");
        Child expectedEya = new Child();
        expectedEya.setFirstName("Eya");

        assertThat(parent.getFirstName(), equalTo("Saber"));
        assertThat(parent.getLastName(), equalTo("Seddik"));
        assertThat(parent.getChilds().size(),equalTo(2));
        assertThat(parent.getChilds(),hasEntry("Mayssa", expectedMayssa));
        assertThat(parent.getChilds(),hasEntry("Eya",expectedEya));
    }
}
