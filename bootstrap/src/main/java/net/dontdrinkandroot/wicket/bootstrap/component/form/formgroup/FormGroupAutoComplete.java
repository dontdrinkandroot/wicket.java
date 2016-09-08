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
package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.attributes.ThrottlingSettings;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.time.Duration;

import java.util.List;


public abstract class FormGroupAutoComplete extends FormGroupFormComponent<String, String, TextField<String>>
{

    private WebMarkupContainer dropDownMenu;

    private ListView<String> suggestionView;

    public FormGroupAutoComplete(String id, IModel<String> labelModel, IModel<String> model)
    {
        super(id, labelModel, model);
    }

    @Override
    protected void createComponents()
    {
        super.createComponents();

        this.dropDownMenu = new WebMarkupContainer("dropDownMenu");
        this.dropDownMenu.setOutputMarkupId(true);
        this.add(this.dropDownMenu);

        this.suggestionView = new ListView<String>("suggestionItem", new AbstractReadOnlyModel<List<String>>()
        {

            @Override
            public List<String> getObject()
            {
                return FormGroupAutoComplete.this.getChoices(FormGroupAutoComplete.this.getModelObject());
            }
        })
        {

            @Override
            protected void populateItem(ListItem<String> item)
            {
                AjaxLink<String> link = new AjaxLink<String>("link", item.getModel())
                {

                    @Override
                    public void onClick(AjaxRequestTarget target)
                    {
                        FormGroupAutoComplete.this.getModel().setObject(this.getModelObject());
                        target.add(FormGroupAutoComplete.this.formComponent);
                        target.add(FormGroupAutoComplete.this.dropDownMenu);
                    }
                };
                link.setBody(link.getModel());
                item.add(link);
            }
        };
        this.dropDownMenu.add(this.suggestionView);
    }

    @Override
    protected void addComponents()
    {
        super.addComponents();

        this.container.add(this.dropDownMenu);
        this.dropDownMenu.add(this.suggestionView);
    }

    @Override
    protected void addBehaviors()
    {
        super.addBehaviors();

        this.add(new CssClassAppender(BootstrapCssClass.DROPDOWN));
        this.add(new CssClassAppender("autocomplete"));
        this.formComponent.add(new AjaxFormComponentUpdatingBehavior("input")
        {

            @Override
            protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
            {
                super.updateAjaxAttributes(attributes);
                attributes.setThrottlingSettings(new ThrottlingSettings(Duration.milliseconds(250)));
            }

            @Override
            protected void onUpdate(AjaxRequestTarget target)
            {
                target.add(FormGroupAutoComplete.this.dropDownMenu);
            }
        });
    }

    @Override
    protected TextField<String> createFormComponent(String id)
    {
        TextField<String> textField = new TextField<String>(id, this.getModel());
        return textField;
    }

    protected abstract List<String> getChoices(String input);

}
