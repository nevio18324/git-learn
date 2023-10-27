
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

    public class PasswordValidatorTest {
        private PasswordValidator uut;
        @BeforeEach
        public void setUp() {
            this.uut = new PasswordValidator();
        }
        @Test
        public void testPasswordNull() {
            assertFalse(this.uut.isPasswordValid(null));
        }

        @Test
        public void testPasswordTooShort() {
            assertFalse(this.uut.isPasswordValid("1234567"));
        }

        @Test
        public void testPasswordTooLong() {
            assertFalse(this.uut.isPasswordValid("ABCDEFGHIJKLMNOPQRSTU"));
        }

        @Test
        public void testPasswordContainsNoSpace() {
            assertFalse(this.uut.isPasswordValid("ABCDEFGHIJKLMNOPQR T"));
        }

        @Test
        public void testPasswordContainsNoNumeric() {
            assertFalse(this.uut.isPasswordValid("ABCDEFGHIJKLMNOPQRST"));
        }

        @Test
        public void testPasswordContainsNoLowercaseChar() {
            assertFalse(this.uut.isPasswordValid("ABCDEFGHIJ0123456789"));
        }

        @Test
        public void testPasswordContainsNoUppercaseChar() {
            assertFalse(this.uut.isPasswordValid("abcdefghij0123456789"));
        }

        @Test
        public void testPasswordContainsNoSpecialChar() {
            assertFalse(this.uut.isPasswordValid("abcdeFGHIJ0123456789"));
        }

        @Test
        public void testPasswordValid() {
            assertTrue(this.uut.isPasswordValid("abcdeFGHIJ01234$*%?+"));
        }
    }

