package com.codurance.training.tasks;

import com.codurance.training.tasks.io.InOutIo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintWriter;

import static java.lang.System.lineSeparator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public abstract class AbstractApplicationTest {
    public static final String PROMPT = "> ";
    private final PipedOutputStream inStream = new PipedOutputStream();
    private final PrintWriter inWriter = new PrintWriter(inStream, true);

    private final PipedInputStream outStream = new PipedInputStream();
    private final BufferedReader outReader = new BufferedReader(new InputStreamReader(outStream));

    private final Thread applicationThread;

    public AbstractApplicationTest() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new PipedInputStream(inStream)));
        PrintWriter out = new PrintWriter(new PipedOutputStream(outStream), true);

        applicationThread = new Thread(() -> {
            try {
                InOutIo inOutIo = new InOutIo(in, out);
                TaskListApplication.run(inOutIo);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });
    }

    @BeforeEach
    public void
    start_the_application() {
        applicationThread.start();
    }

    @AfterEach
    public void
    kill_the_application() throws IOException, InterruptedException {
        if (!stillRunning()) {
            return;
        }

        Thread.sleep(1000);
        if (!stillRunning()) {
            return;
        }

        applicationThread.interrupt();
        throw new IllegalStateException("The application is still running.");
    }

    protected void execute(String command) throws IOException {
        read(PROMPT);
        write(command);
    }

    protected void read(String expectedOutput) throws IOException {
        int length = expectedOutput.length();
        char[] buffer = new char[length];
        outReader.read(buffer, 0, length);
        assertThat(String.valueOf(buffer), is(expectedOutput));
    }

    protected void readLines(String... expectedOutput) throws IOException {
        for (String line : expectedOutput) {
            read(line + lineSeparator());
        }
    }

    protected void write(String input) {
        inWriter.println(input);
    }

    protected boolean stillRunning() {
        return applicationThread != null && applicationThread.isAlive();
    }
}
