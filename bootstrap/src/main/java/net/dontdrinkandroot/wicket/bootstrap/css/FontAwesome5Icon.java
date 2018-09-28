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
package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FontAwesome5Icon implements CssClass
{
    private boolean fixedWidth = false;

    private boolean spinning = false;

    private final FontAwesome5IconClass iconClass;

    public FontAwesome5Icon(FontAwesome5IconClass iconClass)
    {
        this.iconClass = iconClass;
    }

    @Override
    public String getClassString()
    {
        StringBuilder builder = new StringBuilder(this.iconClass.getClassString());
        if (this.fixedWidth) {
            builder.append(" fa-fw");
        }
        if (this.spinning) {
            builder.append(" fa-spin");
        }
        return builder.toString();
    }

    public FontAwesome5Icon setFixedWidth(boolean fixedWidth)
    {
        this.fixedWidth = fixedWidth;
        return this;
    }

    public FontAwesome5Icon setSpinning(boolean spinning)
    {
        this.spinning = spinning;
        return this;
    }
}
