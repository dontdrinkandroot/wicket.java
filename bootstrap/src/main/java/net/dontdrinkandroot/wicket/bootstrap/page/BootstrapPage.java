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
package net.dontdrinkandroot.wicket.bootstrap.page;

import net.dontdrinkandroot.wicket.bootstrap.headeritem.BootstrapCssHeaderItem;
import net.dontdrinkandroot.wicket.bootstrap.headeritem.BootstrapJsHeaderItem;
import net.dontdrinkandroot.wicket.model.ConcatenatingStringModel;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.GenericWebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public abstract class BootstrapPage<T> extends GenericWebPage<T>
{
    protected IModel<String> pageHeadingModel;

    protected IModel<String> pageTitleModel;

    public BootstrapPage()
    {
        super();
    }

    public BootstrapPage(PageParameters parameters)
    {
        super(parameters);
    }

    public BootstrapPage(IModel<T> model)
    {
        super(model);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.pageHeadingModel = this.createPageHeadingModel();
        this.pageTitleModel = this.createPageTitleModel();
        this.add(new Label("pageTitle", this.pageTitleModel));
    }

    @Override
    public void renderHead(IHeaderResponse response)
    {
        super.renderHead(response);

        response.render(this.getBootstrapJavaScriptHeaderItem());
        response.render(this.getBootstrapCssHeaderItem());
    }

    protected BootstrapJsHeaderItem getBootstrapJavaScriptHeaderItem()
    {
        return new BootstrapJsHeaderItem(false);
    }

    protected BootstrapCssHeaderItem getBootstrapCssHeaderItem()
    {
        return new BootstrapCssHeaderItem();
    }

    protected IModel<String> createPageTitlePrefixModel()
    {
        return new Model<String>();
    }

    protected IModel<String> createPageTitleModel()
    {
        return new ConcatenatingStringModel(this.createPageTitlePrefixModel(), " - ", this.pageHeadingModel);
    }

    protected abstract IModel<String> createPageHeadingModel();
}
