/*
 * Copyright (c) happyprg@gmail.com 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package me.design.pattern.method.reference;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

public class MethodReferenceTest {

    //data.txt
    //1
    //2
    public static final String RESOURCE_FILE_PATH = "data/data.txt";

    @Test
    public void testSingleLine() throws IOException, URISyntaxException {

        File file = new File(getClass().getClassLoader().getResource(RESOURCE_FILE_PATH).toURI());
        assertTrue("1".equals(process(file)));

    }

    public static String process(File file) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return br.readLine();
        }
    }

    @Test
    public void testFunctionalInterface() throws IOException, URISyntaxException {

        File file = new File(getClass().getClassLoader().getResource(RESOURCE_FILE_PATH).toURI());
        String result1 = processByFunctionalInterface(file,
                                                      (BufferedReader b) -> b.readLine());
        assertThat(result1, is("1"));

        String result2 = processByFunctionalInterface(file,
                                                      (BufferedReader b) -> b.readLine()
                                                                            + " NextLine " + b
                                                                                    .readLine());
        assertThat(result2, is("1 NextLine 2"));

    }

    public static String processByFunctionalInterface(File file, BufferedReaderProcessor p) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return p.process(br);
        }
    }

    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }

}
