package com.gmail.s12348.evgen;

import java.io.IOException;
import java.io.PrintWriter;

@SaveTo(path = "f:\\Work Java\\HomeWorkPro1b\\file.txt")
public class TextContainer {
    protected String text="Hello prog.kiev.ua";

    @Saver
    public void save (String filepath) {
        try (PrintWriter pw = new PrintWriter(filepath)){
            pw.println(text);
        } catch (IOException e){
            System.out.println(e);
        }
    }
}
