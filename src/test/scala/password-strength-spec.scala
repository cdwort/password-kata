package com.amyunger.passwordstrength
import org.scalatest.FunSpec

class PasswordStrengthSpec extends FunSpec {
  describe("PasswordStrength" {
    it("identifies weak passwords" {
      assert(PasswordStrength.determine_password_strength("123") === "Very Weak")
    })
  })
}
