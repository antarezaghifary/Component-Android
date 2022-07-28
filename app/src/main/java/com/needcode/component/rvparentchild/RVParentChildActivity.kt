package com.needcode.component.rvparentchild

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.needcode.component.R
import com.needcode.component.databinding.ActivityRvparentChildBinding


class RVParentChildActivity : AppCompatActivity() {

    private var myAdapter: ParentAdapter? = null

    private val binding by lazy {
        ActivityRvparentChildBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val parentItemArrayList: MutableList<ParentItem> = ArrayList()
        val childItemArrayList: MutableList<ChildItem> = ArrayList()

        with(binding) {
            val orderID = arrayOf("ZCD25374DEA", "DCF25354DEA", "FRW26544DEA", "FRE25874DEA")
            val itemName = arrayOf("Burger", "Manchurian", "Sandwich")
            val imageId = intArrayOf(
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3,
                R.drawable.image1
            )

            for (i in orderID.indices) {
                val parentItem =
                    ParentItem(orderID[i], (i + 14).toString(), (i * 43).toString(), imageId[i])
                parentItemArrayList.add(parentItem)

                //Child Item Object
                if (i < itemName.size) {
                    val childItem = ChildItem(
                        itemName[i], (i + 5).toString(), (i * 15).toString(),
                        imageId[i]
                    )
                    childItemArrayList.add(childItem)
                }
            }

            myAdapter = ParentAdapter(
                this@RVParentChildActivity,
                parentItemArrayList, childItemArrayList
            )
            val layoutManager = LinearLayoutManager(this@RVParentChildActivity)
            RVparent.layoutManager = layoutManager
            RVparent.adapter = myAdapter
        }
    }
}