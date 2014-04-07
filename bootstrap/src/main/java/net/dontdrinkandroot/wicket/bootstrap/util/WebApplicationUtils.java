/**
 * Copyright (C) 2012, 2013 Philip W. Sorst <philip@sorst.net>
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
package net.dontdrinkandroot.wicket.bootstrap.util;

import net.dontdrinkandroot.wicket.bootstrap.fonts.GlyphiconEmbeddedOpenTypeResourceReference;
import net.dontdrinkandroot.wicket.bootstrap.fonts.GlyphiconSvgResourceReference;
import net.dontdrinkandroot.wicket.bootstrap.fonts.GlyphiconTrueTypeResourceReference;
import net.dontdrinkandroot.wicket.bootstrap.fonts.GlyphiconWoffResourceReference;

import org.apache.wicket.protocol.http.WebApplication;


public class WebApplicationUtils {

	public static void mountGlyphiconFonts(WebApplication webApplication) {

		webApplication.mountResource(
				"fonts/glyphicons-halflings-regular.eot",
				new GlyphiconEmbeddedOpenTypeResourceReference());
		webApplication.mountResource("fonts/glyphicons-halflings-regular.svg", new GlyphiconSvgResourceReference());
		webApplication.mountResource("fonts/glyphicons-halflings-regular.ttf", new GlyphiconTrueTypeResourceReference());
		webApplication.mountResource("fonts/glyphicons-halflings-regular.woff", new GlyphiconWoffResourceReference());
	}
}
