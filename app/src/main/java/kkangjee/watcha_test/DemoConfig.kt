package kkangjee.watcha_test

import android.widget.Button
import com.giphy.sdk.analytics.GiphyPingbacks.context
import com.giphy.sdk.core.models.enums.MediaType
import com.giphy.sdk.ui.GPHContentType
import com.giphy.sdk.ui.views.GiphyGridView

object DemoConfig {
    var spanCount = 2
    var cellPadding = 0
    var mediaType = MediaType.gif
    var contentType = GPHContentType.gif
    var direction = GiphyGridView.VERTICAL
    var fixedSizeCells = false
    var showCheckeredBackground = true

}
