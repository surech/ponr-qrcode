package ch.poinzofnoreturn;

import ch.poinzofnoreturn.qrcode.rest.QrCodeGenerator;
import ch.poinzofnoreturn.qrcode.rest.QrCodeScanner;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

/**
 * Konfiguriert die REST-Schnittellen
 */
@Configuration
public class RestConfiguration extends ResourceConfig {
    public RestConfiguration() {
        register(QrCodeScanner.class);
        register(QrCodeGenerator.class);
    }
}
