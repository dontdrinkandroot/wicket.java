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
package net.dontdrinkandroot.wicket.behavior;

import net.dontdrinkandroot.wicket.css.CssClass;
import net.dontdrinkandroot.wicket.model.CssClassClassStringModel;
import net.dontdrinkandroot.wicket.model.StringModel;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;

/**
 * Appends a <tt>class</tt> attribute to an element. Can be a String, A {@link CssClass} or a model of a {@link CssClass}.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class CssClassAppender extends AttributeAppender
{
    public CssClassAppender(final String classToAdd)
    {
        super("class", new StringModel(classToAdd), " ");
    }

    public CssClassAppender(CssClass cssClass)
    {
        super("class", new StringModel(cssClass.getClassString()), " ");
    }

    public CssClassAppender(IModel<? extends CssClass> cssClassModel)
    {
        super("class", new CssClassClassStringModel(cssClassModel), " ");
    }
}
