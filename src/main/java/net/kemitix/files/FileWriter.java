package net.kemitix.files;


import java.io.File;
import java.io.IOException;

public interface FileWriter {

    /**
     * Writes the content to the file path, replacing any existing file.
     *
     * <p>File content will be written using UTF-8 encoding.</p>
     *
     * @param file    the file to write
     * @param content the content to write
     * @throws IOException if there is an error.
     */
    void write(
            File file,
            String content
    ) throws IOException;
}
