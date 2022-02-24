package www.smktelkommalang.sch.myintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)
        val btnMoveActivityData: Button = findViewById(R.id.btn_move_activity_with_data)
        btnMoveActivityData.setOnClickListener(this)
        val btnMoveActivityObject: Button = findViewById(R.id.btn_move_with_object_activity)
        btnMoveActivityObject.setOnClickListener(this)
    }
    override fun onClick(v: View){
        when (v.id){
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity,MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_with_data ->{
                val intent= Intent(this@MainActivity,MoveActivityWithData::class.java)
                intent.putExtra("data1","somestring data")
                intent.putExtra("data2","somestring data2")
                startActivity(intent)
            }
            R.id.btn_move_with_object_activity -> {
                val manusia = Person("Yafiq","Yafiq@gmail.com","Malang",18)
                val intent_object = Intent(this@MainActivity,MoveWithObjectActivity::class.java)
                intent_object.putExtra(MoveWithObjectActivity.EXTRA_PERSON, manusia)
                startActivity(intent_object)
            }
        }
    }
}