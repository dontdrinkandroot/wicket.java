package net.dontdrinkandroot.wicket.bootstrap.css.grid

enum class ColumnOffsetLarge : ColumnOffset {
    COLUMNS_1, COLUMNS_2, COLUMNS_3, COLUMNS_4, COLUMNS_5, COLUMNS_6, COLUMNS_7, COLUMNS_8, COLUMNS_9, COLUMNS_10, COLUMNS_11;

    override val classString: String
        get() = String.format("offset-%s-%d", prefix, ordinal + 1)

    override val inverseColumnSize: ColumnSize
        get() = ColumnSizeLarge.values()[10 - ordinal]

    override val inverseColumnOffset: ColumnOffset
        get() = values()[10 - ordinal]

    protected val prefix: String
        protected get() = "lg"
}