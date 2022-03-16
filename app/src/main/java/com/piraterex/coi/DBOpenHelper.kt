package com.piraterex.coi

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.fragment.app.Fragment
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

class DBOpenHelper(val context: Context){

    companion object {

        //general
        val dbVersion = 1
        val dbName = "data"

        //table and columns
        val maincat_tbl = "maincat"
        val _id = "id"
        val _filter = "filter"
    }

    val database:SQLiteDatabase

    init {
        database = open()
    }

    private fun open(): SQLiteDatabase {
        val dbFile = context.getDatabasePath("$dbName.db")
        if (!dbFile.exists()){
            try {
                val checkDB = context.openOrCreateDatabase("$dbName.db", Context.MODE_PRIVATE,null)
                checkDB.close()
                copyDatabase(dbFile)
            }catch (e:IOException){
                throw RuntimeException("Error opening db")
            }
        }
        return SQLiteDatabase.openDatabase(dbFile.path, null, SQLiteDatabase.OPEN_READWRITE)
    }

    private fun copyDatabase(dbFile: File) {
        val iss = context.assets.open("$dbName.db")
        val os = FileOutputStream(dbFile)
        val buffer = ByteArray(1024)
        var i =0 ;
        generateSequence{ i = iss.read(buffer); if (i<0) null else i }
            .forEach {
                os.write(buffer, 0, i)
            }
        os.flush()
        os.close()
        iss.close()
    }

    fun close() {
        database.close()
    }
}