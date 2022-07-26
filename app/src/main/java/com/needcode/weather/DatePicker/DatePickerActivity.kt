package com.needcode.weather.DatePicker

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.needcode.weather.databinding.ActivityDatePickerBinding
import com.ozcanalasalvar.library.utils.DateUtils
import com.ozcanalasalvar.library.utils.DateUtils.getTimeMiles
import com.ozcanalasalvar.library.view.datePicker.DatePicker
import com.ozcanalasalvar.library.view.popup.DatePickerPopup
import com.ozcanalasalvar.library.view.popup.TimePickerPopup


class DatePickerActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDatePickerBinding.inflate(layoutInflater)
    }

    private var datePickerPopup: DatePickerPopup? = null
    private var timePickerPopup: TimePickerPopup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {

            btnTime.setOnClickListener {
                timePickerPopup = TimePickerPopup.Builder()
                    .from(this@DatePickerActivity)
                    .offset(3)
                    .textSize(17)
                    .setTime(12, 12)
                    .listener { timePicker, hour, minute ->
                        Toast.makeText(
                            applicationContext,
                            "$hour:$minute",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    .build()
                timePickerPopup?.show()
            }

            btnDate.setOnClickListener {
                datePickerPopup = DatePickerPopup.Builder()
                    .from(this@DatePickerActivity)
                    .offset(3)
                    .pickerMode(DatePicker.MONTH_ON_FIRST)
                    .textSize(19)
                    .endDate(getTimeMiles(2050, 10, 25))
                    .currentDate(DateUtils.getCurrentTime())
                    .startDate(getTimeMiles(1995, 0, 1))
                    .listener { dp, date, day, month, year ->
                        Toast.makeText(
                            applicationContext,
                            "" + day + "/" + (month + 1) + "/" + year,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    .build()

                datePickerPopup?.show()
            }
        }
    }
}