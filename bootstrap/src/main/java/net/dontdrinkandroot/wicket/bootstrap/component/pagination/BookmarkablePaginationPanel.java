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
package net.dontdrinkandroot.wicket.bootstrap.component.pagination;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.PaginationSize;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class BookmarkablePaginationPanel extends PaginationPanel
{
    public BookmarkablePaginationPanel(String id, IPageable pageable)
    {
        super(id, pageable, null);
    }

    public BookmarkablePaginationPanel(String id, IPageable pageable, PaginationSize size)
    {
        super(id, pageable, size);
    }

    @Override
    protected AbstractLink createLink(String id, final IModel<Long> paginablePageModel)
    {
        BookmarkablePageLink<Long> link = new BookmarkablePageLink<Long>(id, Page.class)
        {
            @Override
            public PageParameters getPageParameters()
            {
                PageParameters parameters = new PageParameters(this.getPage().getPageParameters());
                /* Zero based page index */
                parameters.set("page", paginablePageModel.getObject() + 1);
                return parameters;
            }

            @Override
            protected CharSequence getURL()
            {
                PageParameters parameters = this.getPageParameters();

                return this.urlFor(this.getPage().getClass(), parameters);
            }
        };
        link.add(new CssClassAppender(BootstrapCssClass.PAGE_LINK));

        return link;
    }
}
