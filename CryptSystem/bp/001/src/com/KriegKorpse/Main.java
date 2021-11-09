package com.KriegKorpse;

import java.util.ArrayList;

public class Main{

    public static ArrayList<Byte> ByteXOR(ArrayList<Byte> p_1, ArrayList<Byte> p_2){
        ArrayList<Byte> res = new ArrayList<Byte>();
        for(int i = 0; i < p_1.size(); i++){
            byte part = (byte)(p_1.get(i) ^ p_2.get(i));
            res.add(part);
        }
        return res;
    }

    public static ArrayList<Byte> StrToByteArr(String text, Alphabet alph){
        ArrayList<Byte> byte_text = new ArrayList<Byte>();
        for(int i = 0; i < text.length(); i++){
            int chr = alph.indexOf(text.charAt(i));
            byte_text.add((byte)chr);
        }
        return byte_text;
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

    public static ArrayList<Byte> DeCrypt(ArrayList<Byte> encrypted, ArrayList<Byte> key){
        ArrayList<Byte> decrypted = ByteXOR(encrypted, key);
        return decrypted;
    }

    public static void main(String[] args) {

        User Solas = new User();
        User Lyss = new User();
        Alphabet alph = new Alphabet();
        String text = "Приеду завтра в полдень";
        System.out.println("Original " + text);
        ArrayList<Byte> byte_text = StrToByteArr(text, alph);
        System.out.println("Byte text " + byte_text);
        RandomKey key = new RandomKey(text.length(), alph);
        System.out.println("      Key " + key.key);
        ArrayList<Byte> encrypted_bytes = ByteXOR(byte_text, key.key);
        System.out.println("enc_bytes " + encrypted_bytes);
        String encrypted_text = ByteArrToStr(encrypted_bytes, alph);
        System.out.println("enc_text " + encrypted_text);
        ArrayList decrypted_bytes = DeCrypt(encrypted_bytes, key.key);
        System.out.println("decr_bytes " + decrypted_bytes);
        String decrypted_text = ByteArrToStr(decrypted_bytes, alph);
        System.out.println(" decr_text " + decrypted_text);




        /*for(int i = 0; i < 2000; i++) {
            RandomKey key = new RandomKey(text.length());
        }*/
        /*ArrayList<Byte> crypted = Solas.Crypt(text, key.key);
        String decrypted_text = Solar.Decrypt(crypted, key.key);*/


    }

}

class User {
    Alphabet alph = new Alphabet();

    /*public ArrayList<Byte> Crypt(String text, ArrayList<Byte> key) {

    }

    public String Decrypt(ArrayList<Byte> arr , ArrayList<Byte> key) {

    }*/
}

class RandomKey {
    public ArrayList<Byte> key = new ArrayList<Byte>();

    RandomKey(int length, Alphabet alph) {
        String arr = "";
        for(int i = 0; i < length; i++){
            int rand_i = (int) (Math.random()*(alph.length()-3)+2);
            byte chr = (byte)(alph.charOf(rand_i));
            /*if(chr == (byte) 127){
                System.out.println("OK");
            }*/
            key.add(chr);
        }
    }

}
