package space.basyk.zametki.screens.addoffood

import android.app.DatePickerDialog
import android.content.Context
import android.media.ImageReader.newInstance
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_add_of_food.*
import kotlinx.android.synthetic.main.item_plan_of_food.*
import org.koin.android.viewmodel.ext.android.viewModel
import space.basyk.zametki.R
import space.basyk.zametki.databinding.FragmentAddOfFoodBinding
import space.basyk.zametki.databinding.FragmentAddShopBinding
import space.basyk.zametki.databinding.FragmentPlanOfEatBinding
import space.basyk.zametki.models.PlanOfFoodModel
import space.basyk.zametki.screens.addshop.AddShopViewModel
import space.basyk.zametki.utils.APP_ACTIVITY_MAIN
import java.lang.reflect.Array.newInstance
import java.util.*
import javax.xml.datatype.DatatypeFactory.newInstance
import javax.xml.parsers.DocumentBuilderFactory.newInstance

class AddOfFoodFragment : Fragment() {
    private var binding: FragmentAddOfFoodBinding?= null
    private val mBinding get() = binding!!
    private val viewModel: AddOfFoodViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddOfFoodBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun setDate(){

        var date: Calendar = Calendar.getInstance()
        var thisAYear = date.get(Calendar.YEAR)
        var thisAMonth = date.get(Calendar.MONTH)
        var thisADay = date.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(APP_ACTIVITY_MAIN, { view2, thisYear, thisMonth, thisDay ->
            // Display Selected date in textbox
            thisAMonth = thisMonth + 1
            thisADay = thisDay
            thisAYear = thisYear

            add_date.setText("$thisDay/$thisAMonth/$thisYear")
            val newDate:Calendar =Calendar.getInstance()
            newDate.set(thisYear, thisMonth, thisDay)

            //mh.entryDate = newDate.timeInMillis // setting new date
        }, thisAYear, thisAMonth, thisADay)
        dpd.show()
    }

    private fun initialization() {
        mBinding.addDate.setOnClickListener {
            setDate()
        }

        mBinding.addFoof.setOnClickListener {

            val date = mBinding.addDate.text.toString()

            val zavtrak = mBinding.foodZavtrak.text.toString()
            val obed = mBinding.foodObed.text.toString()
            val uzin = mBinding.foodUzin.text.toString()
            viewModel.insertFood(PlanOfFoodModel(date = date, zavtrakFood = zavtrak, obedFood = obed, uzinFood = uzin)){}
            APP_ACTIVITY_MAIN.navController.navigate(R.id.action_addOfFoodFragment_to_planOfEatFragment)
        }
    }
}