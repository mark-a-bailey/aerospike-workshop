package mab.aerospikeworkshop.org;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.policy.WritePolicy;

public class MainPrograme {

    public static void main(String[] args) {
        System.out.println("Starting client ...");
        AerospikeClient client = WorkshopAerospikeHelpers.getNewClient();
        if (client == null || !client.isConnected()) {
            System.out.println("\nERROR: Connection to Aerospike cluster failed! Please check the server settings and try again!");
        }
        else {
            System.out.println("Connection to Aerospike cluster succeeded!");
        }

        MainPrograme mp = new MainPrograme();
        mp.runExercises(client);

        if (client!=null && client.isConnected()) {
            System.out.println("Closing client");
            client.close();
        }
    }

    public void runExercises(AerospikeClient client) {
        WritePolicy writePolicy = WorkshopAerospikeHelpers.getDefaultWritePolicy();

        //start test writing
        Key key = new Key("test", "users", "mark");
        Bin bin1 = new Bin("username", "mab");

        client.put(writePolicy, key, bin1);
    }
}
