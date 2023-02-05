package com.example.myapplication

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.net.Uri
import android.app.DownloadManager
import java.io.InputStream
import org.json.JSONArray
import java.io.IOError
import java.io.IOException
import android.content.Intent
import android.content.IntentFilter
import android.widget.ListView
import android.widget.TextView
import android.widget.AdapterView
import android.widget.ArrayAdapter

import android.content.BroadcastReceiver
import android.content.Context



class MainActivity : AppCompatActivity() {
    var mydownloading : Long = 0
    var arr = arrayListOf<String>()
    var type = arrayListOf<String>()
    var contact = arrayListOf<String>()
    var contrag = arrayListOf<String>()
    var status = arrayListOf<String>()

    override fun onStart() {
        super.onStart()
        Download()
        ReadFileJSON()    }

    private fun ReadFileJSON() {
        var json : String? = null
        val textjson = findViewById<TextView>(R.id.textjson)
        val json_list = findViewById<ListView>(R.id.json_list)

        try {
            val inputStream: InputStream = assets.open("First.json")
            json = inputStream.bufferedReader().use { it.readText() }
            textjson.text = json


        }
        catch (e : IOException) {
            textjson.text = "Что то пошло не так"
            //ReadFiliJSON()
        }
        //Toast.makeText(this@MainActivity, "ЧитаемJSON", Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val btn = findViewById<Button>(R.id.helps).setOnClickListener{
            val mAlertDialog = AlertDialog.Builder(this@MainActivity)
            mAlertDialog.setTitle("ОписаниеПроекта")
            mAlertDialog.setMessage(R.string.rem)
            mAlertDialog.setIcon(R.mipmap.ic_launcher)

            mAlertDialog.setPositiveButton("Прочитал"){dialog, id ->
                Toast.makeText(this@MainActivity, "ИдутРаботы", Toast.LENGTH_LONG).show()
            }

            mAlertDialog.show()
        }
    }
    private fun Download(){
        //val url = "https://disk.yandex.ru/i/tmWmSFSPy-udbg"
        //val request = DownloadManager.Request(Uri.parse(url))
        //   .setTitle("title")
        //    .setDescription("Dis")
        //    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        //    .setAllowedOverMetered(true)
        //val dm = getSystemService(DOWNLOAD_SERVICE) as DownloadManager
        //dm.enqueue(request)
    }
}
