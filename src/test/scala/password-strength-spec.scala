package com.amyunger.passwordstrength
import org.scalatest.FunSpec

class PasswordStrengthSpec extends FunSpec {
  describe("PasswordStrength" {
    assert(PasswordStrength.determine_password_strength("123") == "Very Weak")
  })
}
