package com.capacity.control.application;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.ByteArrayOutputStream;

@Service
public class BarcodeGenerator
{
    public ByteArrayOutputStream generate (String barcodeText) throws BarcodeException
    {
        try
        {
            Barcode barcode = BarcodeFactory.createEAN13(barcodeText);
            barcode.setDrawingText(true);
            barcode.setResolution(800);
            barcode.setFont(new Font("Arial", Font.PLAIN, 18));
            barcode.setBarHeight(120);
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();

            BarcodeImageHandler.writeJPEG(barcode, outStream);
            return outStream;
        } catch (OutputException | BarcodeException e)
        {
            throw new BarcodeException("Error occurred trying to generate barcode", e);
        }

    }
}
