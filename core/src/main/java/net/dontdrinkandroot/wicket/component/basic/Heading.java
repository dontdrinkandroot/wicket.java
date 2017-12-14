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
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.io.Serializable;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class Heading extends Label
{
    public enum Level
    {
        H1,
        H2,
        H3,
        H4,
        H5,
        H6
    }

    private final Level level;

    public Heading(final String id, Level level)
    {
        super(id);
        this.level = level;
    }

    public Heading(final String id, Serializable label, Level level)
    {
        super(id, Model.of(label));
        this.level = level;
    }

    public Heading(final String id, IModel<?> model, Level level)
    {
        super(id, model);
        this.level = level;
    }

    public Level getLevel()
    {
        return this.level;
    }

    @Override
    protected void onComponentTag(ComponentTag tag)
    {
        tag.setName(this.getLevel().name().toLowerCase());
        super.onComponentTag(tag);
    }
}
