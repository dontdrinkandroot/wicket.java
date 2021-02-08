package net.dontdrinkandroot.wicket.model

class ConcatenatingStringModel : AbstractChainedModel<String, String> {

    private var suffixModel: KModel<String?>
    private var separator: String? = null

    constructor(parent: KModel<String>, suffix: String?) : super(parent) {
        suffixModel = suffix.kModel()
    }

    constructor(parent: KModel<String>, suffixModel: KModel<String?>) : super(parent) {
        this.suffixModel = suffixModel
    }

    constructor(parent: KModel<String>, separator: String?, suffixModel: KModel<String?>) : super(parent) {
        this.suffixModel = suffixModel
        this.separator = separator
    }

    override fun getValue(parentValue: String): String {
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


