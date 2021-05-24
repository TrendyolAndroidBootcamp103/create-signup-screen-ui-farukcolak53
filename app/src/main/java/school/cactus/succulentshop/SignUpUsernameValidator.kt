package school.cactus.succulentshop

class SignUpUsernameValidator: Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.signup_username_error
        !field.contains("""^[a-z0-9_]+$""".toRegex()) -> R.string.signup_username_can_only_include
        field.length <= 2 -> R.string.signup_username_too_short
        field.length >= 20 -> R.string.signup_username_too_long
        else -> null
    }
}