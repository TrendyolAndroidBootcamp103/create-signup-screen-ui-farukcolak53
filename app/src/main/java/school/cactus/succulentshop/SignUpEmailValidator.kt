package school.cactus.succulentshop

class SignUpEmailValidator: Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.signup_email_error
        !field.contains(""".&@""".toRegex()) -> R.string.signup_invalid_email_error
        field.length < 5 -> R.string.signup_invalid_email_error
        field.length > 50 -> R.string.signup_invalid_email_error
        else -> null
    }
}