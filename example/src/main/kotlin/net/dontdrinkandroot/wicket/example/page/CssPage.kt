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
package net.dontdrinkandroot.wicket.example.page

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.behavior.TitleModifier
import net.dontdrinkandroot.wicket.bootstrap.css.*
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.Model

class CssPage : DecoratorPage<Void?>()
{

    override fun createPageHeadingModel() = "Css".model()

    override fun onInitialize()
    {
        super.onInitialize()
        val lead = Label("lead", Model.of("This is a leaded paragraph"))
        lead.add(CssClassAppender(BootstrapCssClass.LEAD))
        this.add(lead)
        val textAlignmentView = RepeatingView("alignment")
        this.add(textAlignmentView)
        for (alignment in TextAlignment.values())
        {
            val label = Label(textAlignmentView.newChildId(), Model.of(alignment.name.toLowerCase()))
            label.add(CssClassAppender(alignment))
            textAlignmentView.add(label)
        }
        val textTransformationView = RepeatingView("transform")
        this.add(textTransformationView)
        for (transformation in TextTransformation.values())
        {
            val label = Label(textTransformationView.newChildId(), Model.of(transformation.name.toLowerCase()))
            label.add(CssClassAppender(transformation))
            textTransformationView.add(label)
        }
        val initialism = Label("initialism", Model.of("CSS"))
        initialism.add(CssClassAppender(BootstrapCssClass.INITIALISM))
        initialism.add(TitleModifier(Model.of("Cascading Style Sheet")))
        this.add(initialism)
        val blockquoteReverse = WebMarkupContainer("blockQuoteReverse")
        blockquoteReverse.add(CssClassAppender(BootstrapCssClass.BLOCKQUOTE_REVERSE))
        this.add(blockquoteReverse)
        val contextualColorView = RepeatingView("contextualColor")
        this.add(contextualColorView)
        for (textStyle in TextColor.values())
        {
            val label = Label(contextualColorView.newChildId(), Model.of(textStyle.name.toLowerCase()))
            label.add(CssClassAppender(textStyle))
            contextualColorView.add(label)
        }
        val contextualBackgroundView = RepeatingView("contextualBackground")
        this.add(contextualBackgroundView)
        for (textStyle in BackgroundColor.values())
        {
            val label = Label(contextualBackgroundView.newChildId(), Model.of(textStyle.name.toLowerCase()))
            label.add(CssClassAppender(textStyle))
            contextualBackgroundView.add(label)
        }
    }
}