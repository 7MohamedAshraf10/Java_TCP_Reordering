package tcp_reordering_20190421;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MohamedAshraf
 */
public class Server_TCP_Reordering_20190421 {

    Server_TCP_Reordering_20190421() {
        int[] Arr = new int[10];

        try {
            ServerSocket server = new ServerSocket(22000);

            while (true) {
                Socket client = server.accept();

                DataInputStream clientReadSource = new DataInputStream(client.getInputStream());
                DataOutputStream clientWriteSource = new DataOutputStream(client.getOutputStream());

                clientWriteSource.writeUTF("Enter Ur list");

                for (int i = 0; i < 10; i++) {
                    int index = clientReadSource.readInt();
                    System.out.println("The Element num" + (i + 1) + " :  " + index);
                    Arr[i] = index;
                }

                System.out.println(" ");

                //sorting the list of number ascending 
                clientWriteSource.writeUTF("Ascending Order: ");

                for (int i = 0; i < 10; i++) {
                    for (int j = i + 1; j < 10; j++) {
                        if (Arr[i] > Arr[j]) {
                            int temp = Arr[i];
                            Arr[i] = Arr[j];
                            Arr[j] = temp;

                        }
                    }

                }
                System.out.print("Ascending Order: ");
                for (int i = 0; i < 9; i++) {

                    System.out.print(Arr[i] + " , ");
                    clientWriteSource.writeInt(Arr[i]);
                }
                clientWriteSource.writeInt(Arr[9]);
                System.out.print(Arr[9]);

                System.out.println(" ");
                System.out.println(" ");

                //sorting the list descending
                clientWriteSource.writeUTF("descending Order: ");

                for (int i = 0; i < 10; i++) {
                    for (int j = i + 1; j < 10; j++) {
                        if (Arr[i] < Arr[j]) {
                            int temp = Arr[i];
                            Arr[i] = Arr[j];
                            Arr[j] = temp;
                        }
                    }
                }
                System.out.print("Descending Order: ");
                for (int i = 0; i < 9; i++) {
                    System.out.print(Arr[i] + " , ");
                     clientWriteSource.writeInt(Arr[i]);
                }
                clientWriteSource.writeInt(Arr[9]);
                System.out.print(Arr[9]);

                System.out.println(" ");

                clientWriteSource.close();
                clientReadSource.close();
                client.close();

            }

        } catch (IOException ex) {
            Logger.getLogger(Server_TCP_Reordering_20190421.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
