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
package net.dontdrinkandroot.wicket.extras.page;

import net.dontdrinkandroot.wicket.extras.test.AbstractWicketTest;
import net.dontdrinkandroot.wicket.model.KModel;
import net.dontdrinkandroot.wicket.model.SimpleKModel;
import org.apache.wicket.util.tester.TagTester;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StandardBootstrapPageTest extends AbstractWicketTest
{
    @Test
    public void testDefaultMarkup()
    {
        this.tester.startPage(new StandardBootstrapPage<Void>()
        {
            @Override
            protected KModel<String> createPageHeadingModel() {
                return new SimpleKModel<>("Page Heading");
            }

            @Override
            protected KModel<String> createPageTitlePrefixModel() {
                return new SimpleKModel<>("Page Title Prefix");
            }
        });
        String pageResponse = this.tester.getLastResponseAsString();

        TagTester titleTester = TagTester.createTagByAttribute(pageResponse, "wicket:id", "pageTitle");
        Assertions.assertEquals("Page Title Prefix - Page Heading", titleTester.getValue());

        TagTester headingTester = TagTester.createTagByAttribute(pageResponse, "wicket:id", "pageHeading");
        Assertions.assertEquals("Page Heading", headingTester.getValue());
    }
}
