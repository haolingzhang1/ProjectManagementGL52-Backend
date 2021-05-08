package fr.utbm.gl52.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {


    /**
     * **************************************************
     *
     * @author ling
     *         date: Avril 23, 2021
     *         <p/>
     *         ***************************************************
     */
//
//        private MD5Util() {
//        }

        /**
         * Returns a MessageDigest for the given <code>algorithm</code>.
         * <p/>
         * <p/>
         * The MessageDigest algorithm name.
         *
         * @return An MD5 digest instance.
         * @throws RuntimeException when a {@link NoSuchAlgorithmException} is
         *                          caught
         */

        static MessageDigest getDigest() {
            try {
                return MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

        /**
         * Calculates the MD5 digest and returns the value as a 16 element
         * <code>byte[]</code>.
         *
         * @param data Data to digest
         * @return MD5 digest
         */
        public static byte[] md5(byte[] data) {
            return getDigest().digest(data);
        }

        /**
         * Calculates the MD5 digest and returns the value as a 16 element
         * <code>byte[]</code>.
         *
         * @param data Data to digest
         * @return MD5 digest
         */
        public  static byte[] md5(String data) {
            return md5(data.getBytes());
        }

        /**
         * Calculates the MD5 digest and returns the value as a 32 character hex
         * string.
         *
         * @param data Data to digest
         * @return MD5 digest as a hex string
         */
        public static String md5Hex(byte[] data) {
            return HexUtil.toString(md5(data));
            //return HexUtil.toHexString(md5(data));
        }

        /**
         * Calculates the MD5 digest and returns the value as a 32 character hex
         * string.
         *
         * @param data Data to digest
         * @return MD5 digest as a hex string
         */
        public static String md5Hex(String data) {
            return HexUtil.toString(md5(data));
          // return HexUtil.toHexString(md5(data));
        }

        /***
         * MD5 generate 32bits md5code
         */
        public static String string2MD5(String inStr){
            MessageDigest md5 = null;
            try{
                md5 = MessageDigest.getInstance("MD5");
            }catch (Exception e){
                System.out.println(e.toString());
                e.printStackTrace();
                return "";
            }
            char[] charArray = inStr.toCharArray();
            byte[] byteArray = new byte[charArray.length];

            for (int i = 0; i < charArray.length; i++)
                byteArray[i] = (byte) charArray[i];
            byte[] md5Bytes = md5.digest(byteArray);
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++){
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16)
                    hexValue.append("0");
                hexValue.append(Integer.toHexString(val));
            }
            return hexValue.toString();

        }

        /**
         * algorithm pour encryption and decryption
         * once for encryption
         * twice for decryption
         */
        public static String convertMD5(String inStr){

            char[] a = inStr.toCharArray();
            for (int i = 0; i < a.length; i++){
                a[i] = (char) (a[i] ^ 't');
            }
            String s = new String(a);
            return s;

        }


    }

