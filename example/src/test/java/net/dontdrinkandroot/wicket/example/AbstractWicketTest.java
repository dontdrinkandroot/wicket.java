/*
 * Copyright (C) 2012-2017 Philip Washington Sorst <philip@sorst.net>
 * and individual contributors as indicated
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.dontdrinkandroot.wicket.example;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.util.tester.WicketTester;
import org.apache.wicket.util.visit.IVisitor;
import org.apache.wicket.util.visit.Visits;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public abstract class AbstractWicketTest
{
    @Autowired
    protected ExampleWebApplication wicketApplication;

    protected WicketTester tester;

    @Before
    public void setUp()
    {
        this.tester = new WicketTester(this.wicketApplication);
    }

    @After
    public void tearDown()
    {
        this.tester.destroy();
    }

    protected void assertStateless(MarkupContainer component)
    {
        Visits.visitChildren(component, (IVisitor<Component, Void>) (component1, visit) -> {
            if (!component1.isStateless()) {
                Assert.assertTrue(
                        String.format(
                                "Component '%s' is not stateless. Type: %s, Path: %s",
                                component1.getMarkupId(),
                                component1.getClass().getCanonicalName(),
                                component1.getPath()
                        ),
                        component1.isStateless()
                );
            }
        });
    }
}
