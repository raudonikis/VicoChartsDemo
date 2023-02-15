package com.example.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.patrykandpatrick.vico.compose.axis.horizontal.bottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.endAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.line.lineChart
import com.patrykandpatrick.vico.compose.chart.scroll.rememberChartScrollSpec
import com.patrykandpatrick.vico.core.axis.horizontal.HorizontalAxis
import com.patrykandpatrick.vico.core.entry.entryModelOf
import com.patrykandpatrick.vico.core.entry.entryOf
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChartsDemo()
        }
    }

    private val entryModel = entryModelOf(
        (1..31).map { entryOf(it, Random.nextInt(1, 200)) }
    )

    @Composable
    private fun ChartsDemo() {
        Chart(
            chart = lineChart(),
            model = entryModel,
            endAxis = endAxis(),
            bottomAxis = bottomAxis(
                tickPosition = HorizontalAxis.TickPosition.Center(
                    offset = 1,
                    spacing = 5
                )
            ),
            chartScrollSpec = rememberChartScrollSpec(isScrollEnabled = false)
        )
    }

    @Composable
    private fun ChartsWithValueFormatterDemo() {
        Chart(
            chart = lineChart(),
            model = entryModel,
            endAxis = endAxis(),
            bottomAxis = bottomAxis(
                valueFormatter = ChartAxisValueFormatter()
            ),
            chartScrollSpec = rememberChartScrollSpec(isScrollEnabled = false)
        )
    }

    @Preview(showBackground = true)
    @Composable
    private fun ChartsDemoPreview() {
        ChartsDemo()
    }

    @Preview(showBackground = true)
    @Composable
    private fun ChartsWithValueFormatterDemoPreview() {
        ChartsWithValueFormatterDemo()
    }
}