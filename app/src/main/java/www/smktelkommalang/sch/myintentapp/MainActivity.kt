package www.smktelkommalang.sch.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var tvResult: TextView
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Hasil : $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)
        val btnMoveActivityData: Button = findViewById(R.id.btn_move_activity_with_data)
        btnMoveActivityData.setOnClickListener(this)
        val btnMoveActivityObject: Button = findViewById(R.id.btn_move_with_object_activity)
        btnMoveActivityObject.setOnClickListener(this)
        val btnDialNumber: Button = findViewById(R.id.btnCall)
        btnDialNumber.setOnClickListener(this)
        val btnMoveForResult: Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)
        tvResult = findViewById(R.id.tv_result)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_with_data -> {
                val intent = Intent(this@MainActivity, MoveActivityWithData::class.java)
                intent.putExtra("data1", "somestring data")
                intent.putExtra("data2", "somestring data2")
                startActivity(intent)
            }
            R.id.btn_move_with_object_activity -> {
                val manusia = Person("Yafiq", "Yafiq@gmail.com", "Malang", 18)
                val intent_object = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                intent_object.putExtra(MoveWithObjectActivity.EXTRA_PERSON, manusia)
                startActivity(intent_object)
            }
            R.id.btnCall -> {
                val phoneNumber = "0812345678"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_move_for_result -> {
                val moveForResultIntent = Intent(this@MainActivity, MoveForResultActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }
        }

    }


    }
