package archive;

import java.io.*;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.Vector;

public class RandomiseMusic_v1 {

    private static void randomizeDir(String startDirectory) throws IOException {
        Vector<File> AllMusicFiles = get_music_files(startDirectory);
        Collections.shuffle(AllMusicFiles);
        int vectorLenght = AllMusicFiles.size();

        // Log file preparation
        Long time = new Date().getTime();
        String logFileName = "logFile_" + time + ".txt";
        logFileCreator logFile = new logFileCreator(startDirectory, logFileName);
        String absolutePath;
        String filePath;
        String newName;

        // Main cycle , we shuffle , change the names, and rename the file
        for (int i = 0; i < vectorLenght; i++) {
            File currentFile = AllMusicFiles.elementAt(i);
            String originalName = currentFile.getName();

            absolutePath = currentFile.getAbsolutePath();
            filePath = absolutePath.substring(0, absolutePath
                    .lastIndexOf(File.separator));

            newName = getNewName(originalName, i);
            File newNamedFile = new File(filePath + "//" + newName);
            System.out.println(filePath + " ----" + newName);
            // throw new java.io.IOException("file exists");
            if (newNamedFile.exists()) {
                System.out
                        .println("This file already exists, will not be renamed "
                                + newNamedFile.getAbsolutePath());
            } else {
                // Logging each line with before and after names and paths
                String PathOld = currentFile.getAbsolutePath();
                String[] tempList = {PathOld, PathOld.length() + "",
                        newNamedFile.getAbsolutePath()};

                // rename files , comment this for testing purposes
                boolean success = currentFile.renameTo(newNamedFile);
                if (success) {
                    logFile.logSingleLine(tempList);
                } else {
                    String[] tempListErr = {
                            "There was a problem with renaming the file  ",
                            "0", PathOld};
                    logFile.logSingleLine(tempListErr);
                }
            }
        }
        logFile.printTheLog();
    }

    // Ensures we pick only the mp3 files
    private static Vector<File> get_music_files(String startDirectory) {
        File startDir = new File(startDirectory);
        File[] AllFiles = startDir.listFiles();
        assert (AllFiles != null);
        int length = AllFiles.length;
        System.out.printf("Array size : %d%n ", length);
        Vector<File> TempArray = new Vector<>(length);

        for (File file : AllFiles) {
            String path = file.getAbsolutePath();
            Boolean flag = path.endsWith(".mp3");
            if (flag & file.isFile()) {
                TempArray.add(file);
            }
        }
        return TempArray;
    }

    // Must remove the numbers in front of the song name to add our numbers.
    // Gets the position of the first letter, ignores numbers and punctuation.
    // Returns new name
    private static String getNewName(String oldName, int songNextNumber) {
        int c = 0;

        while (!Character.isLetter(oldName.charAt(c))) {
            if (oldName.charAt(c) == '.') {
                c++;
                break;
            }
            c++;
        }

        String strippedName = oldName.substring(c);
        String newName;
        if (strippedName.isEmpty() || strippedName.equals("mp3")) {
            newName = (songNextNumber + 1) + "." + oldName;
        } else {
            newName = (songNextNumber + 1) + "." + strippedName;
        }
        return newName;

    }

    // Main method
    public static void main(String[] args) {
        try {

            if (args.length != 0 && args[0] != null && !args[0].isEmpty()
                    && args[0].contains("\\") && args[0].contains(":")) {
                randomizeDir(args[0]);
            } else {
                randomizeDir("C:\\MUSIC\\piratesMp3");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (java.lang.ArrayIndexOutOfBoundsException arr) {
            System.out.println("No paramters provided, exiting.");
        }
    }

    // <- End of log file creator

    // -> A new class for handling the log file creation and operation.
    private static class logFileCreator {
        private File logFile = null;
        private PrintStream fileWriter = null;
        private LinkedList<String[]> logBuffer = new LinkedList<>();

        logFileCreator(String path, String logFileName)
                throws IOException {
            initialiseFields(path, logFileName);
        }

        public logFileCreator(String path) throws IOException {
            initialiseFields(path, "logfile.txt");
        }

        private void initialiseFields(String path, String logFileName)
                throws IOException {
            String encoding = "utf-8";
            try {
                logFile = new File(path + "//" + logFileName);
                logFile.createNewFile();
                fileWriter = new PrintStream(logFile, encoding);
            } catch (FileNotFoundException f) {
                System.out
                        .println("Could not write a log file. File not found "
                                + logFile.getAbsolutePath());
            } catch (UnsupportedEncodingException unsupCode) {
                System.out.println("Unsupported encoding : " + encoding);
            }
        }

        Boolean logSingleLine(String[] logLine) throws IOException {
            return logBuffer.add(logLine);

        }

        // Print the entire buffered log, after that the log file is closed
        void printTheLog() throws IOException {
            int longestSong = 0;
            int len;
            for (String[] strArray : logBuffer) {
                len = strArray[0].length();
                if (longestSong < len) {
                    longestSong = len;
                }
            }
            String temp;
            for (String[] strPrint : logBuffer) {
                int spacesAdded = longestSong - Integer.getInteger(strPrint[1]);
                temp = String.format("%-" + spacesAdded + "s", strPrint[0]);
                fileWriter.println(temp + " ---> " + strPrint[2]);
            }
            this.closeFile();
        }

        private void closeFile() throws IOException {
            try {
                fileWriter.close();
            } catch (Exception e) {
                throw new IOException("Problem closing log file : " + logFile);
            }
        }
    }
}
