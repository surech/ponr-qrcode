package ch.poinzofnoreturn.qrcode.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

/**
 * REST-Schnittstelle für das Erkennen eines QR-Code
 */
@Path("/qrcode/scanner")
public class QrCodeScanner {

    @GET
    @Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello World";
    }
}
