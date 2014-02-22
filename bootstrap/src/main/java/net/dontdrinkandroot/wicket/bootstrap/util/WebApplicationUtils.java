package net.dontdrinkandroot.wicket.bootstrap.util;

import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssResourceReference;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapThemeCssResourceReference;
import net.dontdrinkandroot.wicket.bootstrap.fonts.GlyphiconEmbeddedOpenTypeResourceReference;
import net.dontdrinkandroot.wicket.bootstrap.fonts.GlyphiconSvgResourceReference;
import net.dontdrinkandroot.wicket.bootstrap.fonts.GlyphiconTrueTypeResourceReference;
import net.dontdrinkandroot.wicket.bootstrap.fonts.GlyphiconWoffResourceReference;
import net.dontdrinkandroot.wicket.bootstrap.javascript.BootstrapJsResourceReference;

import org.apache.wicket.protocol.http.WebApplication;


public class WebApplicationUtils {

	public static void mountBoostrapResources(WebApplication webApplication) {

		webApplication.mountResource("js/bootstrap.min.js", new BootstrapJsResourceReference());

		webApplication.mountResource("css/bootstrap.min.css", new BootstrapCssResourceReference());
		webApplication.mountResource("css/bootstrap-theme.min.css", new BootstrapThemeCssResourceReference());
	}


	public static void mountGlyphiconFonts(WebApplication webApplication) {

		webApplication.mountResource(
				"fonts/glyphicons-halflings-regular.eot",
				new GlyphiconEmbeddedOpenTypeResourceReference());
		webApplication.mountResource("fonts/glyphicons-halflings-regular.svg", new GlyphiconSvgResourceReference());
		webApplication.mountResource("fonts/glyphicons-halflings-regular.ttf", new GlyphiconTrueTypeResourceReference());
		webApplication.mountResource("fonts/glyphicons-halflings-regular.woff", new GlyphiconWoffResourceReference());
	}
}
