package net.dontdrinkandroot.wicket.model.nio.file.attribute

import net.dontdrinkandroot.wicket.model.AbstractChainedModel
import org.apache.wicket.model.IModel
import java.nio.file.attribute.BasicFileAttributes

class BasicFileAttributesSizeModel(parent: IModel<BasicFileAttributes>) :
    AbstractChainedModel<BasicFileAttributes, Long>(parent) {

    override fun getValue(parentValue: BasicFileAttributes?) = parentValue?.size()
}