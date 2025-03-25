package vcmsa.sibonga.mathapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }// end of ViewCompact

        //code starts here

        val input1 = findViewById<EditText>(R.id.editTextText)
        val input2 = findViewById<EditText>(R.id.editTextText2)
        val calculateButton = findViewById<Button>(R.id.button)
        val answer = findViewById<TextView>(R.id.textView)
        val radioGroup=findViewById<RadioGroup>(R.id.radioGroup)
        val radioAddition=findViewById<RadioButton>(R.id.radioAddition)
        val radioSubtraction=findViewById<RadioButton>(R.id.radioSubtraction)

        calculateButton.setOnClickListener {
         val num1String= input1.text.toString().trim()
         val num2String=input2.text.toString().trim()

        if(num1String.isEmpty()|| num2String.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        }

            val num1=num1String.toIntOrNull()
            val num2=num2String.toIntOrNull()


            if (num1 == null || num2 == null) {
                Toast.makeText(this, "Please enter valid whole numbers", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

              val result:Int
              val operation: String

              if(radioAddition.isChecked) {
                  result= num1+num2
                  operation="Addition"
              }   else if (radioSubtraction.isChecked) {
                  result= num1 - num2
                  operation="Subtraction"
              } else{
                  Toast.makeText(this,"Please select an operation",Toast.LENGTH_SHORT). show()
                  return@setOnClickListener
              }

                answer.text="$operation Result:$result"

        }
    }
}
