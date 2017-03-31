package net.dontdrinkandroot.wicket.example.component;

import net.dontdrinkandroot.wicket.bootstrap.component.item.ExternalLinkItem;
import net.dontdrinkandroot.wicket.example.ExampleApplication;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class BuildInfoItem extends ExternalLinkItem
{
    public BuildInfoItem(String id)
    {
        super(
                id,
                Model.of(ExampleApplication.get().getBuildProperties().getProperty("version")), Model.of(String.format(
                        "https://github.com/dontdrinkandroot/wicket.java/commit/%s",
                        ExampleApplication.get().getBuildProperties().getProperty("revision")
                ))
        );
    }
}
