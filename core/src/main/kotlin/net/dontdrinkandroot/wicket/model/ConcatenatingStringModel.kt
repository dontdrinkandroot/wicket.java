package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class ConcatenatingStringModel : AbstractChainedModel<String, String> {

    private var suffixModel: IModel<String>
    private var separator: String? = null

    constructor(parent: IModel<String>, suffix: String?) : super(parent) {
        suffixModel = Model(suffix)
    }

    constructor(parent: IModel<String>, suffixModel: IModel<String>) : super(parent) {
        this.suffixModel = suffixModel
    }

    constructor(parent: IModel<String>, separator: String?, suffixModel: IModel<String>) : super(parent) {
        this.suffixModel = suffixModel
        this.separator = separator
    }

    override fun getValue(parentValue: String?): String {
        val suffix = suffixModel.getObject()
        val concatenatedString = StringBuilder()
        concatenatedString.append(parentValue)
        if (null != separator && null != suffix) {
            concatenatedString.append(separator)
        }
        if (null != suffix) {
            concatenatedString.append(suffix)
        }
        return concatenatedString.toString()
    }

    override fun detach() {
        super.detach()
        suffixModel.detach()
    }
}


