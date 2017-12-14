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

import net.dontdrinkandroot.wicket.bootstrap.headeritem.BootstrapJsHeaderItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class GlyphIconUpdater
{
    public static void main(String[] args) throws IOException
    {
        GlyphIconUpdater updater = new GlyphIconUpdater();
        updater.update();
    }

    private void update() throws IOException
    {
        URL lessUrl = new URL(String.format(
                "https://raw.githubusercontent.com/twbs/bootstrap/v%s/less/glyphicons.less",
                BootstrapJsHeaderItem.BOOTSTRAP_VERSION
        ));

        //        Pattern pattern = Pattern.compile("\\.glyphicon-([^\\s]*)");
        Pattern pattern = Pattern.compile("(.*)\\.glyphicon-([^\\s]*)(.*)");

        InputStream inputStream = lessUrl.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = reader.readLine();
        while (null != line) {
            //            System.out.println(line);
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                String css = matcher.group(2);
                String name = css.replace("-", "_").toUpperCase();
                //                System.out.println(css);
                //                System.out.println(name);
                System.out.println(name + "(\"glyphicon-" + css + "\"),");
            }
            line = reader.readLine();
        }
    }
}
