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
package net.dontdrinkandroot.wicket.example.model

import net.dontdrinkandroot.wicket.bootstrap.headeritem.BootstrapJsHeaderItem
import java.io.Serializable
import java.util.*

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
class Theme(val name: String, val url: String) : Serializable
{
    companion object
    {
        val availableThemes: List<Theme>
            get()
            {
                val availableThemes: MutableList<Theme> = ArrayList()
                availableThemes.add(
                    Theme(
                        "Vanilla", String.format(
                            "https://maxcdn.bootstrapcdn.com/bootstrap/%s/css/bootstrap.min.css",
                            BootstrapJsHeaderItem.BOOTSTRAP_VERSION
                        )
                    )
                )
                val bootswatchThemeNames = Arrays.asList(
                    "Cerulean",
                    "Cosmo",
                    "Cyborg",
                    "Darkly",
                    "Flatly",
                    "Journal",
                    "Litera",
                    "Lumen",
                    "LUX",
                    "Materia",
                    "Minty",
                    "Pulse",
                    "Sandstone",
                    "Simplex",
                    "Sketchy",
                    "Slate",
                    "Solar",
                    "Spacelab",
                    "Superhero",
                    "United",
                    "Yeti"
                )
                for (name in bootswatchThemeNames)
                {
                    val url = String.format(
                        "https://maxcdn.bootstrapcdn.com/bootswatch/%s/%s/bootstrap.min.css",
                        BootstrapJsHeaderItem.BOOTSTRAP_VERSION,
                        name.toLowerCase()
                    )
                    availableThemes.add(Theme(name, url))
                }
                return availableThemes
            }
    }
}