package com.intermedia.challenge.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.intermedia.challenge.R
import com.intermedia.challenge.core.showToast
import com.intermedia.challenge.databinding.ActivityFirebaseUiactivityBinding

class FirebaseUIActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFirebaseUiactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirebaseUiactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkIfLogged()

        binding.btLogin.setOnClickListener {
            val email = binding.emailTextInputEditText.text.toString()
            val password = binding.passwordTextInputEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {

                showProgressBar()
                loginUser(email, password)

            } else {
                showToast(resources.getString(R.string.must_complete))
            }
        }
    }

    private fun checkIfLogged() {
        val user = FirebaseAuth.getInstance().currentUser

        if (user != null) {
            goToHome()
        }
    }

    private fun loginUser(email: String, password: String) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener {
            hideProgressBar()
            if (it.isSuccessful) {
                goToHome()
            } else {
                binding.emailTextInputLayout.error = "."
                binding.passwordTextInputLayout.error = "."
                val snackBar = Snackbar.make(
                    binding.constraint,
                    resources.getString(R.string.wrong_credentials),
                    Snackbar.LENGTH_LONG
                ).setAction("Action", null)

                snackBar.show()
            }
        }
    }

    private fun goToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
    }

    private fun showProgressBar() {
        binding.imgCircleProgress.visibility = View.VISIBLE
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.imgCircleProgress.visibility = View.GONE
        binding.progressBar.visibility = View.GONE
    }
}