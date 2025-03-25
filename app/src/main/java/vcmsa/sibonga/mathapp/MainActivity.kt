package vcmsa.sibonga.mathapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
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

        //create the button listener or click action
        calculateButton.setOnClickListener {
         //Retrieve the inputs from the EditText fields
         val num1String= input1.text.toString()
         val num2String=input2.text.toString()

        //Check if both fields are not empty
        if(num1String.isNotEmpty()&& num2String.isNotEmpty()) {
         //Convert the input strings to integers
            val num1=num1String.toIntOrNull()
            val num2=num2String.toIntOrNull()

            //Check if both inputs are valid integers
            if (num1 != null&& num2 != null) {
              //Perform the addition
              val result= num1 + num2

              //Display the result in the TextView
              answer.text="Answer:$result"
            }else{
                //Show a Toast if the inputs are not valid integers
                Toast.makeText(this,"Please enter valid numbers",Toast.LENGTH_SHORT) .show()
            }
        } else{
            //Show a Toast if any of the input fields are empty
            Toast.makeText(this,"Please enter both numbers",Toast.LENGTH_SHORT) .show()
        }
        }
    }
}
