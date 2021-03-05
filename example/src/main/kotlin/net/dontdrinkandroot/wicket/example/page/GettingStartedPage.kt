package net.dontdrinkandroot.wicket.example.page

import org.apache.wicket.model.Model

class GettingStartedPage : DecoratorPage<Void>() {

    override fun createPageHeadingModel() = Model("Getting started")
}