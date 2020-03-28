package net.kemitix.files;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class FileReaderWriterTests {

    private final String line1 = UUID.randomUUID().toString();
    private final String line2 = UUID.randomUUID().toString();
    private final String body = line1 + "\n" + line2;
    private final FileWriter writer = new FileReaderWriter();
    private final FileReader reader = new FileReaderWriter();
    @TempDir
    Path directory;
    private File file;

    @BeforeEach
    void setUp() {
        file = directory.resolve(UUID.randomUUID().toString())
                .toFile();
    }

    @Test
    @DisplayName("Create a new file then read it again")
    public void readTheNewlyCreatedFile() throws IOException {
        //when
        writer.write(file, body);
        final String read = reader.read(file);
        //then
        assertThat(read).isEqualTo(body);
    }

    @Test
    @DisplayName("Replace an existing file then read it again")
    public void readTheReplacedFile() throws IOException {
        //given
        writer.write(file, "Original file content");
        //when
        writer.write(file, body);
        final String read = reader.read(file);
        //then
        assertThat(read).isEqualTo(body);
    }

    @Test
    @DisplayName("When write to directory does not exist then throw exception")
    public void writeToMissingDirThrows() throws IOException {
        //given
        directory.toFile().setReadOnly();
        //then
        try {
            assertThatExceptionOfType(IOException.class)
                    .isThrownBy(() ->
                            writer.write(file, body))
                    .withMessage("Could not create file");
        } finally {
            directory.toFile().setWritable(true);
        }
    }
}