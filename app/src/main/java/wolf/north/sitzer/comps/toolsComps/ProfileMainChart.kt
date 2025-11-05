package wolf.north.sitzer.comps.toolsComps

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp

@Composable
fun WeeklyActivityChart(
    values: List<Float>,
    maxValue: Float? = null,
    barColor: Color = MaterialTheme.colorScheme.primary,
    label: String = "Workouts",
    modifier: Modifier = Modifier
) {
    val daysOfWeek = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

    Column(modifier = modifier) {
        // header with info
        Text(
            text = label,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
        )

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp)
        ) {
            val barWidth = size.width / (values.size * 2)
            val chartMaxValue = maxValue ?: (values.maxOrNull() ?: 1f)
            val barHeightRatio = if (chartMaxValue > 0f) size.height / chartMaxValue else 0f

            values.forEachIndexed { index, value ->
                val x = barWidth * (1 + index * 2)
                val barHeight = value * barHeightRatio
                val y = size.height - barHeight

                // chart rows
                drawRoundRect(
                    color = if (value > 0) barColor else barColor.copy(alpha = 0.2f),
                    topLeft = Offset(x, y),
                    size = Size(barWidth, barHeight),
                    cornerRadius = CornerRadius(8f, 8f)
                )

                // days
                drawContext.canvas.nativeCanvas.drawText(
                    daysOfWeek[index],
                    x + barWidth / 2,
                    size.height + 40f,
                    android.graphics.Paint().apply {
                        textAlign = android.graphics.Paint.Align.CENTER
                        textSize = 32f
                        color = android.graphics.Color.GRAY
                    }
                )
            }
        }
    }
}