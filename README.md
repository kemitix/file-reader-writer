# File Reader/Writer

![Sonatype Nexus (Release)](https://img.shields.io/nexus/r/https/oss.sonatype.org/net.kemitix/file-reader-writer.svg?style=for-the-badge)
![Maven Central](https://img.shields.io/maven-central/v/net.kemitix/file-reader-writer.svg?style=for-the-badge)

Simple wrapper for the static methods `Files.readAllLines` and `Files.write`,
bringing into simple classes that can be injected into code using Dependency 
Injection allowing them to be mocked during testing without touching the real 
filesystem.

## Assumptions

* All files will be read and written in `ÙTF-8`.
* When reading a file lines breaks will be replaced by the newline character.
* When writing a file it will be truncated first.

## Usage

### Jakarta EE

```java
@Produces
FileReaderWriter fileReaderWriter() {
    return new FileReaderWriter();
}
@Produces
FileReader fileReader() {
    return new FileReaderWriter();
}
@Produces
FileWriter fileWriter() {
    return new FileReaderWriter();
}
```

### Spring

```java
@Bean
FileReaderWriter fileReaderWriter() {
    return new FileReaderWriter();
}
@Bean
FileReader fileReader() {
    return new FileReaderWriter();
}
@Bean
FileWriter fileWriter() {
    return new FileReaderWriter();
}
```

