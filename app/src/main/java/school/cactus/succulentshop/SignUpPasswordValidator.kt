package school.cactus.succulentshop

class SignUpPasswordValidator: Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.signup_password_error
        field.length < 7 -> R.string.signup_password_too_short
        field.length > 40 -> R.string.signup_password_too_long
        !field.contains("""[0-9]""".toRegex()) -> R.string.signup_password_must_contain
        !field.contains("""[a-z]""".toRegex()) -> R.string.signup_password_must_contain
        !field.contains("""[A-Z]""".toRegex()) -> R.string.signup_password_must_contain
        !field.contains("""[#?!@${'$'}%^&*-]""".toRegex()) -> R.string.signup_password_must_contain
        else -> null
    }
}