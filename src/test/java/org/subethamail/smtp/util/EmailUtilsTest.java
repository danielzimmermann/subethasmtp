package org.subethamail.smtp.util;

import org.junit.Assert;
import org.junit.Test;
import org.subethamail.smtp.internal.util.EmailUtils;

import static org.junit.Assert.assertEquals;

public class EmailUtilsTest {

    @Test
    public void testSpaceAddressIsNotValid() {
        Assert.assertFalse(EmailUtils.isValidEmailAddress(" "));
    }

    @Test
    public void testBlankAddressIsValid() {
        Assert.assertTrue(EmailUtils.isValidEmailAddress(""));
    }

    @Test
    public void testExtract() {
        assertEquals("anyone2@anywhere.com",
                EmailUtils.extractEmailAddress("TO:<anyone2@anywhere.com>", 3));
    }

    @Test
    public void testExtractWithNoLessThanSymbolAtStartOfEmailAndPrecedingSpace() {
        assertEquals("test@example.com",
                EmailUtils.extractEmailAddress("FROM: test@example.com", 5));
    }

    @Test
    public void testExtractWithNoLessThanSymbolAtStartOfEmailAndNoPrecedingSpace() {
        assertEquals("test@example.com",
                EmailUtils.extractEmailAddress("FROM:test@example.com", 5));
    }

    
    @Test
    public void testExtractWithNoLessThanSymbolAtStartOfEmailAndSIZECommand() {
        assertEquals("test@example.com",
                EmailUtils.extractEmailAddress("FROM:test@example.com SIZE=1000", 5));
    }
}
