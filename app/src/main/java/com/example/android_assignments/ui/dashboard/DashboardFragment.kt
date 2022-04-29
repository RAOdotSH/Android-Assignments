package com.example.android_assignments.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.android_assignments.Quote
import com.example.android_assignments.R
import com.example.android_assignments.databinding.FragmentDashboardBinding

// List of Quotes and Authors from the API
val quoteData = ArrayList<Quote>()

// Index of the current quote
var currentQuote = 0

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val quoteText: TextView = root.findViewById(R.id.quote_text)
        val authorText: TextView = root.findViewById(R.id.author_name)

        // Calling the API
        val quoteAPI = JsonArrayRequest("https://programming-quotes-api.herokuapp.com/Quotes?count=10", {

            for(i in 0 until it.length()){
                val obj = it.getJSONObject(i)

                val quote = obj.getString("en")
                val author = obj.getString("author")
                val id = obj.getString("id")

                quoteData.add(Quote(id = id, author = author, quote = quote))
            }

            // function to display the quote and author
            displayQuote()

//            Toast.makeText(context, quoteData[0].quote, Toast.LENGTH_LONG).show()
        },
            {
                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
        })

        // Floating Action Button
        val nextFAB = root.findViewById<View>(R.id.next_quote_button)

        // OnClickListener for the FAB
        nextFAB.setOnClickListener {
            currentQuote++

            // If the current quote is greater than the length of the array,
            if(currentQuote > quoteData.size - 1){ currentQuote = 0 }

            displayQuote()
        }

        val reqQueue = Volley.newRequestQueue(context)

        reqQueue.add(quoteAPI)

        return root
    }

    // Function to display the quote and author
    private fun displayQuote(){
        val quoteOnj = quoteData[currentQuote]

        binding.quoteText.text = quoteOnj.quote
        binding.authorName.text = quoteOnj.author
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}