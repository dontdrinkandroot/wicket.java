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
package net.dontdrinkandroot.wicket.component.basic;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.markup.parser.XmlTag.TagType;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.io.Serializable;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ToStringLabel extends WebComponent
{
    public <T extends Serializable> ToStringLabel(final String id, T label)
    {
        this(id, new Model<T>(label));
    }

    public <T extends Serializable> ToStringLabel(final String id, IModel<T> model)
    {
        super(id, model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag)
    {
        this.replaceComponentTagBody(markupStream, openTag, this.getDefaultModelObjectAsString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onComponentTag(ComponentTag tag)
    {
        super.onComponentTag(tag);

        if (tag.isOpenClose()) {
            // always transform the tag to <span></span> so even labels defined as <span/> render
            tag.setType(TagType.OPEN);
        }
    }
}
