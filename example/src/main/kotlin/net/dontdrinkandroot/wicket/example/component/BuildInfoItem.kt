package net.dontdrinkandroot.wicket.example.component

import net.dontdrinkandroot.wicket.bootstrap.component.item.ExternalLinkItem
import net.dontdrinkandroot.wicket.example.ExampleWebApplication.Companion.get
import org.apache.wicket.model.Model

class BuildInfoItem(id: String) : ExternalLinkItem(
    id,
    Model.of(get().buildProperties.getProperty("version")),
    Model.of(
        String.format(
            "https://github.com/dontdrinkandroot/wicket.java/commit/%s",
            get().buildProperties.getProperty("revision")
        )
    )
)