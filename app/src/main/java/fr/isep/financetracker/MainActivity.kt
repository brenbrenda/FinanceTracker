package fr.isep.financetracker



import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.ScatterChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.ScatterData
import com.github.mikephil.charting.data.ScatterDataSet
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    lateinit var scatteredChart: ScatterChart
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // on below line we are initializing our all variables.
        scatteredChart = findViewById(R.id.idChart)

        // on below line we are disabling the
        // description of our scattered chart
        scatteredChart.description.isEnabled = false

        // on below line we are setting
        // draw grid background as false
        scatteredChart.setDrawGridBackground(false)

        // on below line we are setting
        // touch enabled for our chart
        scatteredChart.setTouchEnabled(true)

        // on below line we are setting
        // max highlight distance
        scatteredChart.maxHighlightDistance = 50f

        // on below line we are setting
        // drag enabled for our chart
        scatteredChart.isDragEnabled = true

        // on below line we are enabling
        // scale for our chart
        scatteredChart.setScaleEnabled(true)

        // on below line we are setting
        // max visibility value count
        scatteredChart.setMaxVisibleValueCount(200)

        // on below line we are setting
        // pinch zoom for our chart
        scatteredChart.setPinchZoom(true)

        // on below line we are creating a
        // variable to get out legend for our chart
        val legend = scatteredChart.legend

        // on below line we are setting vertical, horizontal
        // and orientation for our legend
        legend.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        legend.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
        legend.orientation = Legend.LegendOrientation.VERTICAL

        // on below line we are setting
        // draw inside for our legend
        legend.setDrawInside(false)

        // on below line we are setting
        // offset for our legend
        legend.xOffset = 5f

        // on below line we are getting
        // y axis for our chart
        val yl = scatteredChart.axisLeft

        // on below line we are
        // setting axis minimum
        yl.axisMinimum = 0f

        // on below line we are enabling
        // our right axis for our chart
        scatteredChart.axisRight.isEnabled = false

        // on below line we are getting x axis of our chart
        val xl = scatteredChart.xAxis

        // on below line we are setting draw grid lines
        xl.setDrawGridLines(false)

        // in below line we are creating an array list
        // for each entry of our chart.
        // we will be representing three values in our charts.
        // below is the line where we are creating three
        // lines for our chart.
        val values1: ArrayList<Entry> = ArrayList()
        val values2: ArrayList<Entry> = ArrayList()
        val values3: ArrayList<Entry> = ArrayList()

        for (i in 0..10) {
            values1.add(Entry(i.toFloat(), ((i * 2).toFloat())))
        }

        // on below line we are adding data to our charts for value 2.
        for (i in 11..21) {
            values2.add(Entry(i.toFloat(), ((i * 3).toFloat())))
        }

        // on below line we are adding data to our charts for value 3
        // on below line we are adding data to our charts.
        for (i in 21..31) {
            values3.add(Entry(i.toFloat(), ((i * 4).toFloat())))
        }

        // on below line we are creating a data set and giving it a type
        val set1 = ScatterDataSet(values1, "Point 1")

        // on below line we are setting share of our point on our graph
        set1.setColor(ColorTemplate.COLORFUL_COLORS[0])

        // on below line we are creating a new point
        // for our scattered chart
        val set2 = ScatterDataSet(values2, "Point 2")

        // on below line we are setting out shape to circle
        set2.setScatterShape(ScatterChart.ScatterShape.CIRCLE)

        // on below line we are setting color to our point in chart
        set2.scatterShapeHoleColor = ColorTemplate.COLORFUL_COLORS[3]

        // on below line we are setting scatter shape holder radius
        set2.scatterShapeHoleRadius = 3f

        // on below line we are setting color for our set
        set2.setColor(ColorTemplate.COLORFUL_COLORS[1])

        // on below line we are creating third data set for our chart
        val set3 = ScatterDataSet(values3, "Point 3")

        // on below line we are setting color for set 3
        set3.setColor(ColorTemplate.COLORFUL_COLORS[2])

        // on below line we are setting
        // shape size for all sets
        set1.scatterShapeSize = 8f
        set2.scatterShapeSize = 8f
        set3.scatterShapeSize = 8f

        // on below line we are creating a new list for our data set
        val dataSet: ArrayList<IScatterDataSet> = ArrayList()

        // on below line we are adding
        // all sets to our data sets
        dataSet.add(set1)
        dataSet.add(set2)
        dataSet.add(set3)

        // on below line we are creating a
        // new object for scattered data
        val data: ScatterData = ScatterData(dataSet)

        // on below line we are setting
        // data to our chart
        scatteredChart.data = data

        // on below line we are calling
        // invalidate to display our chart
        scatteredChart.invalidate()
    }


}


