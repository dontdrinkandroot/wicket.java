package net.dontdrinkandroot.wicketexample.web.page.resources;

import net.dontdrinkandroot.wicketexample.web.page.DecoratorWidePage;

import org.apache.log4j.lf5.util.Resource;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.image.resource.DefaultButtonImageResource;
import org.apache.wicket.markup.html.link.ResourceLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.request.resource.SharedResourceReference;


public class ResourcesPage extends DecoratorWidePage<Void> {

	public ResourcesPage(final PageParameters parameters) {

		super(parameters);

		final ResourceReference dateImageResourceReference =
				new SharedResourceReference(Resource.class, "dateImage", null, null, null);

		this.add(new Image("packageResource", new PackageResourceReference(this.getClass(), "test.png")));
		this.add(new Image("sharedResource", new SharedResourceReference(this.getClass(), "test.png")));
		this.add(new Image("dynamicallyRenderedSharedResource", dateImageResourceReference));
		this.add(new Image("defaultButtonImage", new DefaultButtonImageResource("testLabel")));

		final PageParameters params = new PageParameters();
		params.set(0, new Long(1293885420000L));
		// params.set("tstamp", new Long(1293885420000L));

		final ResourceLink<?> sharedResourceWithParametersLink =
				new ResourceLink<Void>("sharedResourceWithParametersLink", dateImageResourceReference, params);

		this.add(sharedResourceWithParametersLink);
		final Image sharedResourceImage = new Image("sharedResourceWithParameters", dateImageResourceReference, params);
		sharedResourceWithParametersLink.add(sharedResourceImage);

		// new AbstractResource() {
		//
		// @Override
		// protected ResourceResponse newResourceResponse(Attributes attributes) {
		//
		// ResourceResponse resourceResponse = new ResourceResponse();
		// resourceResponse.setWriteCallback(new WriteCallback() {
		//
		// @Override
		// public void writeData(Attributes attributes) {
		//
		// }
		// });
		// return resourceResponse;
		// }
		//
		// };
	}

}
