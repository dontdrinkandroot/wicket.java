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
package net.dontdrinkandroot.wicket.model.java.time.temporal;

import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.WicketTestCase;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Locale;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class DateTimeFormatterModelTest extends WicketTestCase
{
    @Test
    public void testUnwrapped()
    {
        DateTimeFormatterModel model;

        model = new DateTimeFormatterModel(new Model<>());
        Assert.assertNull(model.getObject());

        model = new DateTimeFormatterModel(Model.of(LocalDateTime.of(2017, 1, 1, 12, 00)), "yyyy-MM-dd HH:mm:ss");
        Assert.assertEquals("2017-01-01 12:00:00", model.getObject());

        model = new DateTimeFormatterModel(Model.of(LocalDateTime.of(2017, 1, 1, 12, 0).toInstant(ZoneOffset.UTC)));
        Assert.assertEquals("2017-01-01T12:00:00Z", model.getObject());

        model = new DateTimeFormatterModel(
                Model.of(LocalDateTime.of(2017, 1, 1, 12, 0).toInstant(ZoneOffset.UTC)),
                "yyyy-MM-dd HH:mm:ss",
                ZoneId.of("Europe/Berlin")
        );
        Assert.assertEquals("2017-01-01 13:00:00", model.getObject());
    }

    @Test
    public void testWrapped()
    {
        DateTimeFormatterModel model =
                new DateTimeFormatterModel(Model.of(LocalDateTime.of(2017, 3, 1, 12, 00)), "d. MMM yyyy HH:mm");
        Label component = new Label("id", model)
        {
            @Override
            public Locale getLocale()
            {
                return Locale.GERMANY;
            }
        };

        String markup = ComponentRenderer.renderComponent(component).toString();
        Assert.assertEquals("<wicket:container wicket:id=\"id\">1. Mär 2017 12:00</wicket:container>", markup);

        component.detach();
    }
}
