package com.example.demo

import com.patrykandpatrick.vico.core.axis.AxisPosition
import com.patrykandpatrick.vico.core.axis.formatter.AxisValueFormatter

class ChartAxisValueFormatter<Position : AxisPosition> : AxisValueFormatter<Position>,
    ChartValueFormatter()