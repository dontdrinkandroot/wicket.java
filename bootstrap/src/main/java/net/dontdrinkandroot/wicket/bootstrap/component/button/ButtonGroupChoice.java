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
package net.dontdrinkandroot.wicket.bootstrap.component.button;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;

import java.util.List;

/**
 * @param <T> Type of the model object.
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ButtonGroupChoice<T> extends GenericPanel<T> implements IButton
{
    private ButtonBehavior buttonBehavior = new ButtonBehavior();

    public ButtonGroupChoice(String id, IModel<T> model, List<T> choices)
    {
        this(id, model, new ListModel<T>(choices));
    }

    public ButtonGroupChoice(String id, IModel<T> model, IModel<List<T>> choicesModel)
    {
        super(id, model);

        this.setOutputMarkupId(true);
        this.add(new CssClassAppender(BootstrapCssClass.BTN_GROUP));

        final RepeatingView choicesView = new RepeatingView("choice");
        choicesView.setOutputMarkupId(true);
        this.add(choicesView);

        for (final T choice : choicesModel.getObject()) {

            String choiceId = choicesView.newChildId();
            AjaxLink<Void> choiceLink = this.createChoiceButton(choiceId, choice);
            choicesView.add(choiceLink);
        }
    }

    /**
     * Creates the Button for the the given choice.
     */
    protected AjaxLink<Void> createChoiceButton(String id, T choice)
    {
        AjaxLink<Void> choiceLink = new AjaxLink<Void>(id)
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                ButtonGroupChoice.this.onSelectionChanged(choice, target);
            }
        };
        choiceLink.setBody(this.getDisplayModel(choice));
        choiceLink.add(this.buttonBehavior);
        choiceLink.add(new CssClassAppender(new AbstractReadOnlyModel<BootstrapCssClass>()
        {
            @Override
            public BootstrapCssClass getObject()
            {
                if (ButtonGroupChoice.this.getModelObject().equals(choice)) {
                    return BootstrapCssClass.ACTIVE;
                }

                return null;
            }
        }));

        return choiceLink;
    }

    @Override
    public ButtonSize getButtonSize()
    {
        return this.buttonBehavior.getButtonSize();
    }

    @Override
    public ButtonGroupChoice<T> setButtonSize(ButtonSize buttonSize)
    {
        this.buttonBehavior.setButtonSize(buttonSize);
        return this;
    }

    @Override
    public ButtonStyle getButtonStyle()
    {
        return this.buttonBehavior.getButtonStyle();
    }

    @Override
    public ButtonGroupChoice<T> setButtonStyle(ButtonStyle buttonStyle)
    {
        this.buttonBehavior.setButtonStyle(buttonStyle);
        return this;
    }

    @Override
    public ButtonGroupChoice<T> setButtonSizeModel(IModel<ButtonSize> buttonSizeModel)
    {
        this.buttonBehavior.setButtonSizeModel(buttonSizeModel);
        return this;
    }

    @Override
    public ButtonGroupChoice<T> setButtonStyleModel(IModel<ButtonStyle> buttonStyleModel)
    {
        this.buttonBehavior.setButtonStyleModel(buttonStyleModel);
        return this;
    }

    protected void onSelectionChanged(T choice, AjaxRequestTarget target)
    {
        this.setModelObject(choice);
        target.add(ButtonGroupChoice.this);
    }

    protected IModel<String> getDisplayModel(T choice)
    {
        return new Model<String>(choice.toString());
    }
}
