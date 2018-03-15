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
public enum ButtonStyle implements CssClass
{
    PRIMARY("btn-primary"),
    SECONDARY("btn-secondary"),
    SUCCESS("btn-success"),
    DANGER("btn-danger"),
    WARNING("btn-warning"),
    INFO("btn-info"),
    LIGHT("btn-light"),
    DARK("btn-dark"),
    LINK("btn-link"),

    OUTLINE_PRIMARY("btn-outline-primary"),
    OUTLINE_SECONDARY("btn-outline-secondary"),
    OUTLINE_SUCCESS("btn-outline-success"),
    OUTLINE_DANGER("btn-outline-danger"),
    OUTLINE_WARNING("btn-outline-warning"),
    OUTLINE_INFO("btn-outline-info"),
    OUTLINE_LIGHT("btn-outline-light"),
    OUTLINE_DARK("btn-outline-dark");

    private String classString;

    ButtonStyle(String classString)
    {
        this.classString = classString;
    }

    @Override
    public String getClassString()
    {
        return this.classString;
    }
}
