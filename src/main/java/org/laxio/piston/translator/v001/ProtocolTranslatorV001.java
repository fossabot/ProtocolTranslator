package org.laxio.piston.translator.v001;

import org.laxio.piston.piston.PistonServer;
import org.laxio.piston.piston.protocol.Packet;
import org.laxio.piston.piston.translator.ProtocolTranslator;
import org.laxio.piston.piston.versioning.PistonModule;
import org.laxio.piston.piston.versioning.Version;
import org.laxio.piston.protocol.v340.StickyProtocolV340;

import java.io.IOException;

public class ProtocolTranslatorV001 implements ProtocolTranslator {

    private final PistonServer server;
    private final PistonModule minecraft;

    private final StickyProtocolV340 nativeProtocol;
    private final StickyProtocolV340 translatedProtocol;

    public ProtocolTranslatorV001(PistonServer server) throws IOException {
        this.server = server;
        this.minecraft = PistonModule.build(ProtocolTranslatorV001.class, "Specification");
        this.nativeProtocol = getOrCreateNative();
        this.translatedProtocol = getOrCreateTranslated();
    }

    @Override
    public PistonServer getServer() {
        return server;
    }

    @Override
    public Version getTranslatedMinecraftVersion() {
        return this.minecraft.getVersion();
    }

    @Override
    public int getNativeVersion() {
        return this.nativeProtocol.getVersion();
    }

    @Override
    public int getTranslatedVersion() {
        return this.translatedProtocol.getVersion();
    }

    @Override
    public boolean matches(Packet packet) {
        return packet.getVersion() == nativeProtocol.getVersion() && packet.getVersion() == translatedProtocol.getVersion();
    }

    @Override
    public Packet translateToNative(Packet packet) {
        throw new UnsupportedOperationException("This translator is not configured to translate packets");
    }

    @Override
    public Packet translateFromNative(Packet packet) {
        throw new UnsupportedOperationException("This translator is not configured to translate packets");
    }

    private StickyProtocolV340 getOrCreateNative() {
        StickyProtocolV340 protocol = (StickyProtocolV340) server.getProtocol(340);
        if (protocol == null) {
            protocol = new StickyProtocolV340();
            server.addProtocol(protocol);
        }

        return protocol;
    }

    private StickyProtocolV340 getOrCreateTranslated() {
        StickyProtocolV340 protocol = (StickyProtocolV340) server.getProtocol(340);
        if (protocol == null) {
            protocol = new StickyProtocolV340();
            server.addProtocol(protocol);
        }

        return protocol;
    }

}
