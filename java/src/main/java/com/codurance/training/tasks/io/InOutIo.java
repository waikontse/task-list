package com.codurance.training.tasks.io;

import java.io.BufferedReader;
import java.io.PrintWriter;

public record InOutIo(BufferedReader in,
                      PrintWriter out) {
}
