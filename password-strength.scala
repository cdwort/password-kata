object PasswordStrength {
  private val unknown_strength_response = "UNKNOWN"

  def main(args: Array[String]) = {
    if (args.isEmpty) {
      println("Please enter a password")
      sys.exit(1)
    } else {
      val password = args(0)
      println("Your Password: " + password)

      val strength = determine_password_strength(password)
      println("Password strength: " + strength)
    }
  }

  def determine_password_strength(password: String) : String = {
    if (password.length() <= 8)
      if (only_numbers(password))
        return "Very Weak"
      else if (only_letters(password))
        return "Weak"
      else
        return unknown_strength_response
    else
      if (has_all_the_things(password))
        return "Very Strong"
      else if (has_at_least_one_number_and_letter(password))
        return "Strong"
      else
        return unknown_strength_response
  }

  def only_numbers(password: String) : Boolean = {
    val only_numbers = "\\A[0-9]+\\Z"

    return password.matches(only_numbers)
  }

  def only_letters(password: String) : Boolean = {
    val only_letters = "\\A[A-Za-z]+\\Z"

    return password.matches(only_letters)
  }

  def has_at_least_one_number_and_letter(password: String) : Boolean = {
    val letters = "[A-Za-z]"
    val numbers = "[0-9]"

    return has_at_least_one_of(letters, password) && has_at_least_one_of(numbers, password)
  }

  def has_all_the_things(password: String) : Boolean = {
    val special_characters = "\\W"

    return has_at_least_one_number_and_letter(password) && has_at_least_one_of(special_characters, password)
  }

  def has_at_least_one_of(regex: String, password: String) : Boolean = {
    return password match {
      case regex.r.unanchored() => true
      case _ => false
    }
  }
}

