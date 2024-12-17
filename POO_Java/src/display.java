public class display {
    public static void main(String[] args) {
        bottle(100, true);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String bottle(float fillingPercent, boolean isOpen) {
        String result;
        String closeCap;
        String openCap;
        String bottom;
        String emptyLine;
        String fullLine;
        String fullBottom;

        emptyLine = "     |                     |\r\n";

        fullLine =  "     |\u001B[44m                     \u001B[0m|\r\n";

        bottom =    "     \\_____________________/\r\n";
        
        fullBottom = "     \\\u001B[44m_____________________\u001B[0m/\r\n";

        closeCap =  "            _________\r\n" +
                    "           |_-_-_-_-_|\r\n" +
                    "           |_________|\r\n" +
                    "            )_______(\r\n" +
                    "           (_________)\r\n" +
                    "      _____/         \\_____\r\n";
        
        openCap =   "                      \r\n" +
                    "                      \r\n" +
                    "             _  _  _  \r\n" +
                    "            )_______(\r\n" +
                    "           (_________)\r\n" +
                    "      _____/         \\_____\r\n";        
        
        result = "";
        //clearScreen();
        result += (isOpen) ? openCap : closeCap;
        for (int i = 0; i < 20 - (int)fillingPercent / 5; i++) {
            result += emptyLine;
        }
        for (int i = 1; i < (int)fillingPercent / 5; i++) {
            result += fullLine;
        }
        result += (fillingPercent > 0) ? fullBottom : bottom;
        System.out.println(result);
        return result;
    }
}
