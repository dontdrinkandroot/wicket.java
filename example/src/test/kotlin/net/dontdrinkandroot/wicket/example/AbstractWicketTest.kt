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
package net.dontdrinkandroot.wicket.example

import org.apache.wicket.Component
import org.apache.wicket.MarkupContainer
import org.apache.wicket.util.tester.WicketTester
import org.apache.wicket.util.visit.IVisit
import org.apache.wicket.util.visit.IVisitor
import org.apache.wicket.util.visit.Visits
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@ActiveProfiles("test")
@SpringBootTest(classes = [Application::class])
abstract class AbstractWicketTest
{
    @Autowired
    protected var wicketApplication: ExampleWebApplication? = null

    protected lateinit var tester: WicketTester

    @BeforeEach
    fun setUp()
    {
        tester = WicketTester(wicketApplication)
    }

    @AfterEach
    fun tearDown()
    {
        tester.destroy()
    }

    protected fun assertStateless(component: MarkupContainer?)
    {
        Visits.visitChildren(component, IVisitor { component1: Component, visit: IVisit<Void?>? ->
            if (!component1.isStateless)
            {
                Assertions.assertTrue(
                    component1.isStateless, String.format(
                        "Component '%s' is not stateless. Type: %s, Path: %s",
                        component1.markupId,
                        component1.javaClass.canonicalName,
                        component1.path
                    )
                )
            }
        } as IVisitor<Component, Void?>)
    }
}