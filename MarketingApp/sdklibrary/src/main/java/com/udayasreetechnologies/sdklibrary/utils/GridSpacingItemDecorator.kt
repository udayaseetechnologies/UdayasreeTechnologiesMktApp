package com.udayasreetechnologies.sdklibrary.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class GridSpacingItemDecorator(val spacing : Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (outRect != null && view != null && parent != null) {
            val gridItemData = extractGridData(parent, view)
            val spanCount = gridItemData.spanCount
            val spanIndex = gridItemData.spanIndex
            val spanSize = gridItemData.spanSize
            outRect.left = (spacing * ((spanCount - spanIndex) / spanCount.toFloat())).toInt()
            outRect.right = (spacing * ((spanIndex + spanSize) / spanCount.toFloat())).toInt()
            outRect.top = spacing
        }
    }

    private fun extractGridData(parent: RecyclerView, view: View): GridItemData {
        val layoutManager = parent.layoutManager
        return if (layoutManager is GridLayoutManager) {
            extractGridLayoutData(layoutManager, view)
        } else if (layoutManager is StaggeredGridLayoutManager) {
            extractStaggeredGridLayoutData(layoutManager, view)
        } else {
            throw UnsupportedOperationException("Bad layout params")
        }
    }

    private fun extractGridLayoutData(layoutManager: GridLayoutManager, view: View): GridItemData {
        val lp = view.layoutParams as GridLayoutManager.LayoutParams
        return GridItemData(
            layoutManager.spanCount,
            lp.spanIndex,
            lp.spanSize
        )
    }

    private fun extractStaggeredGridLayoutData(layoutManager: StaggeredGridLayoutManager, view: View): GridItemData {
        val lp = view.layoutParams as StaggeredGridLayoutManager.LayoutParams
        return GridItemData(
            layoutManager.spanCount,
            lp.spanIndex,
            if (lp.isFullSpan) layoutManager.spanCount else 1
        )
    }

    private class GridItemData (val spanCount: Int, val spanIndex: Int, val spanSize: Int)
}