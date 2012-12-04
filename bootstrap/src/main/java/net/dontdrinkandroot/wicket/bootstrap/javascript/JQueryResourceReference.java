package net.dontdrinkandroot.wicket.bootstrap.javascript;

import org.apache.wicket.request.resource.PackageResourceReference;


public class JQueryResourceReference extends PackageResourceReference {

	public JQueryResourceReference() {

		super(JQueryResourceReference.class, "jquery-1.8.0.min.js");
	}

}
