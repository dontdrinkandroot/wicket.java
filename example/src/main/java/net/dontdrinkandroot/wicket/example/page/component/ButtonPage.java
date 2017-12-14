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
package net.dontdrinkandroot.wicket.example.page.component;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.button.ButtonGroupChoice;
import net.dontdrinkandroot.wicket.bootstrap.component.button.DropdownButton;
import net.dontdrinkandroot.wicket.bootstrap.component.button.SplitDropdownButton;
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.Arrays;
import java.util.List;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ButtonPage extends ComponentPage
{
    public ButtonPage(PageParameters parameters)
    {
        super(parameters);
    }

    @Override
    protected IModel<String> createPageHeadingModel()
    {
        return Model.of("Buttons");
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        RepeatingView styleView = new RepeatingView("buttonStyle");
        this.add(styleView);
        for (ButtonStyle style : ButtonStyle.values()) {
            Label button = new Label(styleView.newChildId(), Model.of(style.name()));
            button.add(new ButtonBehavior(Model.of(style)));
            styleView.add(button);
        }

        RepeatingView sizeView = new RepeatingView("buttonSize");
        this.add(sizeView);
        for (ButtonSize size : ButtonSize.values()) {
            Label button = new Label(sizeView.newChildId(), Model.of(size.name()));
            button.add(new ButtonBehavior().setButtonSize(size));
            sizeView.add(button);
        }

        DropdownButton<Void> dropdownButton = new DropdownButton<Void>("dropdownButton", null, Model.of("My Label"))
        {
            @Override
            protected void populateItems(RepeatingView itemView)
            {
                ButtonPage.this.populateDropdownItems(itemView);
            }
        };
        this.add(dropdownButton);

        DropdownButton<Void> dropupButton = new DropdownButton<Void>("dropupButton", null, Model.of("DropUp"))
        {
            @Override
            protected void populateItems(RepeatingView itemView)
            {
                ButtonPage.this.populateDropdownItems(itemView);
            }
        };
        dropupButton.add(new CssClassAppender(BootstrapCssClass.DROPUP));
        this.add(dropupButton);

        SplitDropdownButton<Void> splitDropdownButton = new SplitDropdownButton<Void>("splitDropdownButton")
        {
            @Override
            protected Component createAction(String id)
            {
                return new Label(id, "Action");
            }

            @Override
            protected void populateItems(RepeatingView itemView)
            {
                ButtonPage.this.populateDropdownItems(itemView);
            }
        };
        this.add(splitDropdownButton);

        List<String> choices = Arrays.asList("Red", "Green", "Blue");
        ButtonGroupChoice<String> buttonGroupChoice =
                new ButtonGroupChoice<>("buttonGroupChoice", Model.of(choices.iterator().next()), choices);
        this.add(buttonGroupChoice);
    }

    protected void populateDropdownItems(RepeatingView itemView)
    {
        itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("This is a link"), ButtonPage.class));
    }
}
