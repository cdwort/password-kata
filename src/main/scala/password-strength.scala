package com.amyunger.passwordstrength

/**
  * ## Password strength indicator
  *
  * ### Problem statement
  *
  * Create a program that determines the complexity of a given password based on
  * these rules:
  *
  * - A very weak password contains only numbers and is less than 8 characters
  * - A weak password contains only letters and is less than 8 characters
  * - Astrongpasswordcontainslettersandatleast1number and is at least 8 characters
  * - A very strong password contains letters, numbers, and special characters and
  *   is at least 8 characters.
  *
  * ### Example Output
  *
  *     The password '12345' is a very weak password
  *     The password 'abcdef' is a weak password
  *     The password 'abc123xyz' is a strong password
  *     The password '1337h@xor!' is a very strong password.
  *
  **/

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

