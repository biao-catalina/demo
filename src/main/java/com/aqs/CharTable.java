package com.aqs;


import java.io.InputStream;
import java.io.ObjectInputStream;

public class CharTable {

    public static void main(String[] args) {
        System.out.println(CharTable.normalize("（2018）藏25民终40号"));
    }

    public static final String CharTablePath = "CharTable.txt.bin";
    public static char[] CONVERT;

    static {
        try {
            loadBin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String normalize(String content) {
        String convert = CharTable.convert(content);
        return convert.replaceAll("\\(", "")
                .replaceAll("\\)", "")
                .replaceAll("《", "")
                .replaceAll("》", "");

    }


    private static void loadBin() throws Exception {
        InputStream inputStream = CharTable.class.getClassLoader().getResourceAsStream(CharTablePath);
        ObjectInputStream in = new ObjectInputStream(inputStream);
        CONVERT = (char[]) in.readObject();
        in.close();
    }


    public static String convert(String sentence) {
        assert sentence != null;

        char[] result = new char[sentence.length()];
        convert(sentence, result);
        return new String(result);
    }

    public static void convert(String charArray, char[] result) {
        for (int i = 0; i < charArray.length(); ++i) {
            result[i] = CONVERT[charArray.charAt(i)];
        }
    }


}


