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
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class PaginationPanel extends Panel
{
    private final IPageable pageable;

    private RepeatingView pageItemView;

    private int viewSize = 5;

    public PaginationPanel(String id, final IPageable pageable)
    {
        this(id, pageable, null);
    }

    public PaginationPanel(String id, IPageable pageable, PaginationSize size)
    {
        super(id);

        this.pageable = pageable;
        if (size != null) {
            this.add(new CssClassAppender(size));
        }
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();
        this.add(new CssClassAppender(BootstrapCssClass.PAGINATION));

        Component firstItem = this.createFirstPageItem("firstItem");
        this.add(firstItem);

        Component prevItem = this.createPrevPageItem("prevItem");
        this.add(prevItem);

        Component nextItem = this.createNextPageItem("nextItem");
        this.add(nextItem);

        Component lastItem = this.createLastPageItem("lastItem");
        this.add(lastItem);

        this.pageItemView = new RepeatingView("pageItem");
        this.add(this.pageItemView);
    }

    @Override
    protected void onBeforeRender()
    {
        super.onBeforeRender();

        this.pageItemView.removeAll();

        long curPage = this.pageable.getCurrentPage();
        long pageCount = this.pageable.getPageCount();

        long desiredStart = curPage - (this.getViewSize() / 2);
        long desiredEnd = curPage + (this.getViewSize() / 2);

        if (desiredStart < 0) {
            long offset = 0 - desiredStart;
            desiredStart = desiredStart + offset;
            desiredEnd = desiredEnd + offset;
        }

        if (desiredEnd > (pageCount - 1)) {
            long offset = desiredEnd - (pageCount - 1);
            desiredStart = desiredStart - offset;
            desiredEnd = desiredEnd - offset;
        }

        long displayStart = Math.max(0, desiredStart);
        long displayEnd = Math.min(pageCount - 1, desiredEnd);

        for (long page = displayStart; page <= displayEnd; page++) {
            this.pageItemView.add(this.createPageItem(this.pageItemView.newChildId(), page));
        }
    }

    public void setViewSize(int viewSize)
    {
        this.viewSize = viewSize;
    }

    public int getViewSize()
    {
        return this.viewSize;
    }

    public IPageable getPageable()
    {
        return this.pageable;
    }

    protected AbstractPageLinkItem createFirstPageItem(String id)
    {
        return new FirstPageLinkItem(id, this.pageable)
        {
            @Override
            protected AbstractLink createLink(String id, IModel<Long> paginablePageModel)
            {
                return PaginationPanel.this.createLink(id, paginablePageModel);
            }
        };
    }

    protected AbstractPageLinkItem createPrevPageItem(String id)
    {
        return new PrevPageLinkItem(id, this.pageable)
        {
            @Override
            protected AbstractLink createLink(String id, IModel<Long> paginablePageModel)
            {
                return PaginationPanel.this.createLink(id, paginablePageModel);
            }
        };
    }

    protected AbstractPageLinkItem createNextPageItem(String id)
    {
        return new NextPageLinkItem(id, this.pageable)
        {
            @Override
            protected AbstractLink createLink(String id, IModel<Long> paginablePageModel)
            {
                return PaginationPanel.this.createLink(id, paginablePageModel);
            }
        };
    }

    protected AbstractPageLinkItem createLastPageItem(String id)
    {
        return new LastPageLinkItem(id, this.pageable)
        {
            @Override
            protected AbstractLink createLink(String id, IModel<Long> paginablePageModel)
            {
                return PaginationPanel.this.createLink(id, paginablePageModel);
            }
        };
    }

    protected AbstractPageLinkItem createPageItem(String id, long page)
    {
        return new PageLinkItem(id, this.pageable, page)
        {
            @Override
            protected AbstractLink createLink(String id, IModel<Long> paginablePageModel)
            {
                return PaginationPanel.this.createLink(id, paginablePageModel);
            }
        };
    }

    protected AbstractLink createLink(String id, IModel<Long> paginablePageModel)
    {
        Link<Long> link = new Link<Long>(id, paginablePageModel)
        {
            @Override
            public void onClick()
            {
                PaginationPanel.this.pageable.setCurrentPage(this.getModelObject());
            }
        };
        link.add(new CssClassAppender(BootstrapCssClass.PAGE_LINK));

        return link;
    }
}
