package net.dontdrinkandroot.wicket.util

import org.apache.wicket.Component
import org.apache.wicket.util.visit.IVisit
import org.apache.wicket.util.visit.IVisitor

/**
 * Prints all component paths and their classes.
 */
class ComponentPathPrintingVisitor : IVisitor<Component, Void> {

    override fun component(component: Component, visit: IVisit<Void>) {
        println(String.format("%s: %s", component.pageRelativePath, component.javaClass))
    }
}