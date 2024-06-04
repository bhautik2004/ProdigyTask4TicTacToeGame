package com.example.prodigytask_4tictactoegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var flag = 0
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        restartbtn.setOnClickListener {
            newgame()
        }
    }
    fun check(view: View){
        val btncurrent = view as Button
        if (btncurrent.text == "") {
            count++

            if (flag == 0) {
                btncurrent.text = "X"
                flag = 1
            } else {
                btncurrent.text = "O"
                flag = 0
            }

            val b1 = button1.text.toString()
            val b2 = button2.text.toString()
            val b3 = button3.text.toString()
            val b4 = button4.text.toString()
            val b5 = button5.text.toString()
            val b6 = button6.text.toString()
            val b7 = button7.text.toString()
            val b8 = button8.text.toString()
            val b9 = button9.text.toString()

            if (b1 == b2 && b2 == b3 && b3 != "") {
                showmsg("Winner is ${b1}")
            } else if (b4 == b5 && b5 == b6 && b6 != "") {
                showmsg("Winner is ${b4}")
            } else if (b7 == b8 && b8 == b9 && b9 != "") {
                showmsg("Winner is ${b7}")
            } else if (b1 == b4 && b4 == b7 && b7 != "") {
                showmsg("Winner is ${b1}")
            } else if (b2 == b5 && b5 == b8 && b8 != "") {
                showmsg("Winner is ${b2}")
            } else if (b3 == b6 && b6 == b9 && b9 != "") {
                showmsg("Winner is ${b3}")
            } else if (b1 == b5 && b5 == b9 && b9 != "") {
                showmsg("Winner is ${b1}")
            } else if (b3 == b5 && b5 == b7 && b7 != "") {
                showmsg("Winner is ${b3}")
            }else if (count  == 9){
                showmsg("Its a Drawn..")
            }
        }

    }
    fun showmsg(msg:String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Game Over")
        builder.setMessage(msg)
        builder.setPositiveButton("Restart"){_,_ ->
            newgame()
        }
        builder.setNegativeButton("Quit") { _, _ ->
            finish()
        }
        builder.show()
    }
    fun newgame(){
        button1.text = ""
        button2.text = ""
        button3.text = ""
        button4.text = ""
        button5.text = ""
        button6.text = ""
        button7.text = ""
        button8.text = ""
        button9.text = ""
        flag = 0
        count = 0
    }
}