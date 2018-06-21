package mab.aerospikeworkshop.org;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.ClientPolicy;
import com.aerospike.client.policy.WritePolicy;

public class WorkshopAerospikeHelpers {

    private static AerospikeClient client;

    public static AerospikeClient getNewClient() {
        if (client==null) {
            ClientPolicy cPolicy = new ClientPolicy();
            cPolicy.maxConnsPerNode = 200;
            cPolicy.maxSocketIdle = 3; //3 seconds
            cPolicy.timeout = 500;

            client = new AerospikeClient(cPolicy, "18.196.201.87", 3000);
        }
        return client;
    }

    public static WritePolicy getDefaultWritePolicy() {
        WritePolicy writePolicy = new WritePolicy();
        writePolicy.setTimeout(100);
        return writePolicy;
    }
}
