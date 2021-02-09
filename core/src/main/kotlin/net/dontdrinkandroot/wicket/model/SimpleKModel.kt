package net.dontdrinkandroot.wicket.model

class SimpleKModel<T>(private var value: T) : KModel<T> {

    override fun getValue(): T = value

    override fun setValue(value: T) {
        this.value = value
    }
}