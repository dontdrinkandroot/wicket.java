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
package net.dontdrinkandroot.wicket.markup.html.link;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class AjaxBookmarkablePageLink<T> extends BookmarkablePageLink<T>
{
    public <C extends Page> AjaxBookmarkablePageLink(String id, Class<C> pageClass)
    {
        super(id, pageClass);
    }

    public <C extends Page> AjaxBookmarkablePageLink(String id, Class<C> pageClass, PageParameters parameters)
    {
        super(id, pageClass, parameters);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(new AjaxEventBehavior("click")
        {
            @Override
            protected void onEvent(AjaxRequestTarget target)
            {
                AjaxBookmarkablePageLink.this.onClick(target);
            }

            @Override
            protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
            {
                super.updateAjaxAttributes(attributes);

                attributes.setPreventDefault(true);
                AjaxBookmarkablePageLink.this.updateAjaxAttributes(attributes);
            }
        });
    }

    protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
    {
        /* Hook */
    }

    protected void onClick(AjaxRequestTarget target)
    {
        /* Hook */
    }
}
