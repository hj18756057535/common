package com.hj.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 保存输入流到字节数组中达到复用输入流
 *
 * @author jie hong
 */
public class SavedStream {
    private byte[] data;

    public SavedStream(InputStream input) throws IOException {
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            IoUtils.copyStream(input, output);
            data = output.toByteArray();
        }
    }

    public InputStream getInputStream() {
        return new ByteArrayInputStream(data);
    }
}