package alekseybykov.portfolio.io;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Aleksey Bykov
 * @since 15.10.2019
 */
public class IOTestBase {

    protected File sourceFile;
    protected File destinationFile;
    protected File fixtureFile;

    private Path filePath;

    @BeforeEach
    @SneakyThrows
    private void createTempFile() {
        filePath = Paths.get("src", "test", "resources", "temp");
        sourceFile = filePath.resolve("source").toFile();
        destinationFile = filePath.resolve("destination").toFile();

        fixtureFile = filePath.getParent().resolve("fixture").resolve("fixture").toFile();
    }

    @AfterEach
    @SneakyThrows
    private void clearTempDirectory() {
        FileUtils.cleanDirectory(filePath.toAbsolutePath().toFile());
    }
}
