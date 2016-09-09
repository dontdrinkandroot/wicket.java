/*
 * Copyright (C) 2012-2016 Philip Washington Sorst <philip@sorst.net>
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
package net.dontdrinkandroot.wicket.bootstrap.behavior;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.component.button.IButton;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.AbstractSubmitLink;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class ButtonBehavior extends Behavior implements IButton
{

    private IModel<ButtonStyle> buttonStyleModel = Model.of(ButtonStyle.DEFAULT);

    private IModel<ButtonSize> buttonSizeModel = new Model<ButtonSize>();

    public ButtonBehavior()
    {
        super();
    }

    public ButtonBehavior(ButtonStyle buttonStyle)
    {
        this.buttonStyleModel = Model.of(buttonStyle);
    }

    public ButtonBehavior(ButtonSize buttonSize)
    {
        this.buttonSizeModel = Model.of(buttonSize);
    }

    public ButtonBehavior(ButtonStyle buttonStyle, ButtonSize buttonSize)
    {
        this.buttonStyleModel = Model.of(buttonStyle);
        this.buttonSizeModel = Model.of(buttonSize);
    }

    public ButtonBehavior(IModel<ButtonStyle> buttonStyleModel)
    {
        this.buttonStyleModel = buttonStyleModel;
    }

    public ButtonBehavior(IModel<ButtonStyle> buttonStyleModel, IModel<ButtonSize> buttonSizeModel)
    {
        this.buttonStyleModel = buttonStyleModel;
        this.buttonSizeModel = buttonSizeModel;
    }

    @Override
    public void bind(Component component)
    {
        super.bind(component);

        component.add(new CssClassAppender(BootstrapCssClass.BTN));
        component.add(new CssClassAppender(this.getButtonStyleModel()));
        component.add(new CssClassAppender(this.getButtonSizeModel()));
        component.add(new DisabledCssBehavior());
    }

    @Override
    public ButtonSize getButtonSize()
    {
        return this.getButtonSizeModel().getObject();
    }

    @Override
    public ButtonBehavior setButtonSize(ButtonSize buttonSize)
    {
        this.getButtonSizeModel().setObject(buttonSize);
        return this;
    }

    @Override
    public ButtonStyle getButtonStyle()
    {
        return this.getButtonStyleModel().getObject();
    }

    @Override
    public ButtonBehavior setButtonStyle(ButtonStyle buttonStyle)
    {
        this.getButtonStyleModel().setObject(buttonStyle);
        return this;
    }

    @Override
    public void onComponentTag(Component component, ComponentTag tag)
    {
        super.onComponentTag(component, tag);

        /* Check if it is a button without a type and try to determine it */
        if (tag.getName().equalsIgnoreCase("button")) {
            if (null == tag.getAttribute("type")) {
                if (component instanceof AbstractSubmitLink && !(component instanceof AjaxSubmitLink)) {
                    tag.put("type", "submit");
                } else {
                    tag.put("type", "button");
                }
            }
        }

        /* If this is an input button set the bodyModel as its value attribute */
        if (tag.getName().equalsIgnoreCase("input") && component instanceof AbstractLink) {
            IModel<?> bodyModel = ((AbstractLink) component).getBody();
            if (bodyModel != null && bodyModel.getObject() != null) {
                tag.put("value", component.getDefaultModelObjectAsString(bodyModel.getObject()));
            }
        }
    }

    public IModel<ButtonSize> getButtonSizeModel()
    {
        return this.buttonSizeModel;
    }

    @Override
    public ButtonBehavior setButtonSizeModel(IModel<ButtonSize> buttonSizeModel)
    {
        this.buttonSizeModel = buttonSizeModel;
        return this;
    }

    public IModel<ButtonStyle> getButtonStyleModel()
    {
        return this.buttonStyleModel;
    }

    @Override
    public ButtonBehavior setButtonStyleModel(IModel<ButtonStyle> buttonStyleModel)
    {
        this.buttonStyleModel = buttonStyleModel;
        return this;
    }
}
