public class Converter {

    private static final String CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static int convertChar(char c) {
        int ret = CHARS.indexOf( c );
        if (ret == -1)
            throw new IllegalArgumentException( "Invalid character encountered: "+c);
        return ret;
    }

    public static long convert(String s) {
        if (s.length() != 10)
            throw new IllegalArgumentException( "String length must be 10, was "+s.length() );
        long ret = 0;
        for (int i = 0; i < s.length(); i++) {
            ret = (ret << 6) + convertChar( s.charAt( i ));
        }
        return ret;
    }


    public static void main(String[] args) {
        System.err.println(convert("5a5f4f78e73c825ed783c865"));
    }
}