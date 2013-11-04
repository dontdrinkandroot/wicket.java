package net.dontdrinkandroot.wicket.bootstrap.util;

import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssResourceReference;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapThemeCssResourceReference;
import net.dontdrinkandroot.wicket.bootstrap.javascript.BootstrapJsResourceReference;

import org.apache.wicket.protocol.http.WebApplication;


public class WebApplicationUtils {

	public static void mountBoostrapResources(WebApplication webApplication) {

		webApplication.mountResource("js/bootstrap.min.js", new BootstrapJsResourceReference());

		webApplication.mountResource("css/bootstrap.min.css", new BootstrapCssResourceReference());
		webApplication.mountResource("css/bootstrap-theme.min.css", new BootstrapThemeCssResourceReference());

		// TODO : Embed fonts
	}

}
