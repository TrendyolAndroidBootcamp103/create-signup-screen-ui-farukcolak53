package school.cactus.succulentshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textfield.TextInputLayout
import school.cactus.succulentshop.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    private val signUpEmailValidator = SignUpEmailValidator()
    private val signUpPasswordValidator = SignUpPasswordValidator()
    private val signUpUsernameValidator = SignUpUsernameValidator()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.sign_up)

        binding.apply {
            alreadyHaveAccountButton.setOnClickListener {
                finish() //Returns to the login screen
            }
            signUpButton.setOnClickListener {
                emailInputLayout.validate()
                passwordInputLayout.validate()
                usernameInputLayout.validate()
            }
        }
    }
    private fun TextInputLayout.validate() {
        val errorMessage = validator().validate(editText!!.text.toString())
        error = errorMessage?.resolveAsString()
        isErrorEnabled = errorMessage != null
    }

    private fun Int.resolveAsString() = getString(this)

    private fun TextInputLayout.validator() = when (this) {
        binding.emailInputLayout -> signUpEmailValidator
        binding.passwordInputLayout -> signUpPasswordValidator
        binding.usernameInputLayout -> signUpUsernameValidator
        else -> throw IllegalArgumentException("Cannot find any validator for the given TextInputLayout")
    }

}