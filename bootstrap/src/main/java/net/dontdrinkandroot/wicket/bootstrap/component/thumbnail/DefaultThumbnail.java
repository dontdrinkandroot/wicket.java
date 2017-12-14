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
package net.dontdrinkandroot.wicket.bootstrap.component.thumbnail;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;


public abstract class DefaultThumbnail<T> extends GenericPanel<T> {

    public DefaultThumbnail(String id, IModel<T> model)
    {

        super(id, model);
    }

    @Override
    protected void onInitialize()
    {

        super.onInitialize();

        MarkupContainer link = this.createLink("link", this.getModel());
        link.add(new CssClassAppender(BootstrapCssClass.THUMBNAIL));
        this.add(link);

        Component image = this.createImage("image", this.getModel());
        link.add(image);
    }

    protected abstract MarkupContainer createLink(String id, IModel<T> model);

    protected abstract Component createImage(String id, IModel<T> model);

}
