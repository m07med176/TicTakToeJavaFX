package tictaktoejavafx.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
public static boolean isValidIPAddress(String ip) {
          String ipRegex
                  = "(\\d{1,2}|(0|1)\\"
                  + "d{2}|2[0-4]\\d|25[0-5])";

          String regex
                  = ipRegex + "\\."
                  + ipRegex + "\\."
                  + ipRegex + "\\."
                  + ipRegex;

          Pattern pattern = Pattern.compile(regex);

          if (ip == null || ip.isEmpty()) {
               return false;
          }

          Matcher matcher = pattern.matcher(ip);

          return matcher.matches();
     }

    public static boolean isNumeric(String port) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (port == null || port.isEmpty()) {
            return false;
        }
        return pattern.matcher(port).matches();
    }
}

