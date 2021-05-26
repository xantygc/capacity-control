package com.capacity.control.application;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class BarcodeGeneratorTest
{


    @Test
    public void generate () throws Exception
    {
        BarcodeGenerator barcodeGenerator = new BarcodeGenerator();
        ByteArrayOutputStream byteArrayOutputStream = barcodeGenerator.generate("400763000011");
        try(OutputStream outputStream = new FileOutputStream("thefilename")) {
            byteArrayOutputStream.writeTo(outputStream);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}