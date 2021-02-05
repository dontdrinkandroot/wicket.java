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
package net.dontdrinkandroot.wicket.behavior

import net.dontdrinkandroot.wicket.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
class TitleModifierTest : AbstractWicketTest()
{
    @Test
    fun testStringConstructor()
    {
        val container = WebMarkupContainer("id")
        container.add(TitleModifier("testone"))
        val componentMarkup = ComponentRenderer.renderComponent(container)
        Assertions.assertEquals(
            "<wicket:container wicket:id=\"id\" title=\"testone\"></wicket:container>",
            componentMarkup.toString()
        )
    }

    @Test
    fun testModelConstructor()
    {
        val classModel: IModel<String> = Model.of("testone")
        val container = WebMarkupContainer("id")
        container.add(TitleModifier(classModel))
        var componentMarkup = ComponentRenderer.renderComponent(container)
        Assertions.assertEquals(
            "<wicket:container wicket:id=\"id\" title=\"testone\"></wicket:container>",
            componentMarkup.toString()
        )
        classModel.setObject("testtwo")
        componentMarkup = ComponentRenderer.renderComponent(container)
        Assertions.assertEquals(
            "<wicket:container wicket:id=\"id\" title=\"testtwo\"></wicket:container>",
            componentMarkup.toString()
        )
    }
}