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
package net.dontdrinkandroot.wicket.example.page.form;

import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormStyleBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.item.AjaxLinkItem;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeStack;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class FormGroupPage extends FormPage
{
    protected FormStyleBehavior formStyleBehavior = new FormStyleBehavior().setHorizontal(ColumnSizeStack.FORM_DEFAULT);

    public FormGroupPage(PageParameters parameters)
    {
        super(parameters);
    }

    @Override
    protected IModel<String> createPageHeadingModel()
    {
        return Model.of("Form Groups and Form Styles");
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        RepeatingView styleItemView = new RepeatingView("styleItem");
        this.add(styleItemView);

        styleItemView.add(new AjaxLinkItem(styleItemView.newChildId(), Model.of("Default"))
        {
            @Override
            protected void onClick(AjaxRequestTarget target)
            {
                FormGroupPage.this.formStyleBehavior.reset();
                this.setResponsePage(this.getPage());
            }

            @Override
            protected boolean isActive()
            {
                return !FormGroupPage.this.formStyleBehavior.isInline()
                        && !FormGroupPage.this.formStyleBehavior.isHorizontal();
            }
        });
        styleItemView.add(new AjaxLinkItem(styleItemView.newChildId(), Model.of("Horizontal"))
        {

            @Override
            protected void onClick(AjaxRequestTarget target)
            {
                FormGroupPage.this.formStyleBehavior.setHorizontal(ColumnSizeStack.FORM_DEFAULT);
                this.setResponsePage(this.getPage());
            }

            @Override
            protected boolean isActive()
            {
                return FormGroupPage.this.formStyleBehavior.isHorizontal();
            }
        });
        styleItemView.add(new AjaxLinkItem(styleItemView.newChildId(), Model.of("Inline"))
        {

            @Override
            protected void onClick(AjaxRequestTarget target)
            {
                FormGroupPage.this.formStyleBehavior.setInline(true);
                this.setResponsePage(this.getPage());
            }

            @Override
            protected boolean isActive()
            {
                return FormGroupPage.this.formStyleBehavior.isInline();
            }
        });

        Form<Void> form = new Form<>("form");
        form.add(this.formStyleBehavior);
        this.add(form);

        RepeatingView formGroupView = new RepeatingView("formGroup");
        this.populateFormGroups(form, formGroupView);
        form.add(formGroupView);
    }
}
