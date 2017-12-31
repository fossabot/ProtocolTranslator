package org.laxio.piston.translator.v001;

import org.laxio.piston.piston.protocol.Packet;
import org.laxio.piston.piston.translator.ProtocolTranslator;
import org.laxio.piston.protocol.v340.StickyProtocolV340;

public class ProtocolTranslatorV001 implements ProtocolTranslator {

    private final StickyProtocolV340 nativeProtocol;
    private final StickyProtocolV340 translatedProtocol;

    public ProtocolTranslatorV001(StickyProtocolV340 nativeProtocol, StickyProtocolV340 translatedProtocol) {
        this.nativeProtocol = nativeProtocol;
        this.translatedProtocol = translatedProtocol;
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

}
