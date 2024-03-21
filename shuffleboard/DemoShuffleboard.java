package frc.rainstorm.shuffleboard;

import java.util.function.DoubleSupplier;

public class DemoShuffleboard extends LightningShuffleboard {
    
    public static String DEMO_TAB = "Demo";

    /**
     * Creates a new demo limit
     *
     * @return DoubleSupplier value of the demo limit
     */
    public static DoubleSupplier createDemoLimit(String key, double defaultValue) {
        DoubleSupplier valSupplier = () -> getDouble(DEMO_TAB, key, defaultValue);
        valSupplier.getAsDouble();
        return valSupplier;
    }

    /**
     * Sets the demo tab name
     *
     * @param name new name to set
     */
    public static void setDemoTabName(String name) {
        DEMO_TAB = name;
    }
}
