# volley-and-gson-android-kotlin-json-from-url
Parse JSON data from URL using Volley and GSON in Kotlin using Android Studio IDE


# 1
``` kotlin
implementation("com.android.volley:volley:1.2.1")
implementation 'com.google.code.gson:gson:2.8.5'
```

# 2

```kotlin
 val textView = findViewById<TextView>(R.id.text)
```

# 3 
```kotlin
// Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://finans.truncgil.com/v4/today.json"
```
# 4
```kotlin
// Request a string response from the provided URL.
        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->

                val truncgilFinance = Gson().fromJson(response, TruncgilFinance::class.java);

                textView.text = truncgilFinance.USD?.Selling;
            },
            Response.ErrorListener { textView.text =  "That didn't work!" })
```   
# 5
```kotlin
// Add the request to the RequestQueue.
        queue.add(stringRequest)
 ```   
        
# 6
```kotlin
 data class TruncgilFinance (
    @SerializedName("Update_Date") var updateDate : String? = null,
    @SerializedName("USD") var USD        : USD?    = USD(),
    @SerializedName("EUR") var EUR        : EUR?    = EUR(),
    @SerializedName("GBP") var GBP        : GBP?    = GBP(),


)
```

# 7 

```kotlin
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



