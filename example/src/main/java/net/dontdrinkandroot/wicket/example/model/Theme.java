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
package net.dontdrinkandroot.wicket.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Theme implements Serializable
{

    private String name;

    private String url;

    public Theme(String name, String url)
    {
        super();
        this.name = name;
        this.url = url;
    }

    public String getName()
    {
        return this.name;
    }

    public String getUrl()
    {
        return this.url;
    }

    public static List<Theme> getAvailableThemes()
    {
        String version = "3.3.6";
        List<Theme> availableThemes = new ArrayList<Theme>();
        availableThemes.add(
                new Theme(
                        "Vanilla",
                        String.format("https://maxcdn.bootstrapcdn.com/bootstrap/%s/css/bootstrap.min.css", version)
                ));

        List<String> bootswatchThemeNames = Arrays.asList(
                new String[]{
                        "Cerulean",
                        "Cosmo",
                        "Cyborg",
                        "Darkly",
                        "Flatly",
                        "Journal",
                        "Lumen",
                        "Paper",
                        "Readable",
                        "Sandstone",
                        "Simplex",
                        "Slate",
                        "Spacelab",
                        "Superhero",
                        "United",
                        "Yeti",});

        for (String name : bootswatchThemeNames) {
            String url = String.format(
                    "https://maxcdn.bootstrapcdn.com/bootswatch/%s/%s/bootstrap.min.css",
                    version,
                    name.toLowerCase()
            );
            availableThemes.add(new Theme(name, url));
        }

        return availableThemes;
    }
}
