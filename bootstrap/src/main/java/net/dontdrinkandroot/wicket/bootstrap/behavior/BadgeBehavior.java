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
package net.dontdrinkandroot.wicket.bootstrap.behavior;

import net.dontdrinkandroot.wicket.behavior.CompositeBehavior;
import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BadgeStyle;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class BadgeBehavior extends CompositeBehavior
{
    public BadgeBehavior()
    {
        this(Model.of(BadgeStyle.SECONDARY));
    }

    public BadgeBehavior(BadgeStyle badgeStyle)
    {
        this(Model.of(badgeStyle));
    }

    public BadgeBehavior(IModel<BadgeStyle> badgeStyleModel)
    {
        super(new CssClassAppender(BootstrapCssClass.BADGE), new CssClassAppender(badgeStyleModel));
    }
}
