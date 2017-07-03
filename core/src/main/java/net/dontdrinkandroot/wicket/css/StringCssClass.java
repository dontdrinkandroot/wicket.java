/*
 * Copyright (C) 2012-2016 Philip Washington Sorst <philip@sorst.net>
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
package net.dontdrinkandroot.wicket.css;

import java.io.Serializable;

/**
 * A {@link CssClass} that is represented by a String.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class StringCssClass implements CssClass, Serializable
{
    private String classString;

    public StringCssClass(String classString)
    {
        this.classString = classString;
    }

    @Override
    public String getClassString()
    {
        return this.classString;
    }
}