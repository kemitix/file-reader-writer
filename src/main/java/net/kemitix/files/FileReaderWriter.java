package net.kemitix.files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class FileReaderWriter implements FileReader, FileWriter {

    private static final String NEWLINE = "\n";

    @Override
    public String read(final File file) throws IOException {
        return String.join(NEWLINE,
                Files.readAllLines(file.toPath(), StandardCharsets.UTF_8));
    }

    @Override
    public void write(
            final File file,
            final String content
    ) throws IOException {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (final IOException e) {
                throw new IOException("Could not create file", e);
            }
        }
        Files.write(file.toPath(),
                content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.TRUNCATE_EXISTING
        );
    }
}
