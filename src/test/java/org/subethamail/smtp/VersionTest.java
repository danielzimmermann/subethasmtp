package org.subethamail.smtp;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class VersionTest {

    @Test
    public void testImplementation() {
        assertNull(Version.getImplementation());
    }

    @Test
    public void testSpecification() {
        assertNull(Version.getSpecification());
    }
}