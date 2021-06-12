package tcp_reordering_20190421;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MohamedAshraf
 */
public class Client_TCP_Reordering_20190421 {

    Client_TCP_Reordering_20190421() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println(ip);
            Socket other = new Socket(ip, 22000);

            Scanner scan = new Scanner(System.in);

            DataInputStream otherReadSource = new DataInputStream(other.getInputStream());
            DataOutputStream otherWriteSource = new DataOutputStream(other.getOutputStream());

            String str = "";
            str = otherReadSource.readUTF();
            System.out.println(str);

            int[] Arr = new int[10];

            for (int i = 0; i < 10; i++) {
                Arr[i] = scan.nextInt();
                otherWriteSource.writeInt(Arr[i]);
            }

            for (int i = 0; i < 10; i++) {

                System.out.println("The Element num " + (i + 1) + " :  " + Arr[i]);
            }
            
            
            
            str = otherReadSource.readUTF();
            System.out.print(str);
            
            for(int i=0; i<9; i++)
            {
               Arr[i] = otherReadSource.readInt();
               System.out.print(Arr[i] + " , ");
            }
           int lastindex = otherReadSource.readInt();
           System.out.print(lastindex);
           
           
           System.out.println(" ");
           
           
           
           str = otherReadSource.readUTF();
            System.out.print(str);
            
            for(int i=0; i<9; i++)
            {
               Arr[i] = otherReadSource.readInt();
               System.out.print(Arr[i] + " , ");
            }
            lastindex = otherReadSource.readInt();
           System.out.print(lastindex);
           
           
           System.out.println(" ");
           
           
           
           

            otherWriteSource.close();
            otherReadSource.close();
            other.close();

        } catch (IOException ex) {
            Logger.getLogger(Client_TCP_Reordering_20190421.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
