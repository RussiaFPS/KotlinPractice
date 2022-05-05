package ru.mirea.pr3_7

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.util.*

class TestTimePickerDialog(val param1:Boolean, val param2:Boolean): DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val c = Calendar.getInstance();
        val curHour = c.get(Calendar.HOUR_OF_DAY);
        val curMinute = c.get(Calendar.MINUTE);
        return TimePickerDialog(activity, {
                _, hour, minute ->
            TestFragment().setState(hour,minute,param1,param2)
        }, curHour, curMinute, false)
    }
}