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
package net.dontdrinkandroot.wicket.choicerenderer;

import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;

import java.util.List;
import java.util.Locale;


public class CountryCodeCountryNameChoiceRenderer implements IChoiceRenderer<String>
{

    private Locale displayLocale;

    public CountryCodeCountryNameChoiceRenderer()
    {
    }

    public CountryCodeCountryNameChoiceRenderer(Locale displayLocale)
    {
        this.displayLocale = displayLocale;
    }

    @Override
    public Object getDisplayValue(String object)
    {
        if (null != this.displayLocale) {
            return new Locale("", object).getDisplayCountry(this.displayLocale);
        }

        return new Locale("", object).getDisplayCountry();
    }

    @Override
    public String getIdValue(String object, int index)
    {
        return object;
    }

    @Override
    public String getObject(String id, IModel<? extends List<? extends String>> choices)
    {
        return id;
    }

}
