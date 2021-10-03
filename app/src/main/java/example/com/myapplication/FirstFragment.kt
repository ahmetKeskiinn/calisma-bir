package example.com.myapplication

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class FirstFragment : Fragment() {
    private lateinit var button:Button
    private lateinit var editText: EditText
    private lateinit var textView: TextView
    private lateinit var editTextNumber : EditText
    private lateinit var textviewNumber : TextView
    private lateinit var root:View
    private lateinit var sharedClass: SharedClass
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_first, container, false)
        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialUI()
        changeData()
        clickListeners()
        super.onViewCreated(view, savedInstanceState)
    }
    private fun initialUI(){
        button = root.findViewById(R.id.button)
        editText = root.findViewById(R.id.editTextTextPersonName)
        textView = root.findViewById(R.id.textView)
        textviewNumber = root.findViewById(R.id.textView2)
        editTextNumber = root.findViewById(R.id.editTextNumber)
        sharedClass = SharedClass()
        this.context?.let { sharedClass.instancePref(it) }
    }
    private fun changeData(){
        if(!sharedClass.getString()?.isEmpty()!!){
           textView.text = sharedClass.getString().toString()
        }
        if(!sharedClass.getInt().toString().equals("")){
            textviewNumber.text = sharedClass.getInt().toString()
        }
    }

    private fun clickListeners(){
        button.setOnClickListener {
            sharedClass.addString(editText.text.toString())
            sharedClass.addInt(Integer.parseInt(editTextNumber.text.toString()))
        }
    }
}