package org.example.structural.bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    public void testCar() {
        KiaMaker maker = new KiaMaker();
        Sedan sedan = new Sedan(maker);

        assertEquals("Sedan:Kia", sedan.getDescription());
    }
}
