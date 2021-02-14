package net.dontdrinkandroot.wicket.util

import org.apache.wicket.Component
import org.apache.wicket.util.visit.IVisit
import org.apache.wicket.util.visit.IVisitor

/**
 * Prints all components that are not stateless.
 */
class NonStatelessPrintingVisitor : IVisitor<Component, Void> {

    override fun component(component: Component, visit: IVisit<Void>) {
        if (!component.isStateless) {
            System.err.println(
                String.format(
                    "Component '%s' is not stateless. Type: %s, Path: %s",
                    component.markupId,
                    component.javaClass.canonicalName,
                    component.path
                )
            )
        }
    }
}