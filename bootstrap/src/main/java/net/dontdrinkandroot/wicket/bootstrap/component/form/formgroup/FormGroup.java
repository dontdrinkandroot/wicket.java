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
package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormContainerSizeBehavior;
import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormLabelSizeBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.model.CssClassToggleModel;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class FormGroup<T> extends GenericPanel<T>
{
    protected IModel<String> labelModel;

    private IModel<Boolean> labelScreenReaderOnlyModel = Model.of(false);

    protected Component label;

    protected WebMarkupContainer container;

    public FormGroup(String id)
    {
        super(id);
    }

    public FormGroup(String id, IModel<String> labelModel)
    {
        super(id);
        this.labelModel = labelModel;
    }

    public FormGroup(String id, IModel<String> labelModel, IModel<T> model)
    {
        super(id, model);
        this.labelModel = labelModel;
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.setOutputMarkupId(true);
        this.add(new CssClassAppender(BootstrapCssClass.FORM_GROUP));

        this.createComponents();
        this.addComponents();
        this.addBehaviors();
    }

    protected void createComponents()
    {
        this.label = this.createLabel("label");
        this.container = this.createContainer("container");
    }

    protected void addComponents()
    {
        this.add(this.label);
        this.add(this.container);
    }

    protected void addBehaviors()
    {
        this.label.add(new FormLabelSizeBehavior());
        this.container.add(new FormContainerSizeBehavior());
    }

    protected Component createLabel(String id)
    {
        Label label = new Label(id, this.labelModel);
        label.add(new CssClassAppender(
                new CssClassToggleModel(this.labelScreenReaderOnlyModel, BootstrapCssClass.SR_ONLY)
        ));
        label.add(new CssClassAppender(BootstrapCssClass.CONTROL_LABEL));
        return label;
    }

    protected WebMarkupContainer createContainer(String id)
    {
        return new WebMarkupContainer(id);
    }

    public FormGroup<T> setLabelScreenReaderOnly(boolean labelScreenReaderOnly)
    {
        this.labelScreenReaderOnlyModel.setObject(labelScreenReaderOnly);
        return this;
    }
}
