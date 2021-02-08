package net.dontdrinkandroot.wicket.model.nio.file.attribute

import net.dontdrinkandroot.wicket.model.AbstractChainedModel
import net.dontdrinkandroot.wicket.model.KModel
import java.nio.file.attribute.BasicFileAttributes

class BasicFileAttributesSizeModel(parent: KModel<BasicFileAttributes>) :
    AbstractChainedModel<BasicFileAttributes, Long>(parent) {

    override fun getValue(parentValue: BasicFileAttributes) = parentValue.size()
}