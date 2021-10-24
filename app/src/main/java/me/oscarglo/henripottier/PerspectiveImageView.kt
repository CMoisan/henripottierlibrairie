package me.oscarglo.henripottier

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet

class PerspectiveImageView(ctx: Context, attrs: AttributeSet): androidx.appcompat.widget.AppCompatImageView(ctx, attrs) {
    // Get perspective attribute
    private val perspective: Float = context.obtainStyledAttributes(attrs, intArrayOf(R.attr.perspective)).getFloat(0, 10f)

    override fun onDraw(canvas: Canvas?) {
        if (drawable != null) {
            val o = perspective * context.resources.displayMetrics.density
            val h = drawable.intrinsicHeight.toFloat()
            val w = drawable.intrinsicWidth.toFloat()

            // Skew matrix
            imageMatrix = imageMatrix.also { it.setPolyToPoly(
                floatArrayOf(0f, 0f, 0f, h, w, h, w, 0f), 0,
                floatArrayOf(0f, 0f, 0f, h, w, h - o, w, o), 0, 4
            ) }
        }
        super.onDraw(canvas)
    }
}