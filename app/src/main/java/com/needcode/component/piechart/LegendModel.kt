package com.needcode.component.piechart

class LegendModel {
    var color = 0
    var label: String? = null
    var value: String? = null

    fun setColor(color: Int): LegendModel {
        this.color = color
        return this
    }

    fun setLabel(label: String?): LegendModel {
        this.label = label
        return this
    }

    fun setValue(value: String?): LegendModel {
        this.value = value
        return this
    }
}