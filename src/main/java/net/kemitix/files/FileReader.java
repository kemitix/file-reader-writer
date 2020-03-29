package net.kemitix.files;

import java.io.File;
import java.io.IOException;

public interface FileReader {
    /**
     * Reads the content from the file path.
     *
     * <p>File content will be read using UTF-8 encoding and line endings will
     * be replaced with a newline (\n).</p>
     *
     * @param file the file to read
     * @return the contents of the file
     * @throws IOException if there is an error.
     */
    String read(File file) throws IOException;
}
