package osauzo.ajiri.unitanduitests

import org.junit.Test
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun validEmail_correctFormat_returnsTrue() {
        val email = "123@abc.com"
        assertTrue(EmailValidator.isValidEmail(email))
    }

    @Test
    fun validEmail_subdomainFormat_returnsTrue() {
        val email = "123@abc.co.ca"
        assertTrue(EmailValidator.isValidEmail(email))
    }

    @Test
    fun invalidEmail_incorrectDomain_returnsFalse() {
        val email = "123@abc"
        assertFalse(EmailValidator.isValidEmail(email))
    }

    @Test
    fun invalidEmail_doubleDots_returnsFalse() {
        val email = "123@abc..com"
        assertFalse(EmailValidator.isValidEmail(email))
    }

    @Test
    fun invalidEmail_noUsername_returnsFalse() {
        val email = "@abc.com"
        assertFalse(EmailValidator.isValidEmail(email))
    }

    @Test
    fun invalidEmail_noDomain_returnsFalse() {
        val email = "testing123"
        assertFalse(EmailValidator.isValidEmail(email))
    }

    @Test
    fun invalidEmail_emptyString_returnsFalse() {
        val email = ""
        assertFalse(EmailValidator.isValidEmail(email))
    }

    @Test
    fun invalidEmail_null_returnsFalse() {
        val email: CharSequence? = null
        assertFalse(EmailValidator.isValidEmail(email))
    }
}