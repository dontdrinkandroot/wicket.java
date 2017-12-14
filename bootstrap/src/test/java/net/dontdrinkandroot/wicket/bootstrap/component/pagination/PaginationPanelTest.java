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

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class PaginationPanelTest extends AbstractWicketTest
{
    @Test
    public void testDefaultMarkup()
    {
        IPageable pageable = new IPageable()
        {
            private long page = 0;

            private long pageCount = 20;

            @Override
            public void setCurrentPage(long page)
            {
                this.page = page;
            }

            @Override
            public long getPageCount()
            {
                return this.pageCount;
            }

            @Override
            public long getCurrentPage()
            {
                return this.page;
            }
        };
        PaginationPanel component = new PaginationPanel("id", pageable);
        String componentMarkup = ComponentRenderer.renderComponent(component).toString();

        TagTester componentTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id");
        Assert.assertTrue(componentTester.getAttributeContains("class", "pagination"));

        TagTester firstItemTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "firstItem");
        Assert.assertTrue(firstItemTester.getAttributeContains("class", "disabled"));

        TagTester prevItemTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "prevItem");
        Assert.assertTrue(prevItemTester.getAttributeContains("class", "disabled"));

        List<TagTester> pageTesters = TagTester.createTagsByAttribute(componentMarkup, "wicket:id", "pageItem", false);
        Assert.assertEquals(component.getViewSize(), pageTesters.size());

        TagTester currentPageTester = pageTesters.get(0);
        Assert.assertTrue(currentPageTester.getAttributeContains("class", "active"));

        TagTester nextItemTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "nextItem");

        TagTester lastItemTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "lastItem");
    }
}
