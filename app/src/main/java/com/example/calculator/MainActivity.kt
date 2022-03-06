package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var tvInput:TextView?=null
    var lastNum=false
    var lastDec=false
    var lastOp=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvInput=findViewById(R.id.tv)
    }

    fun onDigit(view: View) {
        lastNum=true
        lastDec=false
        lastOp=false
       tvInput?.append((view as Button).text)
    }
    fun onClr(view : View){
        lastOp=false
        lastDec=false
        lastNum=false
        tvInput?.text = ""
    }
    fun onBck(view: View){
        var s=tvInput?.text;
        if(s?.length!! <=1) {
            lastOp=false
            lastDec=false
            lastNum=false
            tvInput?.text = ""
        }
        else {
            s=s?.substring(0,s.length-1)
            tvInput?.text = s
            var c=s[s.length-1];
            if(c>='0'&&c<='9'){
                lastOp=false
                lastDec=false
                lastNum=true
            }else if(c=='+'||c=='-'||c=='/'||c=='*'){
                lastOp=true
                lastDec=false
                lastNum=false
            }else {
                lastOp=false
                lastDec=true
                lastNum=false
            }
        }
    }
    fun onDec(view: View){
        if(lastNum && !lastDec||!lastOp&&!lastNum&&!lastDec)tvInput?.append(".")
        lastDec=true
        lastNum=false
        lastOp=false
    }
    fun onOp(view: View){
        if(lastNum && !lastOp)tvInput?.append((view as Button).text)
        lastOp=true
        lastNum=false
        lastDec=false
    }
    fun onCal(view: View){
        var ans="";
        var s=tvInput?.text;
        var t=s?.length;
        tvInput?.setText("Server Down")
//        while(t!=0){
//
//        }
    }
}