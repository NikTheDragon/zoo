package com.epam.kurlovich.zoo.cloader;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class CCLoader extends ClassLoader {

    public CCLoader() {
        super(CCLoader.class.getClassLoader());
    }

    @Override
    public Class loadClass(String name) throws ClassNotFoundException {
        if (name.startsWith("com.epam.kurlovich.zoo.entity.impl")) {
            return getClass(name);
        }

        return super.loadClass(name);
    }

    private Class getClass(String name) throws ClassNotFoundException {
        String file = name.replace('.', File.separatorChar) + ".class";

        try {
            Class<?> fc = findLoadedClass(name);
            byte[] byteArr = loadClassData(file);

            Class c = defineClass(name, byteArr, 0, byteArr.length);
            resolveClass(c);

            return c;
        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }
    }

    private byte[] loadClassData(String name) throws IOException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(name);
        DataInputStream in = new DataInputStream(stream);
        int size = stream.available();
        byte buffer[] = new byte[size];

        in.readFully(buffer);
        in.close();

        return buffer;
    }
}
