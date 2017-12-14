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

import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.FontAwesomeIcon;
import net.dontdrinkandroot.wicket.bootstrap.css.FontAwesomeIconClass;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class PrevPageLinkItem extends AbstractPageLinkItem
{
    public PrevPageLinkItem(String id, IPageable pageable)
    {
        super(id, pageable);
    }

    @Override
    protected IModel<String> createLabel()
    {
        return new Model<String>("");
    }

    @Override
    protected void onLinkCreated(AbstractLink link)
    {
        super.onLinkCreated(link);

        link.add(new AttributeAppender("rel", "prev"));
        link.add(new IconBehavior(new FontAwesomeIcon(FontAwesomeIconClass.ANGLE_LEFT)));
    }

    @Override
    public boolean isEnabled()
    {
        return this.getPageable().getCurrentPage() != 0;
    }

    @Override
    protected void setPaginablePage()
    {
        this.getPageable().setCurrentPage(Math.max(0, this.getPageable().getCurrentPage() - 1));
    }

    @Override
    protected IModel<Long> getPaginablePageModel()
    {
        return new AbstractReadOnlyModel<Long>()
        {

            @Override
            public Long getObject()
            {
                return PrevPageLinkItem.this.getPageable().getCurrentPage() - 1;
            }
        };
    }
}
