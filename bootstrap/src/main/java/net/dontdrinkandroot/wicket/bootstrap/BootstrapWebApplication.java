package net.dontdrinkandroot.wicket.bootstrap;

import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssResourceReference;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapResponsiveCssResourceReference;
import net.dontdrinkandroot.wicket.bootstrap.image.GlyphiconsResourceReference;
import net.dontdrinkandroot.wicket.bootstrap.image.GlyphiconsWhiteResourceReference;
import net.dontdrinkandroot.wicket.bootstrap.javascript.BootstrapJsResourceReference;
import net.dontdrinkandroot.wicket.bootstrap.util.WebApplicationUtils;

import org.apache.wicket.protocol.http.WebApplication;


public abstract class BootstrapWebApplication extends WebApplication {

	@Override
	protected void init() {

		super.init();
		WebApplicationUtils.mountBoostrapResources(this);
	}


	protected void mountBootstrapResources() {

		this.mountResource("js/bootrap.js", new BootstrapJsResourceReference());
		this.mountResource("css/bootstrap.min.css", new BootstrapCssResourceReference());
		this.mountResource("css/bootstrap-responsive.min.css", new BootstrapResponsiveCssResourceReference());
		this.mountResource("img/glyphicons-halflings.png", new GlyphiconsResourceReference());
		this.mountResource("img/glyphicons-halflings-white.png", new GlyphiconsWhiteResourceReference());
	}

}
