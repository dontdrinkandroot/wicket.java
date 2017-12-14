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
package net.dontdrinkandroot.wicket.css;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A {@link CssClass} that is composed of multiple CssClasses.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class CompositeCssClass implements CssClass
{
    private List<CssClass> cssClasses;

    public CompositeCssClass(CssClass... cssClasses)
    {
        this.cssClasses = Arrays.asList(cssClasses);
    }

    public CompositeCssClass(String... cssClassStrings)
    {
        this.cssClasses = new ArrayList<>(cssClassStrings.length);
        for (String cssClassString : cssClassStrings) {
            this.cssClasses.add(new StringCssClass(cssClassString));
        }
    }

    @Override
    public String getClassString()
    {
        return this.cssClasses.stream().map(CssClass::getClassString).collect(Collectors.joining(" "));
    }
}
