import android.content.Context
import android.os.Bundle
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.brokerage.R
import com.example.brokerage.R.id.linearLayoutInput
import com.example.brokerage.ui.messagebox.ChatRecyclerAdapter

class MessageBox : AppCompatActivity() {

    private lateinit var linearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_box)

        val chat = listOf(
            "Lorem ipsum dolor sit amet, consectetur\n" +
                    "adipiscing elit, sed do eiusmod?",
            "tempor incididunt ut labore et dolore magna aliqua Ut enim ad minim veniam, quis nostrud.",
            "Lorem ipsum dolor sit amet, consectetur\n" +
                    "adipiscing elit, sed do eiusmod?"
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewChat)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ChatRecyclerAdapter(this, chat)

        val editText = findViewById<EditText>(R.id.typemsg)

        // Find the LinearLayout
        linearLayout = findViewById(R.id.linearLayoutInput)

        // Set an OnClickListener to the EditText
        editText.setOnClickListener {
            // Show the keyboard when the EditText is clicked
            showKeyboard(editText)
        }

        // Set a listener to detect changes in the layout
        linearLayout.viewTreeObserver.addOnPreDrawListener(object :
            ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                val heightDiff = linearLayout.rootView.height - linearLayout.height
                if (heightDiff > 100) {
                    // Keyboard is open, adjust the position of linearLayout
                    linearLayout.translationY = 0f
                } else {
                    // Keyboard is closed, move linearLayout to the bottom of the screen
                    linearLayout.translationY = heightDiff.toFloat()
                }
                return true
            }
        })
    }

    private fun showKeyboard(editText: EditText) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
    }
}
