package com.KriegKorpse;

import java.util.ArrayList;

public class Main{

    public static void main(String[] args) {

        User Solas = new User();
        User Lyss = new User();

        String text = "Приеду завтра в полдень, Карпов Алексей Леонидович";
        System.out.println(" Original  " + text);

        RandomKey key = new RandomKey(text.length());
        System.out.println("       Key " + key.key);

        ArrayList<Byte> enc_bytes = Solas.Crypt(text, key.key);
        System.out.println(" enc_bytes " + enc_bytes);

        String decr_text = Lyss.Decrypt(enc_bytes, key.key);
        System.out.println(" decr_text " + decr_text);
    }
}

class User {
    private Alphabet alph = new Alphabet();

    private ArrayList<Byte> StrToByteArr(String text){
        ArrayList<Byte> byte_text = new ArrayList<Byte>();
        for(int i = 0; i < text.length(); i++){
            int chr = alph.indexOf(text.charAt(i));
            byte_text.add((byte)chr);
        }
        return byte_text;
    }

    private  ArrayList<Byte> ByteXOR(ArrayList<Byte> p_1, ArrayList<Byte> p_2){
        ArrayList<Byte> res = new ArrayList<Byte>();
        for(int i = 0; i < p_1.size(); i++){
            byte part = (byte)(p_1.get(i) ^ p_2.get(i));
            res.add(part);
        }
        return res;
    }

    public static String ByteArrToStr(ArrayList<Byte> arr, Alphabet alph){
        String text = new String();
        for(int i = 0; i < arr.size(); i++){
            //char chr = (char) arr.get(i);
            int ind_chr = ((int)arr.get(i).byteValue()) % alph.length();
            char chr = alph.charOf(ind_chr);
            text += chr;
        }
        return text;
    }

    public ArrayList<Byte> Crypt(String text, ArrayList<Byte> key) {
        ArrayList<Byte> byte_text = StrToByteArr(text);
        System.out.println(" Byte text " + byte_text);
        ArrayList<Byte> encrypted_bytes = ByteXOR(byte_text, key);
        return encrypted_bytes;
    }

    public String Decrypt(ArrayList<Byte> encrypted_bytes , ArrayList<Byte> key) {
        ArrayList decrypted_bytes = ByteXOR(encrypted_bytes, key);
        System.out.println("decr_bytes " + decrypted_bytes);
        String decrypted_text = ByteArrToStr(decrypted_bytes, alph);
        return decrypted_text;
    }
}

class RandomKey {
    private Alphabet alph = new Alphabet();
    public ArrayList<Byte> key = new ArrayList<Byte>();

    RandomKey(int length) {
        String arr = "";
        for(int i = 0; i < length; i++){
            int rand_i = (int) (Math.random()*(alph.length()-3)+2);
            byte chr = (byte)(alph.charOf(rand_i));
            key.add(chr);
        }
    }

}
