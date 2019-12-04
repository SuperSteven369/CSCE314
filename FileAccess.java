// Author Name: Siyuan Yang
// This file gives access to the underlying data file and stores the data in the Workout class.
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class FileAccess {
    // Declare Variable
    static JFileChooser fc = new JFileChooser();
    
    public static boolean loadPrimes(Primes primes, String filename) {
        fc.setCurrentDirectory(new java.io.File(Config.DATAPATH));
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = new File(Config.DATAPATH + filename);
            try {
                // create a scanner for the file
                Scanner sc = new Scanner(file);
                while (sc.hasNextInt()) {
                    primes.addPrime(new BigInteger(sc.nextLine()));
                }
                sc.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
  
    public static boolean loadCrosses(Primes primes, String filename) {
        fc.setCurrentDirectory(new java.io.File(Config.DATAPATH));
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = new File(Config.DATAPATH + filename);
            try {
                // create a scanner for the file
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    String str = sc.nextLine();
                    String[] tokens = str.split(",");
                    primes.addCross(new Pair<BigInteger>(new BigInteger(tokens[0]), new BigInteger(tokens[1])));
                }
                sc.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
  
  public static boolean savePrimes(Primes primes, String filename)
  {
      fc.setCurrentDirectory(new java.io.File(Config.DATAPATH));
      fc.setDialogTitle("Save As");
      if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
          try {
            FileWriter fw = new FileWriter(Config.DATAPATH + filename);
            Primes.IterablePrimes it = primes.iteratePrimes();
            for (BigInteger b : it) {
                fw.write(b.toString());
                fw.write("\n");
            }
            fw.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
          return true;
      }
      return false;
  }
  
  public static boolean saveCrosses(Primes primes, String filename)
  {
      fc.setCurrentDirectory(new java.io.File(Config.DATAPATH));
      fc.setDialogTitle("Save As");
      if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
          try {
            FileWriter fw = new FileWriter(Config.DATAPATH + filename);
            Primes.IterableCrosses it = primes.iterateCrosses();
            for (Pair<BigInteger> pair : it) {
                fw.write(pair.left().toString());
                fw.write(",");
                fw.write(pair.right().toString());
                fw.write("\n");
            }
            fw.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
          return true;
      }
      return false;
  }
}