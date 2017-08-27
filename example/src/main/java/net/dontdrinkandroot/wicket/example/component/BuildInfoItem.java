package net.dontdrinkandroot.wicket.example.component;

import net.dontdrinkandroot.wicket.bootstrap.component.item.ExternalLinkItem;
import net.dontdrinkandroot.wicket.example.ExampleWebApplication;
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
                Model.of(ExampleWebApplication.get().getBuildProperties().getProperty("version")),
                Model.of(String.format(
                        "https://github.com/dontdrinkandroot/wicket.java/commit/%s",
                        ExampleWebApplication.get().getBuildProperties().getProperty("revision")
                ))
        );
    }
}
