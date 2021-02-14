package net.dontdrinkandroot.wicket.bootstrap.css.grid

class ColumnSizeStack(
    val columnSizeDefault: ColumnSize? = null,
    val columnSizeSmall: ColumnSize? = null,
    val columnSizeMedium: ColumnSize? = null,
    val columnSizeLarge: ColumnSize? = null
) : ColumnSize {

    override val classString: String
        get() {
            val classBuffer = StringBuffer()
            if (null != columnSizeDefault) {
                classBuffer.append(columnSizeDefault.classString)
                classBuffer.append(" ")
            }
            if (null != columnSizeSmall) {
                classBuffer.append(columnSizeSmall.classString)
                classBuffer.append(" ")
            }
            if (null != columnSizeMedium) {
                classBuffer.append(columnSizeMedium.classString)
                classBuffer.append(" ")
            }
            if (null != columnSizeLarge) {
                classBuffer.append(columnSizeLarge.classString)
                classBuffer.append(" ")
            }
            return classBuffer.toString().trim { it <= ' ' }
        }

    override val inverseColumnOffset: ColumnOffset
        get() {
            val columnOffsetDefault = columnSizeDefault?.inverseColumnOffset
            val columnOffsetSmall = columnSizeSmall?.inverseColumnOffset
            val columnOffsetMedium = columnSizeMedium?.inverseColumnOffset
            val columnOffsetLarge = columnSizeLarge?.inverseColumnOffset
            return ColumnOffsetStack(columnOffsetDefault, columnOffsetSmall, columnOffsetMedium, columnOffsetLarge)
        }

    override val inverseColumnSize: ColumnSize
        get() {
            val columnSizeDefault = columnSizeDefault?.inverseColumnSize
            val columnSizeSmall = columnSizeSmall?.inverseColumnSize
            val columnSizeMedium = columnSizeMedium?.inverseColumnSize
            val columnSizeLarge = columnSizeLarge?.inverseColumnSize
            return ColumnSizeStack(columnSizeDefault, columnSizeSmall, columnSizeMedium, columnSizeLarge)
        }

    companion object {

        /**
         * Reasonable defaults for a full screen horizontal form.
         */
        @JvmField
        val FORM_DEFAULT: ColumnSize =
            ColumnSizeStack(null, ColumnSizeSmall.COLUMNS_7, ColumnSizeMedium.COLUMNS_8, ColumnSizeLarge.COLUMNS_9)

        /**
         * Split large screen into two equally sized columns.
         */
        val TWO_COLUMNS: ColumnSize =
            ColumnSizeStack(null, ColumnSizeSmall.COLUMNS_6, ColumnSizeMedium.COLUMNS_6, ColumnSizeLarge.COLUMNS_6)
    }
}