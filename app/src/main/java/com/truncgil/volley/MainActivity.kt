package com.truncgil.volley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.text)
// ...

// Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://finans.truncgil.com/v4/today.json"

// Request a string response from the provided URL.
        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->

                val truncgilFinance = Gson().fromJson(response, TruncgilFinance::class.java);

                textView.text = truncgilFinance.USD?.Selling;
            },
            Response.ErrorListener { textView.text =  "That didn't work!" })

// Add the request to the RequestQueue.
        queue.add(stringRequest)
    }
}

data class TruncgilFinance (
    @SerializedName("Update_Date") var updateDate : String? = null,
    @SerializedName("USD") var USD        : USD?    = USD(),
    @SerializedName("EUR") var EUR        : EUR?    = EUR(),
    @SerializedName("GBP") var GBP        : GBP?    = GBP(),


)

class GBP (
    @SerializedName("Buying") var Buying  : String? = null,
    @SerializedName("Type") var Type    : String? = null,
    @SerializedName("Selling" ) var Selling : String? = null,
    @SerializedName("Change"  ) var Change  : String? = null
)

data class USD (
    @SerializedName("Buying") var Buying  : String? = null,
    @SerializedName("Type") var Type    : String? = null,
    @SerializedName("Selling" ) var Selling : String? = null,
    @SerializedName("Change"  ) var Change  : String? = null
)
data class EUR (

    @SerializedName("Buying"  ) var Buying  : String? = null,
    @SerializedName("Type"    ) var Type    : String? = null,
    @SerializedName("Selling" ) var Selling : String? = null,
    @SerializedName("Change"  ) var Change  : String? = null

)

