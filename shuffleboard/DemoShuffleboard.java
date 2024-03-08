package frc.rainstorm.shuffleboard;

import java.util.function.DoubleSupplier;

public class DemoShuffleboard extends LightningShuffleboard {
    
    public static final String DEMO_TAB = "Demo";

    /**
     * 
     * @return DoubleSupplier value of the demo limit
     */
    public static DoubleSupplier createDemoLimit(String key, double defaultValue) {
        DoubleSupplier valSupplier = () -> getDouble(DEMO_TAB, key, defaultValue);
        valSupplier.getAsDouble();
        return valSupplier;
    }
}
