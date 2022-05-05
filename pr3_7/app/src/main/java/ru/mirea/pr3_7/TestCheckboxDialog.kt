package ru.mirea.pr3_7

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class TestCheckboxDialog : DialogFragment(){
    val langs = arrayOf("Луна и звезды ночью", "Солнце днем")
    val checked= booleanArrayOf(true, true)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            AlertDialog.Builder(it)
                .setMultiChoiceItems(langs, checked){
                        dialog, which, isChecked ->
                    checked[which] = isChecked
                }
                .setPositiveButton("Ok"
                ) { dialog, which ->
                    val testTimeDialog = TestTimePickerDialog(checked[1],checked[0])
                    testTimeDialog.show(requireFragmentManager(),"custom")
                }
                .create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}