package com.hj.io;

import java.io.*;

/**
 * 保存输入流到字节数组中达到复用输入流
 *
 * @author jie hong
 */
public class SavedStream {
    private byte[] data;

    public SavedStream(InputStream input) throws IOException {
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            copyStream(input, output);
            data = output.toByteArray();
        }
    }

    private void copyStream(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[4096];
        int len;
        while ((len = input.read(buffer)) != -1) {
            output.write(buffer, 0, len);
        }
        output.flush();
    }

    public InputStream getInputStream() {
        return new ByteArrayInputStream(data);
    }
}