package com.autobrain.utils;

public class ConvertCode {

    /**
     * @Title:bytes2HexString
     * @Description:字节数组转16进制字符串
     * @param b
     *            字节数组
     * @return 16进制字符串
     * @throws
     */
    public static String bytes2HexString(byte[] b) {

        StringBuffer result = new StringBuffer();
        String hex;
        for (int i = 0; i < b.length; i++) {
            hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            result.append(hex.toUpperCase());
        }
        return result.toString();
    }

    /**
     * @Title:bytes2HexString---2
     * @Description:字节数组转16进制字符串
     * @param b
     *            字节数组
     * @return 16进制字符串
     * @throws
     */
    public static String bytes2HexString2(byte[] b) {

        StringBuffer result = new StringBuffer();
        String hex;
        for (int i = 0; i < b.length; i++) {
            hex = Integer.toHexString(b[i] & 0xFF);
            result.append(hex.toUpperCase() + " ");
        }
        return result.toString();
    }

    /**
     * 将字节数组转换成16进制的字符数组
     * @param b
     * @return
     */
    public static String[] bytes2HexStringArray(byte[] b) {
        String[] strArray = null;
        try {
            strArray = new String[b.length];
            String hex;
            for (int i = 0; i < b.length; i++) {
                hex = Integer.toHexString(b[i] & 0xFF);
                if (hex.length() == 1) {
                    hex = '0' + hex;
                }
                hex = hex.toUpperCase();
                strArray[i] = hex;
            }
        } catch (Exception e) {

        }
        return strArray ;
    }

    /**
     * @Title:hexString2Bytes
     * @Description:16进制字符串转字节数组
     * @param src  16进制字符串
     * @return 字节数组
     */
    public static byte[] hexString2Bytes(String src) {
        int l = src.length() / 2;
        byte[] ret = new byte[l];
        for (int i = 0; i < l; i++) {
            ret[i] = (byte) Integer
                    .valueOf(src.substring(i * 2, i * 2 + 2), 16).byteValue();
        }
        return ret;
    }
    /**
     * @Title:string2HexString
     * @Description:字符串转16进制字符串
     * @param strPart  字符串
     * @return 16进制字符串
     */
    public static String string2HexString(String strPart) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < strPart.length(); i++) {
            int ch = (int) strPart.charAt(i);
            String strHex = Integer.toHexString(ch);
            hexString.append(strHex);
        }
        return hexString.toString();
    }
    /**
     * @Title:hexString2String
     * @Description:16进制字符串转字符串
     * @param src
     *            16进制字符串
     * @return 字节数组
     * @throws
     */
    public static String hexString2String(String src) {
        String temp = "";
        for (int i = 0; i < src.length() / 2; i++) {
            //System.out.println(Integer.valueOf(src.substring(i * 2, i * 2 + 2),16).byteValue());
            temp = temp+ (char)Integer.valueOf(src.substring(i * 2, i * 2 + 2),16).byteValue();
        }
        return temp;
    }

    /**
     * @Title:char2Byte
     * @Description:字符转成字节数据char-->integer-->byte
     * @param src
     * @return
     * @throws
     */
    public static Byte char2Byte(Character src) {
        return Integer.valueOf((int)src).byteValue();
    }

    /**
     * @Title:intToHexString
     * @Description:10进制数字转成16进制
     * @param a 转化数据
     * @param len 占用字节数
     * @return
     * @throws
     */
    public static String intToHexString(int a,int len){
        len<<=1;
        String hexString = Integer.toHexString(a);
        int b = len -hexString.length();
        if(b>0){
            for(int i=0;i<b;i++)  {
                hexString = "0" + hexString;
            }
        }
        return hexString;
    }


    /**
     * 将16进制的2个字符串进行异或运算
     * http://blog.csdn.net/acrambler/article/details/45743157
     * @param strHex_X
     * @param strHex_Y
     * 注意：此方法是针对一个十六进制字符串一字节之间的异或运算，如对十五字节的十六进制字符串异或运算：1312f70f900168d900007df57b4884
    先进行拆分：13 12 f7 0f 90 01 68 d9 00 00 7d f5 7b 48 84
    13 xor 12-->1
    1 xor f7-->f6
    f6 xor 0f-->f9
    ....
    62 xor 84-->e6
    即，得到的一字节校验码为：e6
     * @return
     */
    public static String xor(String strHex_X,String strHex_Y){
        //将x、y转成二进制形式
        String anotherBinary=Integer.toBinaryString(Integer.valueOf(strHex_X,16));
        String thisBinary=Integer.toBinaryString(Integer.valueOf(strHex_Y,16));
        String result = "";
        //判断是否为8位二进制，否则左补零
        if(anotherBinary.length() != 8){
            for (int i = anotherBinary.length(); i <8; i++) {
                anotherBinary = "0"+anotherBinary;
            }
        }
        if(thisBinary.length() != 8){
            for (int i = thisBinary.length(); i <8; i++) {
                thisBinary = "0"+thisBinary;
            }
        }
        //异或运算
        for(int i=0;i<anotherBinary.length();i++){
            //如果相同位置数相同，则补0，否则补1
            if(thisBinary.charAt(i)==anotherBinary.charAt(i))
                result+="0";
            else{
                result+="1";
            }
        }
        return Integer.toHexString(Integer.parseInt(result, 2));
    }


    /**
     *  Convert byte[] to hex string.这里我们可以将byte转换成int
     * @param src byte[] data
     * @return hex string
     */
    public static String bytes2Str(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
    /**
     * @param msg
     * @return 接收字节数据并转为16进制字符串
     */
    public static String receiveHexToString(byte[] msg) {
        try {
 			/*io.netty.buffer.WrappedByteBuf buf = (WrappedByteBuf)msg;
 			ByteBufInputStream is = new ByteBufInputStream(buf);
 			byte[] by = input2byte(is);*/
            String str = bytes2Str(msg);
            str = str.toLowerCase();
            return str;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("接收字节数据并转为16进制字符串异常");
        }
        return null;
    }

    /**
     * "7dd",4,'0'==>"07dd"
     * @param input 需要补位的字符串
     * @param size 补位后的最终长度
     * @param symbol 按symol补充 如'0'
     * @return
     * N_TimeCheck中用到了
     */
    public static String fill(String input, int size, char symbol) {
        while (input.length() < size) {
            input = symbol + input;
        }
        return input;
    }

    /**
     * 将16进制的String转成byte[]
     * @param hexString
     * @return
     */
    public static byte[] hexStrToBinaryStr(String hexString) {

        if ((hexString==null || hexString==" ")) {
            return null;
        }

        if (hexString.contains("0x") && hexString.contains(" ")) {
            hexString = hexString.replaceAll(" ", "");
            hexString = hexString.replaceAll("0x","");
        }else if (hexString.contains("0x") ){
            hexString = hexString.replaceAll("0x","");
        }else if (hexString.contains(" ") ){
            hexString = hexString.replaceAll(" ","");
        }

        int len = hexString.length();
        int index = 0;

        byte[] bytes = new byte[len / 2];

        while (index < len) {

            String sub = hexString.substring(index, index + 2);

            bytes[index/2] = (byte)Integer.parseInt(sub,16);

            index += 2;
        }
        return bytes;
    }
    /*public static void main(String args[]) {
        String productNo = "3030303032383838";
        System.out.println(hexString2String(productNo));
        productNo = "04050103000001070302050304";
        System.out.println(hexString2String(productNo));
    }*/
    //用Java语言实现对十六进制字符串异或运算http://blog.csdn.net/acrambler/article/details/45743157


    //进行回复和监听
           /* ctx.writeAndFlush(buffer).addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (future.isSuccess()) {
                        System.out.println("回写成功!");
                        System.out.println("=======================================");
                    } else {
                        System.out.println("回写失败!");
                        System.out.println("=======================================");
                    }
                }
            });*/
}
