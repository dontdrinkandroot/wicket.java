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
package net.dontdrinkandroot.wicket.example.page;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.behavior.TitleModifier;
import net.dontdrinkandroot.wicket.bootstrap.css.*;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class CssPage extends DecoratorPage<Void>
{

    @Override
    protected IModel<String> createPageHeadingModel()
    {
        return Model.of("CSS");
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        Label lead = new Label("lead", Model.of("This is a leaded paragraph"));
        lead.add(new CssClassAppender(BootstrapCssClass.LEAD));
        this.add(lead);

        RepeatingView textAlignmentView = new RepeatingView("alignment");
        this.add(textAlignmentView);
        for (TextAlignment alignment : TextAlignment.values()) {
            Label label = new Label(textAlignmentView.newChildId(), Model.of(alignment.name().toLowerCase()));
            label.add(new CssClassAppender(alignment));
            textAlignmentView.add(label);
        }

        RepeatingView textTransformationView = new RepeatingView("transform");
        this.add(textTransformationView);
        for (TextTransformation transformation : TextTransformation.values()) {
            Label label = new Label(textTransformationView.newChildId(), Model.of(transformation.name().toLowerCase()));
            label.add(new CssClassAppender(transformation));
            textTransformationView.add(label);
        }

        Label initialism = new Label("initialism", Model.of("CSS"));
        initialism.add(new CssClassAppender(BootstrapCssClass.INITIALISM));
        initialism.add(new TitleModifier(Model.of("Cascading Style Sheet")));
        this.add(initialism);

        WebMarkupContainer blockquoteReverse = new WebMarkupContainer("blockQuoteReverse");
        blockquoteReverse.add(new CssClassAppender(BootstrapCssClass.BLOCKQUOTE_REVERSE));
        this.add(blockquoteReverse);

        RepeatingView contextualColorView = new RepeatingView("contextualColor");
        this.add(contextualColorView);
        for (TextColor textStyle : TextColor.values()) {
            Label label = new Label(contextualColorView.newChildId(), Model.of(textStyle.name().toLowerCase()));
            label.add(new CssClassAppender(textStyle));
            contextualColorView.add(label);
        }

        RepeatingView contextualBackgroundView = new RepeatingView("contextualBackground");
        this.add(contextualBackgroundView);
        for (BackgroundColor textStyle : BackgroundColor.values()) {
            Label label = new Label(contextualBackgroundView.newChildId(), Model.of(textStyle.name().toLowerCase()));
            label.add(new CssClassAppender(textStyle));
            contextualBackgroundView.add(label);
        }
    }

}
