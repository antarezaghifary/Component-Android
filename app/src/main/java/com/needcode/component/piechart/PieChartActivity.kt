package com.needcode.component.piechart

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.MPPointF
import com.needcode.component.R
import com.needcode.component.databinding.ActivityPieChartBinding

class PieChartActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityPieChartBinding.inflate(layoutInflater)
    }

    //private var adapterAtas: LegendAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            pieChart.setUsePercentValues(true)
            pieChart.description.isEnabled = false
            pieChart.setExtraOffsets(5f, 10f, 5f, 5f)

            pieChart.dragDecelerationFrictionCoef = 0.95f

            pieChart.isDrawHoleEnabled = true
            pieChart.setHoleColor(Color.WHITE)

            pieChart.setTransparentCircleColor(Color.WHITE)
            pieChart.setTransparentCircleAlpha(110)

            pieChart.holeRadius = 58f
            pieChart.transparentCircleRadius = 61f

            pieChart.setDrawCenterText(true)

            pieChart.rotationAngle = 0f

            pieChart.isRotationEnabled = true
            pieChart.isHighlightPerTapEnabled = true

            pieChart.animateY(1400, Easing.EaseInOutQuad)

            pieChart.legend.isEnabled = false
            pieChart.setEntryLabelColor(Color.WHITE)
            pieChart.setEntryLabelTextSize(12f)

            val entries: ArrayList<PieEntry> = ArrayList()
            entries.add(PieEntry(70f))
            entries.add(PieEntry(20f))
            entries.add(PieEntry(10f))

            /*val colors1 = ArrayList<Int>()
            val legendAtas = ArrayList<LegendModel>()

            val rnd = Random()
            colors1.add(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)))
            legendAtas.add(
                LegendModel()
                    .setLabel("Label")
                    .setValue("Value")
                    .setColor(colors1.size)
            )


            adapterAtas = LegendAdapter(legendAtas)
            rvLegendAtas.adapter = adapterAtas*/


            val dataSet = PieDataSet(entries, "Mobile OS")
            //dataSet.colors = colors1

            dataSet.setDrawIcons(false)

            dataSet.sliceSpace = 3f
            dataSet.iconsOffset = MPPointF(0f, 40f)
            dataSet.selectionShift = 5f

            val colors: ArrayList<Int> = ArrayList()
            colors.add(ContextCompat.getColor(applicationContext, R.color.purple_200))
            colors.add(ContextCompat.getColor(applicationContext, R.color.yellow))
            colors.add(ContextCompat.getColor(applicationContext, R.color.red))

            dataSet.colors = colors

            val data = PieData(dataSet)
            data.setValueFormatter(PercentFormatter())
            data.setValueTextSize(15f)
            data.setValueTypeface(Typeface.DEFAULT_BOLD)
            data.setValueTextColor(Color.WHITE)
            pieChart.data = data

            pieChart.highlightValues(null)

            pieChart.invalidate()


        }
    }
}