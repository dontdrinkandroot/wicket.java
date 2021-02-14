package net.dontdrinkandroot.wicket.bootstrap.css.grid

enum class ColumnSizeDefault : ColumnSize {
    COLUMNS_1, COLUMNS_2, COLUMNS_3, COLUMNS_4, COLUMNS_5, COLUMNS_6, COLUMNS_7, COLUMNS_8, COLUMNS_9, COLUMNS_10, COLUMNS_11, COLUMNS_12;

    override val classString: String
        get() = String.format("col-%d", ordinal + 1)

    override val inverseColumnOffset: ColumnOffset?
        get() = when {
            ordinal >= 11 -> null
            else -> ColumnOffsetDefault.values()[10 - ordinal]
        }

    override val inverseColumnSize: ColumnSize?
        get() = when {
            ordinal >= 11 -> null
            else -> values()[10 - ordinal]
        }
}