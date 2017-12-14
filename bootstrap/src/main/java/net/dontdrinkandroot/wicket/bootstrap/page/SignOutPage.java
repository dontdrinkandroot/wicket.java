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
package net.dontdrinkandroot.wicket.bootstrap.page;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class SignOutPage extends BootstrapPage<Void>
{
    private IModel<String> pageTitleModel;

    public SignOutPage()
    {
        this(null);
    }

    public SignOutPage(PageParameters parameters)
    {
        super(parameters);
        this.getSession().invalidate();
    }

    @Override
    protected void onInitialize()
    {
        this.pageTitleModel = this.createPageTitleModel();

        super.onInitialize();

        this.add(new Label("message", this.createPageTitleModel()));
    }

    @Override
    protected Component createPageTitle(String id)
    {
        return new Label(id, this.pageTitleModel);
    }

    protected IModel<String> createPageTitleModel()
    {
        return new ResourceModel("logout.success", Model.of("You have been signed out successfully"));
    }
}
