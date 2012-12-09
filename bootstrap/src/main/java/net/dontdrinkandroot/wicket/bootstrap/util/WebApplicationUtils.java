package net.dontdrinkandroot.wicket.bootstrap.util;

import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssResourceReference;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapResponsiveCssResourceReference;
import net.dontdrinkandroot.wicket.bootstrap.image.GlyphiconsResourceReference;
import net.dontdrinkandroot.wicket.bootstrap.image.GlyphiconsWhiteResourceReference;
import net.dontdrinkandroot.wicket.bootstrap.javascript.BootstrapJsResourceReference;

import org.apache.wicket.protocol.http.WebApplication;


public class WebApplicationUtils {

	public static void mountBoostrapResources(WebApplication webApplication) {

		webApplication.mountResource("js/bootstrap.js", new BootstrapJsResourceReference());
		webApplication.mountResource("css/bootstrap.min.css", new BootstrapCssResourceReference());
		webApplication.mountResource("css/bootstrap-responsive.min.css", new BootstrapResponsiveCssResourceReference());
		webApplication.mountResource("img/glyphicons-halflings.png", new GlyphiconsResourceReference());
		webApplication.mountResource("img/glyphicons-halflings-white.png", new GlyphiconsWhiteResourceReference());
	}

}
