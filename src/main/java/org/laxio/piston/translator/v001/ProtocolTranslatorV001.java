package org.laxio.piston.translator.v001;

import org.laxio.piston.piston.translator.ProtocolTranslator;
import org.laxio.piston.piston.versioning.PistonModule;
import org.laxio.piston.piston.versioning.Version;
import org.laxio.piston.protocol.v340.StickyProtocolV340;

import java.io.IOException;

public class ProtocolTranslatorV001 implements ProtocolTranslator {

    private final PistonModule nativeModule;
    private final PistonModule translatedModule;

    public ProtocolTranslatorV001() throws IOException {
        this.nativeModule = PistonModule.build(StickyProtocolV340.class, "Implementation");
        this.translatedModule = PistonModule.build(StickyProtocolV340.class, "Implementation");
    }

    @Override
    public Version getTranslatedVersion() {
        return this.translatedModule.getVersion();
    }

    @Override
    public Version getNativeVersion() {
        return this.nativeModule.getVersion();
    }

}
