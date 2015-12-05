package ch.poinzofnoreturn.qrcode.rest;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

/**
 * REST-Schnittstelle für das Erkennen eines QR-Code
 */
@Path("/qrcode/scanner")
public class QrCodeScanner {

    @POST
    @Produces("text/plain")
    @Consumes("*/*")
    public Response scan(InputStream input) {

        try {
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(input))));
            MultiFormatReader reader = new MultiFormatReader();
            Result result = reader.decode(bitmap);
            Response response = Response.ok().entity(result.getText()).build();
            return response;
        } catch (Exception e) {
            Response response = Response.status(Response.Status.NOT_ACCEPTABLE).build();
            return response;
        }
    }
}
