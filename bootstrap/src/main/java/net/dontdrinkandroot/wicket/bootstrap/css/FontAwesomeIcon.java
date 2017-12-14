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
public class FontAwesomeIcon implements CssClass
{
    private boolean fixedWidth = false;

    private boolean spinning = false;

    private Boolean outline = null;

    private String shape = null;

    private String direction = null;

    private final FontAwesomeIconClass iconClass;

    public FontAwesomeIcon(FontAwesomeIconClass iconClass)
    {
        this.iconClass = iconClass;
    }

    @Override
    public String getClassString()
    {
        StringBuilder builder = new StringBuilder("fa ");
        builder.append(this.iconClass.getClassString());
        if (this.shape != null) {
            builder.append("-");
            builder.append(this.shape);
        }
        if (this.outline != null && this.outline) {
            builder.append("-o");
        }
        if (this.direction != null) {
            builder.append("-");
            builder.append(this.direction);
        }
        if (this.fixedWidth) {
            builder.append(" fa-fw");
        }
        if (this.spinning) {
            builder.append(" fa-spin");
        }
        return builder.toString();
    }

    public FontAwesomeIcon setFixedWidth(boolean fixedWidth)
    {
        this.fixedWidth = fixedWidth;
        return this;
    }

    public FontAwesomeIcon setSpinning(boolean spinning)
    {
        this.spinning = spinning;
        return this;
    }

    public FontAwesomeIcon setOutline(Boolean outline)
    {
        this.outline = outline;
        return this;
    }

    public FontAwesomeIcon setShape(String shape)
    {
        this.shape = shape;
        return this;
    }

    public FontAwesomeIcon setDirection(String direction)
    {
        this.direction = direction;
        return this;
    }
}
