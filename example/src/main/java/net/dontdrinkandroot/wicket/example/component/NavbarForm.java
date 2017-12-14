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
package net.dontdrinkandroot.wicket.example.component;

import net.dontdrinkandroot.wicket.bootstrap.component.button.AjaxSubmitButton;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText;
import org.apache.wicket.markup.html.panel.IMarkupSourcingStrategy;
import org.apache.wicket.markup.html.panel.PanelMarkupSourcingStrategy;
import org.apache.wicket.model.Model;

public class NavbarForm extends net.dontdrinkandroot.wicket.bootstrap.component.navbar.NavbarForm<Void>
{
    public NavbarForm(String id)
    {
        super(id);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        FormGroupInputText searchGroup = new FormGroupInputText("searchGroup", Model.of("Search"), new Model<String>());
        searchGroup.setLabelScreenReaderOnly(true);
        this.add(searchGroup);
        this.add(new AjaxSubmitButton("submit").setBody(Model.of("Search")));
    }

    @Override
    protected IMarkupSourcingStrategy newMarkupSourcingStrategy()
    {
        return new PanelMarkupSourcingStrategy(false);
    }
}
